package com.demo.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//to retrieve data from Form
		int id = Integer.parseInt(request.getParameter("id")) ;
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		String dt = request.getParameter("expdate");
		LocalDate ldt = LocalDate.parse(dt, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		int cid = Integer.parseInt("cid");
		
		//send data to database
		Product p = new Product(id, name, price, qty, ldt, cid);
		ProductService pservice = new ProductServiceImpl();
		boolean status = pservice.updateProduct(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("ShowProduct");
		rd.forward(request, response);
		
		
		
		
		
	}

}
