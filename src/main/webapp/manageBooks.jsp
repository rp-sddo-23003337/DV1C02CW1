<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Manage Books</title>
</head>
<body>
<div class="row">
	<div class="container">
		<table style="width:100%">
			<tr>
				<td style="text-align:left">
					Welcome <b><c:out value="${sessionScope.username}" /></b>
				</td>
				<td style="text-align:right">
					<a href="<%=request.getContextPath()%>/changePassword">Change Password</a> &nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=request.getContextPath()%>/updateParticulars">Update Particulars</a> &nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=request.getContextPath()%>/logout">Logout</a>
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
		</table>
	</div>
	<div class="container">
		<h3 class="text-center">Book Catalogue</h3>
		<hr>
		
		<div class="container text-left">
			<!-- Add new book button redirects to the addBook.jsp page -->
			<a href="<%=request.getContextPath()%>/addBook" class="btn btn-success">Add New Book</a>
		</div>
		<br>
		
		<!-- Create a table to list out all current books information -->
		<table class="table">
			<thead>
				<tr>
       				<th>Book ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>ISBN</th>
					<th>Price</th>
					<th>Category</th>
					<th>Actions</th>
				</tr>
			</thead>
			<!-- Pass in the list of books receive via the Servlet's response to a loop -->
			<tbody>
				<c:forEach var="book" items="${books}">
					<!-- For each book in the catalogue, display their information accordingly -->
					<tr>
						<td>
							<c:out value="${book.bookID}" />
						</td>
						<td>
							<c:out value="${book.title}" />
						</td>
						<td>
							<c:out value="${book.author}" />
						</td>
						<td>
							<c:out value="${book.ISBN}" />
						</td>
						<td>
							<fmt:formatNumber value="${book.price}" type="currency" />
						</td>
						<td>
							<c:out value="${book.category}" />
						</td>
						<!-- For each book in the catalogue, Edit/Delete buttons which invokes the edit/delete functions -->
						<td>
							<a href="<%=request.getContextPath()%>/manageBooks/editBook?bookID=<c:out value='${book.bookID}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="<%=request.getContextPath()%>/manageBooks/deleteBook?bookID=<c:out value='${book.bookID}' />">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</div>
</body>
</html>