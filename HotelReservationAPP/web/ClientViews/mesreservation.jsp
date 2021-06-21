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

    <h1>Mes Reservation </h1>

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
            <% }else { %>
            En attende 
            <%} %>
          </div>
          <div class="delete">
            Anuler
          </div>
        </td>
      </tr>
        <%} %>
    </tbody>
  </table>

</div>
    
    </body>

</html>