<%@ include file="Includes/Admin/headerAdmin.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Header.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Admin/addChambre.css" />


<div>
    <h3 class="titre">Ajouter nouvelle chambre</h3> 
</div>


<form  action="<%=request.getContextPath()%>/newChambre" method="post" enctype="multipart/form-data" >
<ul class="form-style-1">
    <li>
        <label>Label<span class="required">*</span></label>
        <input type="text" name="label" class="field-long" /> 
    </li>
    <li>
        <label>Numéro <span class="required">*</span></label>
        <input type="text" name="numero" class="field-long" />
    </li>
    <li>
        <label>Prix <span class="required">*</span></label>
        <input type="text" name="prix" class="field-long" />
    </li>
    <li>
        <label>Image <span class="required">*</span></label>
        <input type="file" name="image" class="field-long" />
    </li>
    <li>
        <input type="submit" value="Ajouter" />
    </li>
</ul>
</form>
<%@ include file="Includes/footer.jsp" %>


