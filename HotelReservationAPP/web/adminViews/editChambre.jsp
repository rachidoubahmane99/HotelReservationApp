<%-- 
    Document   : editChambre
    Created on : Jun 21, 2021, 12:37:02 AM
    Author     : moham
--%>

<<html>
    <head>
        <title>Modifier une chambre</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Header.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Admin/editChambre.css" />
    </head>
    <body>
        <%@page import="model.ChambreBean"%>
<%@ include file="../Includes/Admin/headerAdmin.jsp" %>



<div>
    <h3 class="titre">Modifier une chambre</h3> 
</div>


    <% ChambreBean ch = (ChambreBean)session.getAttribute("chambre"); %>

    <form action="<%=request.getContextPath()%>/saveEditChambre" method="post" enctype="multipart/form-data">
    <ul class="form-style-1">

        <input type="hidden" name="id" class="field-long" value="<%= ch.getIdChambre() %>"  /> 
        <li>
            <label>Label<span class="required">*</span></label>
            <input type="text" name="label" class="field-long" value="<%= ch.getLabel() %>" /> 
        </li>
        <li>
            <label>Numéro <span class="required">*</span></label>
            <input type="text" name="numero" class="field-long" value="<%= ch.getNumChanbre() %>" />
        </li>
        <li>
            <label>Etat</label>
            <select name="etat" class="field-select" value="<%= ch.getEtat() %>">
            <option value="false">Disponible</option>
            <option value="true">Occupé</option>
            </select>
        </li>
        <li>
            <label>Prix <span class="required">*</span></label>
            <input type="text" name="prix" class="field-long" value="<%= ch.getPrice() %>" />
        </li>
        <li>
            <label>Image <span class="required">*</span></label>
            <input type="file" name="image" class="field-long"   />

        </li
        <li>
            <input type="submit" value="Modifier" />
        </li>
    </ul>
    </form>

<div class="page-content">  </div>
    <%@ include file="../Includes/footer.jsp" %>
    

    </body>
</html>


