<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Update Particulars</title>
</head>
<body>
<div class="container col-md-6">
	<div class="card">
		<div class="card-body">
			<form action="updateParticulars" method="post">
			
			<caption>
				<h2>
					Update Particulars
				</h2>
			</caption>
			
			<fieldset class="form-group">
				<label>Username</label> <input type="text" name="userName" value="<c:out value='${user.userID}' />" readonly class="form-control">
			</fieldset>

			<fieldset class="form-group">
				<label>Name</label> <input type="text" name="name" value="<c:out value='${user.name}' />" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Email</label> <input type="text" name="email" value="<c:out value='${user.email}' />" class="form-control">
			</fieldset>

			<fieldset class="form-group">
				<label>Office Tel</label> <input type="text" name="officeTel" value="<c:out value='${user.officeTel}' />" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Mobile Tel</label> <input type="text" name="mobileTel" value="<c:out value='${user.mobileTel}' />" class="form-control">
			</fieldset>
			
			<fieldset class="form-group">
				<label>Role</label>
				<select class="form-control" name="role">
				<c:forEach items="${requestScope.roles}" var="role">
					<c:choose>
						<c:when test="${role.key eq user.role}">
							<option value="${role.key}" selected>${role.value}</option>
						</c:when>
						<c:otherwise>
							<option value="${role.key}">${role.value}</option>
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