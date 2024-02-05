<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="bean" scope="request" class="in.co.rays.bean.UserBean"></jsp:useBean>
	<jsp:setProperty name="bean" property="*" />
	<jsp:setProperty name="bean" property="firstname" param="firstname" />
	<jsp:setProperty name="bean" property="lastname" value="hi" />

	<form action="" method="post">
		<table>
			<tr>
				<th>FirstName :</th>
				<td><input type="text" name="firstname"></td>
			</tr>
			<tr>
				<th>LastName :</th>
				<td><input type="text" name="lastname"></td>
			</tr>
			<tr>
				<th>LoginId :</th>
				<td><input type="text" name="loginid"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" name="password"></td>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="signUp"></td>
			</tr>
		</table>
	</form>


	<%
		String op = (String) request.getParameter("operation");

		if (op != null) {
	%>
	<%=bean.getFirstname()%>
	<%=bean.getLastname()%>
	<%=bean.getLoginid()%>
	<%=bean.getPassword()%>
	<%
		}
	%>
</body>
</html>