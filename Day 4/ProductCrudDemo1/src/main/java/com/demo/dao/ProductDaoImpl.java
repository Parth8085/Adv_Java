package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	static Connection conn;
	static PreparedStatement findAll;
	static {
		conn=DBUtil.getMyConnection();
		try {
			findAll = conn.prepareStatement("Select * from product");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product>plist=new ArrayList<>();
		
		try {
			ResultSet rs = findAll.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				Double price=rs.getDouble("price");
				int qty=rs.getInt("qty");
				Date expdate = rs.getDate("expdate");
				int cid=rs.getInt("cid");
				
				Product p = new Product(id, name, price, qty, expdate, cid);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return null;
		
		
		
	}
	public void closeMyConnection()
	{
		DBUtil.closeMyConnection();
		
	}

}
