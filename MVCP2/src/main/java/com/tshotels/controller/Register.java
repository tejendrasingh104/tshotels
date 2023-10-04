package com.tshotels.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tshotels.model.Model;


@WebServlet("/reg")
public class Register extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String GuestName = request.getParameter("GuestName");
		String GuestEmail= request.getParameter("GuestEmail");
		String GuestPhone= request.getParameter("GuestPhone");
		String GuestAddress= request.getParameter("GuestAddress");
		
		Model model = new Model();
		model.setName(GuestName);
		model.setEmail(GuestEmail);
		model.setPhone(GuestPhone);
		model.setAddress(GuestAddress);
		
		int rowsAffected = model.insert();
		if(rowsAffected == 1)
		{
			response.sendRedirect("registrationSuccess.jsp");
		}
		else
		{
			response.sendRedirect("registrationFailure.jsp");
		}
		
		
		
	}

}
