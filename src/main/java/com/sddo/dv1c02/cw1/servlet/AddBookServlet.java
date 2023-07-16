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
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("AddBookServlet : doGet()");
		
		// get the list of categories from tb_code table
		HashMap<String, String> categories = new HashMap<String, String>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");
			
			String sql = "select code, code_desc from tb_code where code_type='category'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// execute query, get result set
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {				
				categories.put(rs.getString("code"), rs.getString("code_desc"));
			}
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		// set categories in request
		request.setAttribute("categories", categories);
		
		//forward the control to the addBook.jsp
		request.getRequestDispatcher("/addBook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
				
		// collect all form data
		String bookID = request.getParameter("bookID");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String ISBN = request.getParameter("ISBN");
		float price = Float.parseFloat(request.getParameter("price"));
		String category = request.getParameter("category");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "password");
			
			// execute the SQL query using prepared statement
			PreparedStatement ps = conn.prepareStatement("insert into tb_book values(?,?,?,?,?,?)");
			
			// pass in the data retrieved from the web form into the prepared statement accordingly
			ps.setString(1, bookID);
			ps.setString(2, title);
			ps.setString(3, author);
			ps.setString(4, ISBN);
			ps.setFloat(5, price);
			ps.setString(6, category);
			
			// execute the query on the database using the prepared statement
			int i = ps.executeUpdate();
			
			// check if the query had been successfully executed, return to manageBooks
			if (i > 0) {
				//forward to manageBooks
				request.getRequestDispatcher("/manageBooks").forward(request, response);
			}
			else {
				request.setAttribute("error", "Fail to add new book, please try again later!");
				request.getRequestDispatcher("/addBook.jsp").forward(request, response);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
