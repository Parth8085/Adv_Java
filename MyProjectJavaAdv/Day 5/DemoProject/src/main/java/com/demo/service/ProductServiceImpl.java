package com.demo.service;
import com.demo.dao.*;

import java.util.List;

import com.demo.beans.Product;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> getAllProducts() {
		ProductDao dao= new ProductDaoImpl();
		return dao.getAllCars();
	}

}
