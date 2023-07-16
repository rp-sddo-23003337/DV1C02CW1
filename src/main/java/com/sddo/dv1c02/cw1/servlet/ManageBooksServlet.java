package com.sddo.dv1c02.cw1.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sddo.dv1c02.cw1.dto.Book;

/**
 * Servlet implementation class ManageBooksServlet
 */
@WebServlet("/ManageBooksServlet")
public class ManageBooksServlet extends HttpServlet {
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
	
	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		List<Book> books = new ArrayList<>();
		
		try {
			Connection conn = getConnection();
			
			// Create a statement using connection object
			PreparedStatement ps = conn.prepareStatement("select * from tb_book");
			
			// Execute the query or update query
			ResultSet rs = ps.executeQuery();
			
			// Process the ResultSet object.
			while (rs.next()) {
				String bookID = rs.getString("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String ISBN = rs.getString("ISBN");
				float price = rs.getFloat("price");
				String category = rs.getString("category");
				
				books.add(new Book(bookID, title, author, ISBN, price, category));
		    }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// Set the users list into the listUsers attribute to be pass to the userManagement.jsp
		request.setAttribute("books", books);
		
		request.getRequestDispatcher("/manageBooks.jsp").forward(request, response);
	}
	
	//method to get parameter, query database for existing book data and redirect to book edit page
	private void showEditBookForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		//get parameter passed in the URL
		String bookID = request.getParameter("bookID");
		
		Book existingBook = null; //new Book("", "", "", "", 0, "");
		// get the list of categories from tb_code table
		HashMap<String, String> categories = new HashMap<String, String>();
		
		// Step 1: Establishing a Connection
		try {
			Connection conn = getConnection();
			
			// Step 2:Create a statement using connection object
			PreparedStatement ps = conn.prepareStatement("select * from tb_book where book_id=?");
			ps.setString(1, bookID);
			
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();
			
			// Step 4: Process the ResultSet object 
			while (rs.next()) {
				bookID = rs.getString("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String ISBN = rs.getString("ISBN");
				float price = rs.getFloat("price");
				String category = rs.getString("category");
				
				existingBook = new Book(bookID, title, author, ISBN, price, category);
			}
			
			PreparedStatement stmt2 = conn.prepareStatement("select code, code_desc from tb_code where code_type='category'");
			
			// execute query, get result set
			ResultSet rs2 = stmt2.executeQuery();
			while (rs2.next()) {				
				categories.put(rs2.getString("code"), rs2.getString("code_desc"));
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		//Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("book", existingBook);
		// set categories in request
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/editBook.jsp").forward(request, response);
	}
	
	//method to update tb_book based on the form data submitted
	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {

		//Step 1: Retrieve value from the request
		String bookID = request.getParameter("bookID");
	    String title = request.getParameter("title");
        String author = request.getParameter("author");
        String ISBN = request.getParameter("ISBN");
        float price = Float.parseFloat(request.getParameter("price"));
        String category = request.getParameter("category");
        
        //Step 2: Attempt connection with database and execute update book SQL query
        try {
        	Connection conn = getConnection();
        	PreparedStatement statement = conn.prepareStatement("update tb_book set title=?, author=?, ISBN=?, price=?, category=? where book_id=?");
        	
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3, ISBN);
            statement.setFloat(4, price);
            statement.setString(5, category);
            statement.setString(6, bookID);
 
            int i = statement.executeUpdate();
        } catch (SQLException sqle) {
        	System.out.println(sqle.getMessage());
        }
        
        request.getRequestDispatcher("/manageBooks").forward(request, response);
	}
	
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		//Step 1: Retrieve value from the request
	    String bookID = request.getParameter("bookID");
	    
	    //Step 2: Attempt connection with database and execute delete user SQL query
	    try {
	    	Connection conn = getConnection();
	    	PreparedStatement ps = conn.prepareStatement("delete from tb_book where book_id = ?");
	    	
	        ps.setString(1, bookID);
	        int i = ps.executeUpdate();
	        
	    } catch (SQLException sqle) {
	    	System.out.println(sqle.getMessage());
	    }
	    
	    //Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)
	    //response.sendRedirect("http://localhost:8090/HelloWorldJavaEE/UserServlet/dashboard");
	    request.getRequestDispatcher("/manageBooks").forward(request, response);
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Depending on the request servlet path, determine the function to invoke using the follow switch statement.
		String action = request.getServletPath();
		
		try {
			switch (action) {
				case "/manageBooks/deleteBook":
					deleteBook(request, response);
					break;
				case "/manageBooks/editBook":
					showEditBookForm(request, response);
					break;
				case "/manageBooks/updateBook":
					updateBook(request, response);
					break;
				default:
			    	listBooks(request, response);
			}
		} catch (SQLException sqle) {
			throw new ServletException(sqle);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("ManageBooksServlet : doPost()");
		
		doGet(request, response);
	}

}
