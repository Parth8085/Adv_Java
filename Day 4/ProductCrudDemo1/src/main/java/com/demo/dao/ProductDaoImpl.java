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

public class ProductDaoImpl implements ProductDao {
	static Connection conn;
	static PreparedStatement findAll,deleteById,selById, updateById,insProduct;
	static {
		conn = DBUtil.getMyConnection();
		try {
			findAll = conn.prepareStatement("Select * from product");
			deleteById=conn.prepareStatement("delete from product where id=?");
			updateById=conn.prepareStatement("update product set name=?,price=?,qty=?,expdate=?,cid=? where id=?");
			selById= conn.prepareStatement("Select * product where id=?");
			insProduct= conn.prepareStatement("Insert into Product values(?,?,?,?,?,?)");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//findAllProducts
	@Override
	public List<Product> findAllProducts() {
		List<Product> plist = new ArrayList<>();

		try {
			ResultSet rs = findAll.executeQuery();
			while (rs.next()) {
				plist.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),
						rs.getDate(5).toLocalDate(), rs.getInt(6)));
			}
			return plist;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;

	}

	//to close connection
	public void closeMyConnection() {
		DBUtil.closeMyConnection();

	}

	//remove id
	@Override
	public boolean removeById(int id) {
		try {
			deleteById.setInt(1, id);
			int n = deleteById.executeUpdate();
			return n > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}
	//find id
	@Override
	public Product getId(int id) {
		try {
			selById.setInt(1, id);
			ResultSet rs= selById.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getDate(5).toLocalDate(), rs.getInt(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean updateProduct(Product p) {
		try {
			updateById.setString(1, p.getName());
			updateById.setDouble(2, p.getPrice());
			updateById.setInt(3, p.getQty());
			updateById.setDate(4, java.sql.Date.valueOf(p.getExpdate()));
			updateById.setInt(5, p.getCid());
			updateById.setInt(6, p.getId());
			
			//n stores the no. of rows affected(update/delete/insert)
			int n =updateById.executeUpdate();
			return n>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean save(Product p) {
		System.out.println("In addNewProduct");
		try {
			insProduct.setInt(1, p.getId());
			insProduct.setString(2, p.getName());
			insProduct.setDouble(3, p.getPrice());
			insProduct.setInt(4, p.getQty());
			insProduct.setDate(5, java.sql.Date.valueOf(p.getExpdate()));
			insProduct.setInt(6,p.getCid());
			
			int n =insProduct.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	

}
