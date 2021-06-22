/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ClientDaoImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClientBean;

/**
 *
 * @author rachid dev
 */
@WebServlet(name = "ClientProfileController", urlPatterns = {"/profile"})
public class ClientProfileController extends HttpServlet {
     ClientDaoImp db = new ClientDaoImp();

    
    
    
       public ClientProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
            HttpSession session =request.getSession();
            
            if (session.getAttribute("loggedIn") == null) {
            request.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
            }
             if(session.getAttribute("loggedIn") !="Client") {
            request.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
            }
            else {
                 ClientBean client = (ClientBean)session.getAttribute("compte");
           
                 request.getServletContext().getRequestDispatcher("/ClientViews/profile.jsp").forward(request, response);
            }
    
    
    
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        ClientBean cl;
        String action = request.getParameter("action");
        request.setAttribute("FormName", action);
 
        if (action.equals("EditInfo")) {
            String fullname = request.getParameter("nom");
            String email = request.getParameter("email");
            String cin = request.getParameter("cin");
            String adr = request.getParameter("adresse");
            String telephone = request.getParameter("phone");
            int idClient = Integer.parseInt(request.getParameter("idClient"));
            
            
            if (fullname!="" && email!="" && cin!="" && adr!="" && telephone!="") {
                ClientBean c = new ClientBean();
                c.setFullName(fullname);
                c.setEmail(email);
                c.setCin(cin);
                c.setAdresse(adr);
                c.setTelephone(telephone);
                c.setIdClient(idClient);
                Boolean resultat;
                try {
                    resultat = db.update(c);
                     request.setAttribute("DATA", "Info  Modifié avec succes ");     
                    HttpSession session =request.getSession();
            
                    session.setAttribute("compte", c);
                request.getServletContext().getRequestDispatcher("/ClientViews/profile.jsp").forward(request, response);
                    System.out.println("successfully Updated");
                } catch (SQLException ex) {
                    Logger.getLogger(ClientProfileController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                   
                    request.setAttribute("message", "Tous Les champs sont Obligatoire  ");
                    request.getServletContext().getRequestDispatcher("/ClientViews/profile.jsp").forward(request, response);

                }
               
            
        }else if (action.equals("EditPass")) {
            String nvpass = request.getParameter("nvpassword");
            String oldpass = request.getParameter("oldpassword");
            int idClient = Integer.parseInt(request.getParameter("idClient"));
            if (nvpass!="" && oldpass!="" && nvpass.equals(oldpass) ) {
                ClientBean c = new ClientBean();
                c.setPassword(nvpass);
                c.setIdClient(idClient);
                Boolean resultat;
                try {
                    resultat = db.updatePassword(c);
                     request.setAttribute("DATA", "  Mot de passe modifié avec succes ");
                request.getServletContext().getRequestDispatcher("/ClientViews/profile.jsp").forward(request, response);
                    System.out.println("successfully Updated");
                } catch (SQLException ex) {
                      request.setAttribute("DATA", "  Mot de passe  NO modifié avec succes ");
                request.getServletContext().getRequestDispatcher("/ClientViews/profile.jsp").forward(request, response);
                    System.out.println(" Not successfully Updated");
                
                }
                }else{
                   
                    request.setAttribute("message", "Tous Les champs sont Obligatoire  ");
                    request.getServletContext().getRequestDispatcher("/ClientViews/profile.jsp").forward(request, response);

                }
    
    
        }
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
