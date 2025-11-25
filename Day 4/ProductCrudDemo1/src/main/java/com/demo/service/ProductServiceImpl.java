package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.*;

public class ProductServiceImpl implements ProductService {
	private ProductDao pdao;
	public ProductServiceImpl ()
	{
		pdao=new ProductDaoImpl();
	}

	@Override
	public List<Product> getAllProducts() {
		return pdao.findAllProducts();
	}

}
