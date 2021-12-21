package controller;

import Dao.ReservationDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ChambreBean;
import model.ReservationBean;

/**
 *
 * @author moham
 */
@WebServlet("/gestionReservations")
public class adminReservationController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminReservationController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminReservationController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    
    ReservationDaoImp db = new ReservationDaoImp();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session =request.getSession();
            ArrayList<ReservationBean> reservations;
            
            if (session.getAttribute("loggedIn") == null) {
            request.getServletContext().getRequestDispatcher("/adminViews/LoginAdmin.jsp").forward(request, response);
            }
             if(session.getAttribute("loggedIn") !="Admin") {
            request.getServletContext().getRequestDispatcher("/adminViews/LoginAdmin.jsp").forward(request, response);
            }
            else {
            try {
		reservations = (ArrayList<ReservationBean>) db.lister();
				
	        session.setAttribute("reservations", reservations);
	    } catch (SQLException e) {
			
		e.printStackTrace();
            }
		
		request.getServletContext().getRequestDispatcher("/adminViews/gestionReservations.jsp").forward(request, response);
                //request.getServletContext().getRequestDispatcher("/gestionChambre.jsp").forward(request, response);
            }
        
        
        
        
        processRequest(request, response);
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
