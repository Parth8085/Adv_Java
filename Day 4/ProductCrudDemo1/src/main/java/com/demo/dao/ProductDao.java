package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> findAllProducts();

	boolean removeById(int id);

	Product getId(int id);

	boolean updateProduct(Product p);

	boolean save(Product p);

}
