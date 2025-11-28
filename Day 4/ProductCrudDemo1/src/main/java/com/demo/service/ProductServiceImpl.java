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

	@Override
	public boolean deleteById(int id) {
		
		return pdao.removeById(id);
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return pdao.getId(id);
	}

	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.updateProduct(p);
	}

	@Override
	public boolean addNew(Product p) {
		// TODO Auto-generated method stub
		return pdao.save(p);
	}

}
