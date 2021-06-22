<%@page import="model.ClientBean"%>
<!DOCTYPE html>
<html>
    <%@ include file="../Includes/Client/headerClient.jsp" %>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Client/reservation.css" />
<title>Reservation</title>
</head>

<%ClientBean client = (ClientBean)session.getAttribute("compte"); %>
<body style="background-color: white"> 
    <center>
        <div class="main">
            <h2>Completer Votre Reservation</h2>
            <form action="" method="post" class="trip-form" action="<%=request.getContextPath()%>/Reservation">
        <input type="hidden" name="idClient" value="<%=client.getIdClient()%>">
        <input type="hidden" name="price" value="<%=request.getParameter("price")%>">
        <input type="hidden" name="idChambre" value="<%= request.getParameter("chambreId") %>">
      <fieldset>
        <div class="group-field">
          <label for="from" class="bold-type">Nom Complet : </label>
          <input class="from-place" type="text" name="from" maxlength="100" value="<%=client.getFullName()%>">
        </div>
        <div class="group-field">
          <label for="to" class="bold-type">Care d'identiité Nationale : </label>
          <input class="to-place" type="text" name="to"  maxlength="100" value="<%=client.getCin()%>">
        </div>
      </fieldset>
      <fieldset>
        <div class="group-field">
          <label for="depart" class="bold-type"> 1er Nuit :</label>
          <input placeholder="Pick a date" type="date" name="debut" />
        </div>
        <div class="group-field">
          <label for="return" class="bold-type">Derneire Nuit :</label>
          <input placeholder="Pick a date" type="date" name="fin" />
        </div>
      </fieldset>
      
      <fieldset>
        <div class="group-field">
          <label for="adults" class="bold-type">Nombre de Personnes</label> 
          <select name="nbrPersonne" class="adult">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">3</option>
            <option value="5">3</option>
          </select>
        </div>
         <div class="group-field">
          <label for="infants">Mode de Paiment</label>
           <select name="paymentMode" class="paiment">
             <option value="Paiement a l'hotel">Paiement a l'hotel</option>
             <option value="Paiement par Carte" disabled="true">Paiement par Carte</option>
             <option value="Paiement par cheque"  disabled="true">Paiement par cheque</option>
           </select>
        </div>
      </fieldset>
      <fieldset class="more-option">
        <details>
          <summary class="more-link"> <b>Plus de detaills  </b>Lisser Nous un message ou une note</summary>
     
        <div class="group-field">
          <label for="airline-name">Commentaire :</label> 
          <textarea class="note" rows="5"   name="note">
          </textarea> 
        </div>
      </details> 
      </fieldset>
      
      <input class="search-btn" type="submit" value="Confirmer la reservation"/>
    </form>


        </div>
        </center>
    </body>
    <%@ include file="../Includes/footer.jsp" %>
</html>
