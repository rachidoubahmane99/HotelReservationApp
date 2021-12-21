<%@page import="model.ReservationBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<!DOCTYPE html>
<html>
    <%@ include file="../Includes/Client/headerClient.jsp" %>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Client/mesreservation.css" />
<title>Mes Reservation</title>
</head>
    <body>
         
        <div class="container table">

  <div class="title">
 <% if (request.getAttribute("DATA")!=null){  %>
        <div> <h2> <%=request.getAttribute("DATA")%> </h2></div>
        <% }%>
    <h1>Liste de mes Reservation </h1>

  </div>
  <table>
    <thead>
      <tr>
        <td>Reservation ID</td>
        <td>1er Nuit</td>
        <td>
          Derniere Nuit
        </td>
        <td class="special">Prix Total</td>
        <td>Etat</td>
      </tr>
    </thead>
    <tbody>
        <%for (ReservationBean reservation : (List<ReservationBean>)session.getAttribute("mesreservation")) { %>
        <tr>
        <td><%=reservation.getIdReservation()%></td>
        <td><%=reservation.getDateDebut()%></td>
        <td><%=reservation.getDateFin()%></td>
        <td><%=reservation.getTotalPrice()%></td>
        <td class="control">
          <div class="view">
            <% if(reservation.getValide()) { %>
            Apprové
            <% }else if(!reservation.getValide() && !reservation.getAnnuler()) { %>
            En attende 
            <%} %>
          </div>
          <div class="delete">
              <form method="POST" action="<%=request.getContextPath()%>/MesReservation">
                  <input type="hidden" name="idReservation" value="<%=reservation.getIdReservation()%>">
                  <% if(!reservation.getValide() && !reservation.getAnnuler() ) { %>
                     <button class="delete" type="submit"> Annuler </button> 
                  <% }else if(reservation.getAnnuler()) { %>
                          <div class="delete"> Annulé</div>
                   <%} %>
              </form>
            
          </div>
        </td>
      </tr>
        <%} %>
    </tbody>
  </table>

</div>
     <div class="page-content">  </div>
     <div class="page-content">  </div>
</body>

<%@ include file="../Includes/footer.jsp" %>
</html>