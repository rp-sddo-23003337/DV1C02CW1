<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
 
<div class="container col-md-6">
	<div class="card">
		<div class="card-body">
			<form action="updateBook" method="post">
			
			<caption>
				<h2>
					Edit Book
				</h2>
			</caption>
			
			<fieldset class="form-group">
				<label>Book ID</label> <input type="text" name="bookID" value="<c:out value='${book.bookID}' />" readonly class="form-control">
			</fieldset>

			<fieldset class="form-group">
				<label>Title</label> <input type="text" name="title" value="<c:out value='${book.title}' />" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Author</label> <input type="text" name="author" value="<c:out value='${book.author}' />" class="form-control">
			</fieldset>

			<fieldset class="form-group">
				<label>ISBN</label> <input type="text" name="ISBN" value="<c:out value='${book.ISBN}' />" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Price($)</label> <input type="text" name="price" value="<c:out value='${book.price}' />" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Category</label>
				<select class="form-control" name="category">
				<c:forEach items="${requestScope.categories}" var="category">
					<c:choose>
						<c:when test="${category.key eq book.category}">
							<option value="${category.key}" selected>${category.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${category.key}">${category.value}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			</fieldset>
			
			<button type="submit" class="btn btn-success">Save</button>
			<input type="button" class="btn btn-success" onclick="window.location='<%=request.getContextPath()%>/manageBooks'" value="Cancel" />
			</form>
		</div>
	</div>
</div>
</body>
</html>