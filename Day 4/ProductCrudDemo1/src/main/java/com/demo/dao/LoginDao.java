package com.demo.dao;

import com.demo.beans.User;

public interface LoginDao {

	User checkUser(String name, String pass);

}
