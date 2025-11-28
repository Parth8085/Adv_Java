package com.demo.service;
import com.demo.dao.*;

import com.demo.beans.User;

public class UserServiceImpl implements UserService {
	

	@Override
	public User authenticate(String email, String password) {
		UserDao dao= new UserDaoImpl();
		
		return dao.login(email,password);
	}

}
