package com.demo.controller;
import com.demo.beans.Product;
import com.demo.service.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowProduct
 */
@WebServlet("/ShowProduct")
public class ShowProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ProductService pservice=new ProductServiceImpl();
		List<Product> plist=pservice.getAllProducts();
		out.println("<table border='2'><tr><th>Id</th><th>Name</th><th>qty</th><th>price</th><th>expdate</th><th>cid</th></tr>");
		for(Product p:plist)
		{

			out.println("<tr><td>"+p.getId()+"</td><td>"+p.getName()+"</td><td>"+p.getQty()+"</td><td>"+p.getPrice()+"</td><td>"+p.getExpdate()+"</td><td>"+p.getCid()+"</td>");
		}
		out.println("</table>");
		
		
		
		
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	
}
