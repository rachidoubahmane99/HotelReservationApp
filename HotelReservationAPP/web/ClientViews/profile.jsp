<%-- 
    Document   : profile
    Created on : Jun 21, 2021, 5:53:37 PM
    Author     : rachid dev
--%>
<%@page import="model.ClientBean"%>
<!DOCTYPE html>
<html>
    <%@ include file="../Includes/Client/headerClient.jsp" %>
<head>
    <title> Profile</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Client/profile.css" />
</head>
    <body>
      <%ClientBean client = (ClientBean)session.getAttribute("compte"); %>
      
      <form class="register-form" NAME="EditPass" METHOD="POST" action="<%=request.getContextPath()%>/profile?action=EditPass">
	    <h1>Modifier Le Mot de pass :</h1>
	    
    <div class="contentform">
        <% if (request.getAttribute("DATA")!=null){  %>
        <div id="sendmessage"> <h2> <%=request.getAttribute("DATA")%> </h2></div>
        <% }%>

    <div class="leftcontact">
        <div class="form-group">
           <p>Mot de pass actuelle :<span>*</span></p>
	   <span class="icon-case"><i class="fa fa-male"></i></span>
           <input type="password" name="oldpassword" id="nom" data-rule="required" />
           <input type="hidden" name="idClient" id="nom" data-rule="required" value="<%=client.getIdClient()%>" />
                <div class="validation"></div>
       </div> 

        <div class="form-group">
            <p>Nouveau Mot de passe: <span>*</span></p>
            <span class="icon-case"><i class="fa fa-user"></i></span>
            <input type="password" name="nvpassword" id="prenom" data-rule="required"/>
             <div class="validation"></div>
			</div>
        </div>
    </div>
                  <button type="submit" class="bouton-contact">Modifier Le Mot de passe</button>
             <p class="message">Retourner a les information personneles <a href="">Back</a></p>
      </form>
      
      
  <form NAME="EditInfo" METHOD="POST" action="<%=request.getContextPath()%>/profile?action=EditInfo">
	    <h1>Mes Informations Personnelles :</h1>
	    
    <div class="contentform">
    	<div class="contentform">
        <% if (request.getAttribute("DATA")!=null){  %>
        <div id="sendmessage"><h2> <%=request.getAttribute("DATA")%> </h2></div>
        <% }%>


    	<div class="leftcontact">
			      <div class="form-group">
			        <p>Nom Complet :<span>*</span></p>
			        <span class="icon-case"><i class="fa fa-male"></i></span>
                                <input type="text" name="nom" id="nom" data-rule="required" value="<%=client.getFullName()%>"/>
                                <input type="hidden" name="idClient" id="nom" data-rule="required" value="<%=client.getIdClient()%>"/>        
        <div class="validation"></div>
       </div> 

            <div class="form-group">
            <p>Cin <span>*</span></p>
            <span class="icon-case"><i class="fa fa-user"></i></span>
            <input type="text" name="cin" id="prenom" data-rule="required" value="<%=client.getCin()%>"/>
                <div class="validation"></div>
			</div>

			<div class="form-group">
			<p>E-mail <span>*</span></p>	
			<span class="icon-case"><i class="fa fa-envelope-o"></i></span>
                        <input type="email" name="email" id="email" data-rule="email"  value="<%=client.getEmail()%>"/>
                <div class="validation"></div>
			</div>	

			

			<div class="form-group">
			<p>Adersse <span>*</span></p>
			<span class="icon-case"><i class="fa fa-location-arrow"></i></span>
                        <input type="text" name="adresse" id="adresse" data-rule="required" value="<%=client.getAdresse()%>"/>
                <div class="validation"></div>
			</div>

			



	</div>

	<div class="rightcontact">	

			

			<div class="form-group">
			<p>Telephone <span>*</span></p>	
			<span class="icon-case"><i class="fa fa-phone"></i></span>
                        <input type="text" name="phone" id="phone" data-rule="maxlen:10" value="<%=client.getTelephone()%>"/>
                <div class="validation"></div>
			</div>

			

			
	</div>
	</div>
    </div>
<button type="submit" class="bouton-contact">Enregistrer Les Modification</button>
	<p class="message"> Paramètre avancé? <a href="#">Modifier le Mot de passe</a></p>
</form>	

                
  
</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript">

        $('.message a').click(function(){
         $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
        });
    </script>

</html>
<%@ include file="../Includes/footer.jsp" %>
