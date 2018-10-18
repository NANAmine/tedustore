package cn.tedu.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.ParameterNullException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;

//类中很多方法我觉得可以加上正则表达式判断格式是否正确，这里为了快速完成作业没有写，
//还有我觉得参数应该是对象，而不是对象的各个参数

@Service
public class UserService implements IUserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public boolean checkLoginUsername(String username) {
		Integer num = userMapper.getCountByUsername(username);
		// TODO Auto-generated method stub
		return num == 1;
	}

	@Override
	public User login(String username, String password) {
		// 检查数据的有效性
		if (username == null || username.equals("")) {
			throw new UserNotFoundException("用户名不能为空");
		}
		if (password == null || password.equals("")) {
			throw new PasswordNotMatchException("密码不能为空");
		}

		// 业务判断处理
		User user = userMapper.getUserByUsername(username);
		if (user == null) {
			throw new UserNotFoundException("用户不存在");
		} else {
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				throw new PasswordNotMatchException("密码错误");
			}
		}
	}

	/**
	 * 检查用户名是否可用
	 */
	@Override
	public boolean checkUsername(String username) {

		if (username == null || username.equals("")) {
			return false;
		}

		Integer num = userMapper.getCountByUsername(username);
		return num == 0;
	}

	@Override
	public boolean checkEmail(String email) {
		if (email == null || email.equals("")) {
			return false;
		}
		Integer num = userMapper.getCountByEmail(email);
		return num == 0;
	}

	@Override
	public boolean checkPhone(String phone) {
		if (phone == null || phone.equals("")) {
			return false;
		}
		Integer num = userMapper.getCountbyPhone(phone);
		return num == 0;
	}

	@Override
	public void register(String username, String password, String email, String phone){
		try {
			if(!(this.checkUsername(username) && this.checkEmail(email) && this.checkPhone(phone))) {
				throw new ParameterNullException("参数为null或\"\"");
			}
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			userMapper.insert(user);
		}
		catch(UserNotFoundException | PasswordNotMatchException | ParameterNullException e) {
			throw e;
		}
		
		
	}

}