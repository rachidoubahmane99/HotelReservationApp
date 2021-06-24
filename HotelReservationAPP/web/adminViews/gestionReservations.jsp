<%-- 
    Document   : gestionReservations
    Created on : Jun 22, 2021, 3:29:13 AM
    Author     : moham
--%>


<<html>
    <head>
        <title>Liste des Réservations</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Header.css" />
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    </head>
    <body>

        <%@page import="model.ReservationBean"%>
        <%@page import="java.util.List"%>
        <%@ include file="../Includes/Admin/headerAdmin.jsp" %>




        <br>
        <div class="row">
                        <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                        <div class="container">
                                <h3 class="text-center">Liste des Réservations</h3>
                                <hr>
                                <br>
        <table class="table table-bordered" >
            <thead>
            <tr>
                <th>N Reservation</th>
                <th>N Chambre</th>
                <th>Date début</th>
                <th>Date fin</th>
                <th>Nombre de personnes</th>
                <th>Prix totale</th>
                <th>Etat</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <% for (ReservationBean reservation : (List<ReservationBean>)session.getAttribute("reservations")){ %>
            <tr>
                <td><%= reservation.getIdReservation() %></td>
                <td><%= reservation.getNumChambre() %></td>
                <td><%= reservation.getDateDebut() %></td>
                <td><%= reservation.getDateFin() %></td>
                <td><%= reservation.getNbrPersonne() %></td>
                <td><%= reservation.getTotalPrice() %></td>


                <% if(!reservation.getAnnuler()){ %>
                    <% if(!reservation.getValide()) { %>
                    <td>En traitement</td>
                    <%  } else { %>
                    <td style="color: green;">Validée</td>
                    <% } %>
                <% } else { %>
                <td style="color: red">Annulée</td>
                <%  } %>


                <% if(!reservation.getAnnuler() && !reservation.getValide()){ %>
                <td><button type="button" class="btn btn-primary"><a style="text-decoration: none; color:white;" href="<%=request.getContextPath()%>/validerReservation?id=<%= reservation.getIdReservation()%>">Approver</a></button></td>

                <td><button type="button" class="btn btn-danger"><a style="text-decoration: none; color:white;" href="<%=request.getContextPath()%>/rejeterReservation?id=<%= reservation.getIdReservation() %>">Rejeter</a></button></td>
                <% } %>
            </tr>
            <% } %>
        </table>
                    </div>
        </div>
<div class="page-content">  </div>
        <%@ include file="../Includes/footer.jsp" %>
        
        
    </body>
</html>


