package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.User;

public class LoginDaoImpl implements LoginDao {

	static  Connection conn ;
	static {
		conn= DBUtil.getMyConnection();
	}
	
	@Override
	public User checkUser(String name, String pass) {
		try {
			PreparedStatement seluser=conn.prepareStatement("select name,email,role from users where name=? and password=?");
			seluser.setString(1, name);
			seluser.setString(2, pass);
			ResultSet rs= seluser.executeQuery();
			if(rs.next())
			{
				User u= new User(rs.getString(1),rs.getString(2),rs.getString(3));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
