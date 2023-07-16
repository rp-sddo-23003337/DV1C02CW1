<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Add Book</title>
</head>
<body>

<div class="container col-md-6">
	<div class="card">
		<div class="card-body">
			<form action="addBook" method="post">
			
			<caption>
				<h2>
					Add Book
				</h2>
			</caption>
			<c:if test="${error != null}">
				<fieldset style="color:#FF0000" class="form-group">
					<c:out value="${error}" />
				</fieldset>
			</c:if>
			<fieldset class="form-group">
				<label>Book ID</label> <input type="text" name="bookID" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Title</label> <input type="text" name="title" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Author</label> <input type="text" name="author" class="form-control">
			</fieldset>

			<fieldset class="form-group">
				<label>ISBN</label> <input type="text" name="ISBN" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Price($)</label> <input type="text" name="price" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Category</label>
				<select class="form-control" name="category">
					<c:forEach items="${requestScope.categories}" var="category">
						<option value="${category.key}">${category.value}</option>
					</c:forEach>
				</select>
			</fieldset>
			
			<button type="submit" class="btn btn-success">Submit</button>
			<input type="button" class="btn btn-success" onclick="window.location='<%=request.getContextPath()%>/manageBooks'" value="Cancel" />
		</form>
	</div>
</div>
</div>	
</body>
</html>