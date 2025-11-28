package com.demo.controller;
import com.demo.beans.Product;
import com.demo.service.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		ProductService pservice =new ProductServiceImpl();
		Product p=pservice.getById(id);
		
		//display it in Form 
		out.println("Update Product");
		out.println("<form action='UpdateProduct' method='post'>");
		out.println("Product Id: <input type='text' name='id' id='id' value='"+p.getId()+"' readonly> <br/>");		
		out.println("Product name: <input type='text' name='name' id='name' value='"+p.getName()+"' > <br/>");	
		out.println("Product price: <input type='text' name='price' id='price' value=' "+p.getPrice()+"' ><br/>");	
		out.println("Product quantity: <input type='text' name='qty' id='qty' value='"+p.getQty()+"'> <br/>");
		
		String sdt = p.getExpdate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		out.println("ExpDate: <input type='text' name='expdate' id='expdate' value=' "+sdt+"' ><br/> ");	
		out.println("Cid: <input type='text' name='cid' id='cid' value=' "+p.getCid()+"' ><br/>");
		out.println("<button type='submit' name='update' id='update'>Update</button> ");
		out.println("</form>");
		
		
	}

	
}
