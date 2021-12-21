<%-- 
    Document   : profileAdmin
    Created on : Jun 22, 2021, 1:38:05 PM
    Author     : moham
--%>


<<html>
    <head>
        <title>Editer profile Admin</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Header.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Admin/EditProfile.css" />
    </head>
    <body>
        
        <%@page import="model.AdminBean"%>
        <%@ include file="../Includes/Admin/headerAdmin.jsp" %>

        <div>
            <h3 class="titre">Editer profile Admin</h3> 
        </div>


        <% AdminBean ch = (AdminBean)session.getAttribute("compteAd"); %>

        <form action="<%=request.getContextPath()%>/saveEditProfile" method="post" >
        <ul class="form-style-1">

            <input type="hidden" name="id" class="field-long" value="<%= ch.getIdAdmin()%>"  /> 
            <li>
                <label>Login<span class="required">*</span></label>
                <input type="text" name="login" class="field-long" value="<%= ch.getLogin() %>" readonly /> 
            </li>
            <li>
                <label>Full name <span class="required">*</span></label>
                <input type="text" name="fullname" class="field-long" value="<%= ch.getFullName() %>" />
            </li>
            <li>
                <label>Password <span class="required">*</span></label>
                <input type="password" name="password" class="field-long" />
            </li>
            <li>
                <input type="submit" value="Modifier" />
            </li>
            <li>
                <input type="reset" value="Cancel" />
            </li>
        </ul>
        </form>
<div class="page-content">  </div>
            <%@ include file="../Includes/footer.jsp" %>

    </body>
</html>



