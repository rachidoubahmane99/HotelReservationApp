<%@page import="model.ChambreBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="Includes/Client/headerClient.jsp" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Client/home.css" />


  <%for (ChambreBean chambre : (List<ChambreBean>)session.getAttribute("chambres")) { %>
  
    <div class="wrapper">
  <h1><%=chambre.getIdChambre()%></h1>
  <div class="image i2"></div>
  <div class="details"><h1><em><%=chambre.getLabel()%></em></h1>
  <h2><%=chambre.getNumChanbre()%></h2>
  <p>4 Days - 3 Nights</p></div>
  <h1><%=chambre.getPrice()%> DH</h1>
</div>
  
    
 <%} %>

</body>
<%@ include file="Includes/footer.jsp" %>


</html>