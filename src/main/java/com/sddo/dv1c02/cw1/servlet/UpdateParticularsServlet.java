package com.sddo.dv1c02.cw1.servlet;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import com.sddo.dv1c02.cw1.dto.Book;
import com.sddo.dv1c02.cw1.dto.User;

/**
 * Servlet implementation class UpdateParticularsServlet
 */
@WebServlet("/UpdateParticularsServlet")
public class UpdateParticularsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Implement the getConnection method which facilitates connection to the database via JDBC
	private Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return conn;
	}
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateParticularsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("UpdateParticularsServlet : doGet()");
		
		//get username from session
		String userName = (String)request.getSession().getAttribute("username");
		
		User existingUser = null; //new Book("", "", "", "", 0, "");
		// get the list of categories from tb_code table
		HashMap<String, String> roles = new HashMap<String, String>();
		
		// Step 1: Establishing a Connection
		try {
			Connection conn = getConnection();
			
			// Step 2:Create a statement using connection object
			PreparedStatement ps = conn.prepareStatement("select * from tb_user where user_id=?");
			ps.setString(1, userName);
			
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();
			
			// Step 4: Process the ResultSet object 
			while (rs.next()) {
				userName = rs.getString("user_id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String office_tel = rs.getString("office_tel");
				String mobile_tel = rs.getString("mobile_tel");
				String role = rs.getString("role");
				
				existingUser = new User(userName, password, name, email, office_tel, mobile_tel, role);
			}
			
			PreparedStatement stmt2 = conn.prepareStatement("select code, code_desc from tb_code where code_type='role'");
			
			// execute query, get result set
			ResultSet rs2 = stmt2.executeQuery();
			while (rs2.next()) {				
				roles.put(rs2.getString("code"), rs2.getString("code_desc"));
				
				System.out.println("code: "+rs2.getString("code")+" / code_desc: "+rs2.getString("code_desc"));
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		//Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("user", existingUser);
		// set roles in request
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/updateParticulars.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("UpdateParticularsServlet : doPost()");
		
		//Step 1: Retrieve value from the request
		String userName = request.getParameter("userName");
	    String name = request.getParameter("name");
        String email = request.getParameter("email");
        String officeTel = request.getParameter("officeTel");
        String mobileTel = request.getParameter("mobileTel");
        String role = request.getParameter("role");
        
        //Step 2: Attempt connection with database and execute update book SQL query
        try {
        	Connection conn = getConnection();
        	PreparedStatement statement = conn.prepareStatement("update tb_user set name=?, email=?, office_tel=?, mobile_tel=?, role=? where user_id=?");
        	
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, officeTel);
            statement.setString(4, mobileTel);
            statement.setString(5, role);
            statement.setString(6, userName);
            
            System.out.println("name: "+name);
            System.out.println("email: "+email);
            System.out.println("officeTel: "+officeTel);
            System.out.println("mobileTel: "+mobileTel);
            System.out.println("role: "+role);
            System.out.println("userName: "+userName);
            
            int i = statement.executeUpdate();
        } catch (SQLException sqle) {
        	System.out.println(sqle.getMessage());
        }
        
        request.getRequestDispatcher("/manageBooks").forward(request, response);
	}

}
