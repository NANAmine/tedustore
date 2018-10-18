package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;

public class TestUserMapper {

	@Test
	public void testInsertUser() {
		//1.获得Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		System.out.println(" ");
		//2.取得UserMapper接口的实现类
		UserMapper mapper = ac.getBean("userMapper",UserMapper.class);
		//3.执行插入数据
		User user = new User();
		user.setUsername("test03");
		user.setPassword("test03");
		user.setEmail("test03@163.com");
		user.setPhone("12345678910");
		mapper.insert(user);
	}
	
	@Test
	public void testGetUserByUsername() {
		//1.获得Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		//System.out.println(ac);

		//2.取得UserMapper接口的实现类
		UserMapper mapper = ac.getBean("userMapper",UserMapper.class);
		//System.out.println(mapper);
		//org.apache.ibatis.binding.MapperProxy@61eaec38
		//3.执行数据查询
		User user1 = mapper.getUserByUsername("test01");
		System.out.println(user1);
		
	}
	
	@Test
	public void testGetUserByEmail() {
		//1.获得Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		//System.out.println(ac);

		//2.取得UserMapper接口的实现类
		UserMapper mapper = ac.getBean("userMapper",UserMapper.class);
		//System.out.println(mapper);
		//org.apache.ibatis.binding.MapperProxy@61eaec38
		//3.执行数据查询
		User user = mapper.getUserByEmail("123@163.com");
		System.out.println(user);
		//添加用户
	}	
		
	@Test
	public void testGetCount() {
		//1.获得Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		//System.out.println(ac);

		//2.取得UserMapper接口的实现类
		UserMapper mapper = ac.getBean("userMapper",UserMapper.class);
		//System.out.println(mapper);
		//org.apache.ibatis.binding.MapperProxy@61eaec38
		//3.执行数据查询
	}	
	
}
