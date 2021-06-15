<%@page import="model.ChambreBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<%@ include file="Includes/header.jsp" %>
<div style="border-style: solid; text-align: center;justify-content: center">



<h2>Chambres List </h2>

<table style=";display: flex;
  justify-content: center;"
  >
  <tr>
    <th>Id Chambre</th>
    <th>Label</th>
    <th>Numero</th>
    <th>Price</th>
    <th>Etat</th>
    <th></th>
  </tr>
  <%for (ChambreBean chambre : (List<ChambreBean>)session.getAttribute("chambres")) { %>
  <tr>
    <td><%=chambre.getIdChambre()%></td>
    <td><%=chambre.getLabel()%></td>
    <td><%=chambre.getNumChanbre()%></td>
    <td><%=chambre.getPrice()%></td>
    <td><%=chambre.getEtat()%></td>
    <td><form method="Post" action="Controller">
    	<input type="hidden" name="id" value="<%=chambre.getIdChambre()%>">
    	<input type="submit" name="btnPost" value="supprimer"></form></td>
  </tr><%} %>
 
 
</table></div>
</body>
</html>