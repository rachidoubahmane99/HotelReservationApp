<%@page import="model.ChambreBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="Includes/Admin/headerAdmin.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Header.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">




<br>
<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Liste des chambres</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/addChambre.jsp" class="btn btn-success">Ajouter une chambre</a>
                        </div><br>
<table class="table table-bordered">
    <thead>
    <tr>
        
        <th>Label</th>
        <th>Numero</th>
        <th>Etat</th>
        <th>Prix</th>
        <th>Actions</th>
    </tr>
    </thead>
    <% for (ChambreBean chambre : (List<ChambreBean>)session.getAttribute("chambres")){ %>
    <tr>
        <td><%= chambre.getLabel() %></td>
        <td><%= chambre.getNumChanbre() %></td>
        <% if(!chambre.getEtat()) { %>
        <td>Disponible</td>
        <%  } else { %>
        <td>Occupé</td>
        <% } %>
        <td><%= chambre.getPrice() %></td>
        <td><button  type="button" class="btn btn-secondary"><a style="text-decoration: none;color: white;" href="<%=request.getContextPath()%>/EditChambre?id=<%= chambre.getIdChambre() %>">Edit</a></button> &nbsp;&nbsp;&nbsp;&nbsp; <button type="button" class="btn btn-danger"><a style="text-decoration: none;color:white;" href="<%=request.getContextPath()%>/deleteChambre?id=<%= chambre.getIdChambre() %>" />Delete</a></button></td>
        
    </tr>
    <% } %>
</table>
            </div>
</div>