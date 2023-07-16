package com.sddo.dv1c02.cw1.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("ChangePasswordServlet : doGet()");
		
		//forward the control to changePassword.jsp
		request.getRequestDispatcher("/changePassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ChangePasswordServlet : doPost()");
		
		//doGet(request, response);
		
		//Step 1: retrieve parameter userName and password from the request from the web form
		String userName = request.getParameter("userName");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmNewPassword = request.getParameter("confirmNewPassword");
		
		//User existingUser = null;
		System.out.println("userName : "+userName);
		System.out.println("oldPassword : "+oldPassword);
		System.out.println("newPassword : "+newPassword);
		System.out.println("confirmNewPassword : "+confirmNewPassword);
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");
			
			// execute the SQL query using prepared statement
			PreparedStatement ps = conn.prepareStatement("update tb_user set password=? where user_id=?");
			
			// pass in the data retrieved from the web form into the prepared statement accordingly
			ps.setString(1, newPassword);
			ps.setString(2, userName);
			
			// execute the statement
			int i = ps.executeUpdate();
			
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch (SQLException sqle) {
			System.out.println(sqle);
		}
		
		// invalidate the session and forward to home/login page
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("/home").forward(request, response);
	}

}
