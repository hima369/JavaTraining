package com.wellsfargo.fsd.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/AdminLogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname =	request.getParameter("uname");
		String pwd = 	request.getParameter("pwd");
			
		if(uname.equals("root")&&pwd.equals("root")) {
			
//			response.sendRedirect("AdminHomepage.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("AdminHomepage.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("Adminpage.jsp");
		}
	}



}
