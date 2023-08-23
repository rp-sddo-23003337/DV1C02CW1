<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Register User</title>
</head>
<body>

<div class="container col-md-6">
	<div class="card">
		<div class="card-body">
			<form action="addBook" method="post">
			<caption>
				<h2>
					Register User
				</h2>
			</caption>
			
			<fieldset class="form-group">
				<label>Username</label> <input type="text" name="userID" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Password</label> <input type="text" name="password" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Name</label> <input type="text" name="name" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Email</label> <input type="text" name="email" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Office Tel</label> <input type="text" name="officeTel" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Mobile Tel</label> <input type="text" name="mobileTel" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Role</label>
				<select class="form-control" name="role">
					<c:forEach items="${requestScope.roles}" var="role">
						<option value="${role.key}">${role.value}</option>
					</c:forEach>
				</select>
			</fieldset>
			
			<button type="submit" class="btn btn-success">Register</button>
			<input type="button" class="btn btn-success" onclick="window.location='<%=request.getContextPath()%>/home'" value="Cancel" />
			</form>
		</div>
	</div>
</div>

</body>
</html>