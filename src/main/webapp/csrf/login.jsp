<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<%
  String errmsg = request.getSession().getAttribute("errmsg")!=null?request.getSession().getAttribute("errmsg").toString():"";
%>
</head>
<body>
<%=errmsg %>  <br>
<form action="login" method="POST">
    <input type="text" name="username"> <br>
    <input type="password" name="password"> <br>
    <input type="submit" value="Login">
</form>
</body>
</html>