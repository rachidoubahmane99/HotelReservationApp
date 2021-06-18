<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style><%@include file="../../Layout/Header.css"%></style>
  
</head>
<body>
<div class="nav">
  <input type="checkbox" id="nav-check">
  <div class="nav-header">
    <div class="nav-title">
      Hotel Reservation
    </div>
  </div>
  <div class="nav-btn">
    <label for="nav-check">
      <span></span>
      <span></span>
      <span></span>
    </label>
  </div>
  
  <div class="nav-links">
    <a href="#" target="_blank">Home</a>
    <a href="Login.jsp" target="_blank">Mes Reservation</a>
    <a href="#" target="_blank">Mon Profile</a>
    <a href="<%=request.getContextPath()%>/Logout" target="_blank">Logout</a>
  </div>
</div>
</body>
</html>