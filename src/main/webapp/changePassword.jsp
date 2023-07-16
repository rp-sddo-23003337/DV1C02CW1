<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Change Password</title>
</head>
<body>
<div class="container col-md-6">
	<div class="card">
		<div class="card-body">
			<form action="changePassword" method="post">
			<caption>
				<h2>
					Change Password
				</h2>
			</caption>
			
			<fieldset class="form-group">
				<label>Username</label> <input type="text" name="userName" value="<c:out value='${sessionScope.username}' />" readonly class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Old Password</label> <input type="text" name="oldPassword" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>New Password</label> <input type="text" name="newPassword" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Confirm New Password</label> <input type="text" name="confirmNewPassword" class="form-control">
			</fieldset>
			
			<button type="submit" class="btn btn-success">Submit</button>
			<input type="button" class="btn btn-success" onclick="window.location='<%=request.getContextPath()%>/manageBooks'" value="Cancel" />
			</form>
		</div>
	</div>
</div>
</body>
</html>