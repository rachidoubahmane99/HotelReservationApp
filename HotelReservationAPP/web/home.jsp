<%@page import="model.ChambreBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<%@ include file="Includes/Client/headerClient.jsp" %>
<head>
    <title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Client/home.css" />
</head>
<body>
    
      <div class="main">
  <h1>Liste Des Chambres :</h1>
  <ul class="cards">
  <%for (ChambreBean chambre : (List<ChambreBean>)session.getAttribute("chambres")) { %>
  
    <li class="cards_item">
      <div class="card">
          <div class="card_image"><img src="data:image/jpg;base64,<%=chambre.getImage()%>" ></div>
        <div class="card_content">
          <h2 class="card_title"><%=chambre.getLabel()%></h2>
          <p class="card_text">Numero Chambre : <%=chambre.getNumChanbre()%></p>
          <p class="card_text"> Prix /Nuit : <%=chambre.getPrice()%> DH</p>
          <a href="<%=request.getContextPath()%>/Reservation?chambreId=<%=chambre.getIdChambre()%>&price=<%=chambre.getPrice()%>"><button class="btn card_btn">Reserver</button></a>
        </div>
      </div>
    </li>
     <%} %>
  </ul>
</div>

  

</body>

<%@ include file="Includes/footer.jsp" %>

</html>