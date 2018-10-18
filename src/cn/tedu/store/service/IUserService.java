package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {

	boolean checkLoginUsername(String username);

	User login(String username, String password);
	
	void register(String username , String password, String email, String phone);

	boolean checkUsername(String username);

	boolean checkEmail(String email);

	boolean checkPhone(String phone);

}