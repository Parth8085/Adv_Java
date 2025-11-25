package com.demo.service;

import com.demo.beans.User;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	private LoginDao ldao;
	
	public LoginServiceImpl()
	{
		ldao = new LoginDaoImpl();
		
	}

	@Override
	public User validateUser(String name, String pass) {
		// TODO Auto-generated method stub
		return ldao.checkUser(name, pass);
	}

}
