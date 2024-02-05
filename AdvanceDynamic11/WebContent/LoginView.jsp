<%@ page errorPage="Error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="LoginCtl" method="post">

		<%
			String msg = (String) request.getAttribute("msg");
			String uri = (String) request.getAttribute("uri");
		%>
		<%
			if (msg != null) {
		%>

		<%=msg%>

		<%
			}
		%>

		<table>
			<tr>
				<th>login id :</th>
				<td><input type="text" name="Loginid"></td>
			</tr>
			<tr>
				<th>password :</th>
				<td><input type="text" name="Password"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit"></td>
			</tr>
		</table>
		<input type="hidden" name="uri" value="<%=uri%>">
		</form>
</body>
</html>