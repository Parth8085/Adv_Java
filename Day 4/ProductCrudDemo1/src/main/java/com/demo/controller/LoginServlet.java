package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.*;
import com.demo.service.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		response.setContentType("text/html");
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		LoginService lservice=new LoginServiceImpl();
		User user= lservice.validateUser(name,pass);
		if(user!=null)
		{
			out.print("<h1>Login Successfully</h2>");
			out.print("<h2><strong>Username:</strong> " + user.getName() + "</h2>");
			out.print("<h2>Email:"+user.getEmail()+"</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("ShowProduct");
			rd.forward(request, response);
		}
		else
		{
			out.println("<h1>Invalid credentials</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
		
		
		
	}

}
