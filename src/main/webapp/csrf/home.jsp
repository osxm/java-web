<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CSRF Home</title>
<% 
  String csrfToken =  request.getSession().getAttribute("csrfToken")!=null?request.getSession().getAttribute("csrfToken").toString():"";
  
%>
</head>
<body>

  成功登陆后的主页面 <br>
  
  csrfToken = <%=csrfToken %> <br>
  
  <form action="demo" method="POST">
      转账金额：<input type="text" name="amount"> <br>
      <input type="hidden" name="csrfToken" value="<%=csrfToken%>">
      <input type="submit" value="转账">
  </form>  
  
</body>
</html>