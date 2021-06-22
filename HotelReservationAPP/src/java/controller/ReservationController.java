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
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClientBean;
import model.ReservationBean;

/**
 *
 * @author rachid dev
 */
@WebServlet(name = "ReservationController", urlPatterns = {"/Reservation"})
public class ReservationController extends HttpServlet {

     ReservationDaoImp db = new ReservationDaoImp();
    ArrayList<ReservationBean> mesreservation;
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
            
		
		request.getServletContext().getRequestDispatcher("/ClientViews/Reservation.jsp").forward(request, response);
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
 
try {
    int idClient = Integer.parseInt(request.getParameter("idClient"));
     int idChambre = Integer.parseInt(request.getParameter("idChambre"));
     SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date datedebut =   in.parse(request.getParameter("debut"));
            java.util.Date datefin =  in.parse(request.getParameter("fin")); 
            int nbrp = Integer.parseInt(request.getParameter("nbrPersonne"));
        String note = request.getParameter("note");
        String paiement = request.getParameter("paymentMode");
        double price = Double.parseDouble(request.getParameter("price"));
        ReservationBean r = new ReservationBean();
        r.setIdClient(idClient);
        r.setIdChambre(idChambre);
        r.setDateDebut(datedebut);
        r.setDateFin(datefin);
        r.setNbrPersonne(nbrp);
        r.setNote(note);
        r.setPaimentMode(paiement);
        r.setTotalPrice(price);
        db.ajouter(r);
         HttpSession session =request.getSession();
                    ClientBean client = (ClientBean)session.getAttribute("compte");
                    mesreservation = (ArrayList<ReservationBean>) db.lister(client);
                    session.setAttribute("mesreservation", mesreservation);
         request.getServletContext().getRequestDispatcher("/ClientViews/mesreservation.jsp").forward(request, response);
        } catch (ParseException ex) {
            request.getServletContext().getRequestDispatcher("/ClientViews/Reservation.jsp").forward(request, response);
        } catch (SQLException ex) {
             request.getServletContext().getRequestDispatcher("/ClientViews/Reservation.jsp").forward(request, response);
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
