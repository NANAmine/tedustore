package cn.tedu.store.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.ParameterNullException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;

//url:"/tedustore/user/checkLoginUsername.do"
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired // 将资源注入
	private IUserService userService;

	// 显示登录页面:web/login.jsp
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}

	// 显示登录页面:web/login.jsp
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";
	}
	
	
	@ResponseBody
	@RequestMapping("/checkLoginUsername.do")
	public String checkLoginUsername(String username) {
		//调用业务代码，判断时用户名是否可用/有效
		boolean isExist = userService.checkLoginUsername(username);
		if(isExist) {
			return "yes";
		} else {
			return "no";
		}
		
	}
	
	/*
	 * 注解@ResponseBody说明：
	 * 1.将方法返回结果，直接放入到响应体中
	 * 2.返回值类型如果是String，原封不动直接放到响应体中
	 * 3.返回值类型如果是其他类型
	 * 	  （1）classpath中有相应的messageConverter的实现类jar包（jackson-*.jar），将返回值转换为json格式的字符串，放入相应体
	 * 	  （2）classpath中没有相关的jar包，失败报错
	 */
	@ResponseBody
	@RequestMapping("/checkUsername.do")
	public ResponseResult<Void> checkUsername(String username) {
		//调用业务代码，判断时用户名是否可用/有效
		boolean isValid = userService.checkUsername(username);
		if(isValid) {
			return new ResponseResult<Void>(1,"用户名可以使用");
		} else {
			return new ResponseResult<Void>(0,"用户名已经被占用");
		}
		
	}
	@ResponseBody
	@RequestMapping("/checkEmail.do")
	public ResponseResult<Void> checkEmail(String email) {
		//调用业务代码，判断时用户名是否可用/有效
		boolean isValid = userService.checkEmail(email);
		if(isValid) {
			return new ResponseResult<Void>(1,"邮箱可以使用");
		} else {
			return new ResponseResult<Void>(0,"邮箱已经被注册");
		}
		
	}
	@ResponseBody
	@RequestMapping("/checkPhone.do")
	public ResponseResult<Void> checkPhone(String phone) {
		//调用业务代码，判断时用户名是否可用/有效
		boolean isValid = userService.checkPhone(phone);
		if(isValid) {
			return new ResponseResult<Void>(1,"手机号可以使用");
		} else {
			return new ResponseResult<Void>(0,"手机号已经被注册");
		}
		
	}

	/**
	 * 处理登录表单的提交， 即：开始检查用户输入的用户名和密码是否正确
	 * 
	 * @param username
	 * @param password
	 * @return @ResponseBody注解会将返回的字符串，添加到响应结果中
	 */
	@RequestMapping(value = "login.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String login(String username, String password, HttpSession session, HttpServletResponse response) {
		try {
			User user = userService.login(username, password);
			session.setAttribute("user", user);
			return "ok";
		} catch (UserNotFoundException | PasswordNotMatchException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}
	
	
	@RequestMapping(value = "register.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String register(@RequestParam("uname")String username, @RequestParam("upwd")String password, String email , String phone , HttpSession session, HttpServletResponse response) {
		System.out.println("username:" + username);
		try {
			userService.register(username, password, email, phone);
			return "ok";
		} catch (UserNotFoundException | PasswordNotMatchException | ParameterNullException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
			
		}
	}
	
	
}