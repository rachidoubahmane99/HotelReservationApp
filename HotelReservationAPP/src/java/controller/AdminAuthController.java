/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.AdminDaoImp;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AdminBean;

/**
 *
 * @author rachid dev
 */
@WebServlet(name = "AdminAuthController", urlPatterns = {"/admin"})
public class AdminAuthController extends HttpServlet {
    
    AdminDaoImp db = new AdminDaoImp();

    protected void doGet(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {
  processRequest(request, response);
 RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/LoginAdmin.jsp");
        rd.forward(request, response);
 }
 protected void doPost(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {
  processRequest(request, response);
  AdminBean ad;
  String action = request.getParameter("action");
  if (action.equals("admin")) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
            if (email!="" && password!="") {
        AdminBean a = new AdminBean(email, password);
        ad =  db.VerifierAdmin(a);
        if (ad== null) {
            request.setAttribute("DATA", "info Incorrects");
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/LoginAdmin.jsp");
        rd.forward(request, response);
        }
        
        else if (ad!= null) {
             HttpSession session =request.getSession();
            session.setAttribute("loggedIn", "Admin");
            response.sendRedirect("homeAdmin.jsp");
            System.out.println("successfully login");
             
       
        } 
  }
  }
  
 }
 protected void processRequest(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {
  
}
    
    
}
