package com.demo.service;

import com.demo.beans.User;

public interface UserService {

	User authenticate(String email, String password);

}
