<%@ page errorPage="Error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background:red;" >
	<form action="UserRegistrationCtl" method="post">
	<table>
		<tr>
			<th> First name  :</th>
			<td><input type="text" name="firstName"></td>
		</tr>
		<tr>
		    <th> Last name  :</th>
		    <td><input type="text" name="lastName"></td>
		</tr>
		<tr>
		    <th> login id  :</th>
		    <td><input type="text" name="Loginid"></td>
		</tr>
		<tr>
		    <th> password  :</th>
		    <td><input type="text" name="Password"></td>
		</tr>
		<tr>
		    <th> DOB  :</th>
		    <td><input type=date name="Dob"></td>
		</tr>
		<tr>
		    <th> Address  :</th>
		    <td><input type="text" name="Address"></td>
		</tr>
		<tr>
		    <th>   </th>
		    <td><input  type="submit"></td>
		</tr>
	</table>

	</form>
</body>
</html>