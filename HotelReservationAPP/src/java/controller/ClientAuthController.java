/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ClientDaoImp;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import model.ClientBean;

/**
 *
 * @author rachid dev
 */
public class ClientAuthController extends HttpServlet {

    
     ClientDaoImp db = new ClientDaoImp();
     
 
 
 protected void doGet(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {
  processRequest(request, response);
 
 }
 protected void doPost(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {
  processRequest(request, response);
  ClientBean cl;
  String action = request.getParameter("action");
  request.setAttribute("FormName", action);
 
  if (action.equals("form1")) {
  
      
      String fullname = request.getParameter("fullname");
                    String emailr = request.getParameter("email");
                    String passwordr = request.getParameter("password");
            if (emailr!="" && passwordr!="" && fullname!="") {
                ClientBean c = new ClientBean();
        c.setFullName(fullname);
        c.setPassword(passwordr);
        c.setEmail(emailr);
               
          try {
               Boolean resultat;
              resultat = db.Register(c);
              request.setAttribute("DATA", "Compte cree avec succes ");
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Login.jsp");
        rd.forward(request, response);
                    System.out.println("successfully login");
          } catch (SQLException ex) {
              request.setAttribute("DATA", "Compte NoT created");
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Login.jsp");
        rd.forward(request, response);
          }
               
                }else{
                    HttpSession session =request.getSession();
                    session.setAttribute("message", "Compte Non Crée ");
                    response.sendRedirect("Login.jsp"); 
                }
           
            
      
      
  }else if (action.equals("form2")) {
   String email = request.getParameter("email");
        String password = request.getParameter("password");
            if (email!="" && password!="") {
        ClientBean c = new ClientBean(email, password);
        cl =  db.VerifierClient(c);
        if (cl== null) {
            request.setAttribute("DATA", "info Incorrects");
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Login.jsp");
        rd.forward(request, response);
          //response.sendRedirect("Login.jsp");
        }
        
        else if (cl!= null) {
            ClientBean compte = cl;      
             HttpSession session =request.getSession();
            session.setAttribute("loggedIn", "Client");
            session.setAttribute("compte", compte);
            response.sendRedirect(request.getContextPath()+"/home");
            System.out.println("successfully login");
             
       
        } 
  }
  }
  
 }
 protected void processRequest(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {
  
}
     
}
