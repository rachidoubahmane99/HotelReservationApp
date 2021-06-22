/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.ClientDaoImp.con;
import static Dao.ClientDaoImp.ps;
import static Dao.ClientDaoImp.rs;
import java.sql.SQLException;
import java.util.List;
import model.AdminBean;

/**
 *
 * @author rachid dev
 */
public class AdminDaoImp implements AdminDao {

    @Override
    public AdminBean ajouter(AdminBean d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AdminBean> lister() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdminBean getAdmin(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(AdminBean d) throws SQLException{
        String query = "update Admin set FullName = ?,password = ? WHERE idAdmin=?";
        con =Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setString(1, d.getFullName());
        ps.setString(2, d.getPassword());
        ps.setInt(3, d.getIdAdmin());
        
        int nbUpdated = ps.executeUpdate();

        con.close();
        
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdminBean VerifierAdmin(AdminBean d) {
        AdminBean admin = null; 
        try {
            String query1 = "SELECT * FROM Admin Where login = ? and password = ?";
            con =Factory.dbConnect();
            
            ps = con.prepareStatement(query1);
             ps.setString(1, d.getLogin());
             ps.setString(2, d.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                admin = new AdminBean();
                admin.setIdAdmin(rs.getInt("idAdmin"));
                admin.setLogin(rs.getString("login"));
                admin.setPassword(rs.getString("password"));
                admin.setFullName(rs.getString("FullName"));
                            }
         } catch (SQLException ex) {
            System.out.println("Error pendent chercher le client");
        }

        return admin;
    
    }
    
}
