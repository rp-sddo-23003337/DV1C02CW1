package com.sddo.dv1c02.cw1.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		boolean isValidUser = false;
		
		//Step 1: retrieve parameter userName and password from the request from the web form
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//User existingUser = null;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");
			
			// execute the SQL query using prepared statement
			PreparedStatement ps = conn.prepareStatement("select * from tb_user where user_id=? and password=?");
			
			// pass in the data retrieved from the web form into the prepared statement accordingly
			ps.setString(1, userName);
			ps.setString(2, password);
			
			// execute the statement and check whether user exists
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				isValidUser = true;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		if (isValidUser == true) {
			//set up the HTTP session
			HttpSession session = request.getSession();
			
			//set the username as an attribute
			session.setAttribute("username", userName);
			
			//forward to manageBooks
			request.getRequestDispatcher("/manageBooks").forward(request, response);
		}
		else {
			request.setAttribute("error", "Invalid credentials, please login again!");
			request.getRequestDispatcher("/home").forward(request, response);
		}
	}

}
