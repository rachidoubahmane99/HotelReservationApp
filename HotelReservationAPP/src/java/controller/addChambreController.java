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
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.ChambreBean;

/**
 *
 * @author moham
 */
@MultipartConfig
@WebServlet("/newChambre")
public class addChambreController extends HttpServlet {

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
            out.println("<title>Servlet addChambreController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addChambreController at " + request.getContextPath() + "</h1>");
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
    
    CrudChambreDaoImp crudChambreDaoImp = new CrudChambreDaoImp();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        try {
                
            String label = request.getParameter("label");
            System.out.println(label);
            int numero = Integer.parseInt(request.getParameter("numero"));
            System.out.println(numero); 
            double prix = Integer.parseInt(request.getParameter("prix"));
                        
            Part part = request.getPart("image");
            

            
            Connection con = Factory.dbConnect();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Chambre (label,NumChanbre,price,image ) VALUES (?,?,?,?)");
            int result = 0;
            ps.setString(1, label);
            ps.setInt(2, numero);
            ps.setDouble(3, prix);
            //ps.setString(4, "");
            InputStream is = part.getInputStream();
            ps.setBlob(4, is);
            
            result = ps.executeUpdate();
                if (result > 0) {
                    System.out.println("gooood");
                } else {
                    System.out.println("nooot goood");
                }
            

            /*ChambreBean chambreBean = new ChambreBean(label,numero,prix,image);
            crudChambreDaoImp.ajouter(chambreBean);
            System.out.println("bien ajouter");
            session.setAttribute("newChambre", "Chambre bien ajouter");*/
        } catch (SQLException ex) {
            Logger.getLogger(addChambreController.class.getName()).log(Level.SEVERE, null, ex);
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
            HttpSession session =request.getSession();
            
            
            doGet(request, response);
        
       
        
            request.getServletContext().getRequestDispatcher("/adminViews/addChambre.jsp").forward(request, response);
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
