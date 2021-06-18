<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/web/Layout/Header.css" />
  
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
    <a href="" target="_blank">Gestion Reservation</a>
    <a href="#" target="_blank">Gestion Chambres</a>
    <a href="#" target="_blank">Mon Profile</a>
    <a href="<%=requesst.getContextPath()%>/Logout" target="_blank">Logout</a>
  </div>
</div>
</body>
</html>