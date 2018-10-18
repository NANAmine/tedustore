package cn.tedu.store.mapper;

import cn.tedu.store.bean.User;

public interface UserMapper {
	/**
	 * 添加一个用户信息到数据库中
	 */
	void insert(User user);
	/**
	 * 根据用户名，查询用户信息
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username) ;
	/**
	 * 根据邮箱，查询用户信息
	 * @param username
	 * @return
	 */
	User getUserByEmail(String email) ;
	/**
	 * 获得共有多少个注册用户
	 * @return
	 */
	Integer getUserNum() ;
	/**
	 * 查询 用户名 对应了几条记录
	 * @param username
	 * @return
	 */
	Integer getCountByUsername(String username);
	Integer getCountByEmail(String email);
	Integer getCountbyPhone(String phone);
}