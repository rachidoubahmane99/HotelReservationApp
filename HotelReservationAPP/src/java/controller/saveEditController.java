/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.CrudChambreDaoImp;
import Dao.Factory;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.ChambreBean;

/**
 *
 * @author moham
 */
@MultipartConfig
@WebServlet("/saveEditChambre")
public class saveEditController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet saveEditController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet saveEditController at " + request.getContextPath() + "</h1>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            System.out.println("hi");
            String label = request.getParameter("label");
            System.out.println("labeel "+label);
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            
            int numero = Integer.parseInt(request.getParameter("numero"));
            boolean etat = Boolean.parseBoolean(request.getParameter("etat"));
            double prix = Double.parseDouble(request.getParameter("prix"));
            
            //String image = request.getParameter("image");
            Part part = request.getPart("image");
        try {
            Connection con = Factory.dbConnect();
            PreparedStatement ps = con.prepareStatement("update Chambre set label = ?, NumChanbre = ?, etat = ?, price = ?, image = ? WHERE idChambre=?");
            int result = 0;
            ps.setString(1, label);
            ps.setInt(2, numero);
            ps.setBoolean(3, etat);
            ps.setDouble(4, prix);
            InputStream is = part.getInputStream();
            ps.setBlob(5, is);
            ps.setInt(6, id);
            
            result = ps.executeUpdate();
                if (result > 0) {
                    System.out.println("gooood");
                } else {
                    System.out.println("nooot goood");
                }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(saveEditController.class.getName()).log(Level.SEVERE, null, ex);
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
    CrudChambreDaoImp crudChambreDaoImp = new CrudChambreDaoImp();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        doGet(request, response);
            response.sendRedirect(request.getContextPath()+"/gestionChambre");
        
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
