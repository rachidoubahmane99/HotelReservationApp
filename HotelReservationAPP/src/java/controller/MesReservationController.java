/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ReservationDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClientBean;
import model.ReservationBean;

/**
 *
 * @author rachid dev
 */
@WebServlet(name = "MesReservationController", urlPatterns = {"/MesReservation"})
public class MesReservationController extends HttpServlet {
    
    
    	ReservationDaoImp db = new ReservationDaoImp();
        ArrayList<ReservationBean> mesreservation;

    public MesReservationController() {
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
            try {
                mesreservation = (ArrayList<ReservationBean>) db.lister(client);
                session.setAttribute("mesreservation", mesreservation);
		
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
                 request.getServletContext().getRequestDispatcher("/ClientViews/mesreservation.jsp").forward(request, response);
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
            ReservationBean r  = new ReservationBean();
        
            int idReserString = Integer.parseInt(request.getParameter("idReservation"));
            r.setIdReservation(idReserString);
                try {
                    db.AnnulerReservation(r);
                     request.setAttribute("DATA", "Reservation  Annulé avec succes ");
                     HttpSession session =request.getSession();
                    ClientBean client = (ClientBean)session.getAttribute("compte");
                    mesreservation = (ArrayList<ReservationBean>) db.lister(client);
                    session.setAttribute("mesreservation", mesreservation);
                request.getServletContext().getRequestDispatcher("/ClientViews/mesreservation.jsp").forward(request, response);
                    System.out.println("successfully Deleted");
                    
                } catch (SQLException ex) {
                   
                     request.setAttribute("DATA", "Reservation Non  Annulé avec succes ");     
                request.getServletContext().getRequestDispatcher("/ClientViews/mesreservation.jsp").forward(request, response);
                    System.out.println(" Not successfully Deleted");
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
