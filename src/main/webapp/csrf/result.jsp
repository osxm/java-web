<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<%
  String msg = request.getAttribute("msg")!=null?request.getAttribute("msg").toString():"";
%>
</head>
<body>
<%=msg %>  <br>

</body>
</html>