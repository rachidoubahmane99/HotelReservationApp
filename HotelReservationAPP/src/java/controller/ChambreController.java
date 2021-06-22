/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Dao.CrudChambreDaoImp;

import jakarta.servlet.annotation.WebServlet;
import java.sql.SQLException;
import java.util.ArrayList;
import jakarta.servlet.http.HttpSession;
import model.ChambreBean;
/**
 *
 * @author rachid dev
 */

@WebServlet("/home")
public class ChambreController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    private static final long serialVersionUID = 1L;
	CrudChambreDaoImp db = new CrudChambreDaoImp();
    int t=0;

    public ChambreController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        HttpSession session =request.getSession();
            ArrayList<ChambreBean> chambres;
            
            if (session.getAttribute("loggedIn") == null) {
            request.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
            }
             if(session.getAttribute("loggedIn") !="Client") {
            request.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
            }
            else {
            try {
		chambres = (ArrayList<ChambreBean>) db.getChambers();
				
	        session.setAttribute("chambres", chambres);
	    } catch (SQLException e) {
			
		e.printStackTrace();
            }
		
		request.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

                //request.getServletContext().getRequestDispatcher("/gestionChambre.jsp").forward(request, response);

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
