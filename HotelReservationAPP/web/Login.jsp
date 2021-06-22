<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
    Document   : Login
    Created on : Jun 16, 2021, 2:42:17 PM
    Author     : rachid dev
--%>
    <%@ include file="Includes/header.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Layout/Login/login.css" />


    <div class="login-page">
  <div class="form">
          
        <% if (request.getAttribute("DATA")!=null){  %>
        <h3><%=request.getAttribute("DATA")%></h3>
          
       <% }%>
       
    <FORM class="register-form" NAME="form1" METHOD="POST" action="<%=request.getContextPath()%>/login?action=form1">
      <input type="text" placeholder="Nom Complet" name="fullname"/>
        <input type="text" placeholder="email address" name="email"/>
        <input type="password" placeholder="password" name="password"/>
        <input type="hidden" name="page" value="register"/>
        <button >Register</button>
      <p class="message">Already registered? <a href="">Sign In</a></p>
     </FORM>
     <FORM class="login-form" NAME="form2" METHOD="POST" action="<%=request.getContextPath()%>/login?action=form2">
      <input type="text" placeholder="username" name="email"/>
        <input type="password" placeholder="password" name="password"/>
        <input type="hidden" name="page" value="regiter"/>
        <button name="login">login</button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
     </FORM>
  </div>
</div>
    
        
             <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript">

        $('.message a').click(function(){
         $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
        });
    </script>
      <div class="page-content">  </div>


     <%@ include file="Includes/footer.jsp" %>
