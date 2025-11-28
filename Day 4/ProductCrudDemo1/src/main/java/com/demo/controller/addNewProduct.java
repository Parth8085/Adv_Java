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
 * Servlet implementation class addNewProduct
 */
@WebServlet("/addNewProduct")
public class addNewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt( request.getParameter("id"));
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		String expdate = request.getParameter("expdate");
		LocalDate ldt = LocalDate.parse(expdate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		Product p= new Product(id, name, price, qty, ldt, cid);
		//Product p= new Product( name, price, qty, ldt, cid);
		ProductService pservice = new ProductServiceImpl();
		boolean status = pservice.addNew(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("ShowProduct");
		rd.forward(request, response);

		
	}

}
