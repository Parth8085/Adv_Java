package com.demo.dao;

import com.demo.beans.User;

public interface UserDao {

	User login(String email, String password);

}
