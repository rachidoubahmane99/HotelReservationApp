<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
    Document   : Login
    Created on : Jun 16, 2021, 2:42:17 PM
    Author     : rachid dev
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Admin Login</title>
    </head>
    <%@ include file="../Includes/header.jsp" %>
    <body>
       
        <style><%@include file="../Layout/Login/login.css"%></style>
        <div class="login-page">
  <div class="form">
          <% if (request.getAttribute("DATA")!=null){  %>
          <h3><%=request.getAttribute("DATA")%></h3>
          
       <% }%>
    
     <FORM class="login-form" NAME="admin" METHOD="POST" action="<%=request.getContextPath()%>/admin?action=admin">
      <input type="text" placeholder="username" name="email"/>
        <input type="password" placeholder="password" name="password"/>
        <input type="hidden" name="page" value="regiter"/>
        <button name="login">login</button>
     </FORM>
  </div>
</div>
    </body>
<div class="page-content">  </div>
        <%@ include file="../Includes/footer.jsp" %>


</html>
