package com.sddo.dv1c02.cw1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("RegisterServlet : doGet()");
		
		// get the list of roles from tb_code table
		HashMap<String, String> roles = new HashMap<String, String>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");
			
			String sql = "select code, code_desc from tb_code where code_type='role'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// execute query, get result set
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {				
				roles.put(rs.getString("code"), rs.getString("code_desc"));
			}
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		// set roles in request
		request.setAttribute("roles", roles);
		
		//forward the control to the register.jsp
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		
		// initialize a PrintWriter object to return the HTML values via the response
		PrintWriter out = response.getWriter();
				
		// collect all form data
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String officeTel = request.getParameter("officeTel");
		String mobileTel = request.getParameter("mobileTel");
		String role = request.getParameter("role");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");
			
			// execute the SQL query using prepared statement
			PreparedStatement ps = conn.prepareStatement("insert into tb_user values(?,?,?,?,?,?,?)");
			
			// pass in the data retrieved from the web form into the prepared statement accordingly
			ps.setString(1, userID);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, email);
			ps.setString(5, officeTel);
			ps.setString(6, mobileTel);
			ps.setString(7, role);
			
			// execute the query on the database using the prepared statement
			int i = ps.executeUpdate();
			
			// check if the query had been successfully executed, return “You are successfully registered” via the response
			if (i > 0) {
				out.println("<h3>" + "You have successfully registered a staff account!" + "</h3>");
			}
			else {
				out.println("<h3>" + "Sorry, something went wrong. Please try again later" + "</h3>");
			}
			
			out.println("<a href='"+request.getContextPath()+"/'>Back to Home</a>");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			out.close();
		}
	}

}
