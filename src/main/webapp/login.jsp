<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<form action="login" method="post">
<table style="width:100%">
	<tr>
		<td colspan="2" style="text-align: center"><img src="img/library.png" alt="library image" /></td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<c:if test="${error != null}">
	<tr>
		<td style="color:#FF0000" colspan="2" style="text-align: center">
			<c:out value="${error}" />
		</td>
	</tr>
	</c:if>
	<tr>
		<td style="width:45%;text-align: right">Username:</td>
		<td style="width:55%;text-align: left"><input type="text" name="userName" size="20"></td>
	</tr>
	<tr>
		<td style="width:45%;text-align: right">Password:</td>
		<td style="width:55%;text-align: left"><input type="text" name="password" size="20"></td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td colspan="2" style="text-align: center">
			<!-- Implement submit button with type = submit to perform the request when clicked -->
			<input type="submit" value="Login">
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td colspan="2" style="text-align: center"><a href="<%=request.getContextPath()%>/register">Create New Staff Account</a></td></tr>
</table>
</form>
</body>
</html>