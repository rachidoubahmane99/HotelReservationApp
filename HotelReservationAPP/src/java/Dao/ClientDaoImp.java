/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.CrudChambreDaoImp.con;
import static Dao.CrudChambreDaoImp.ps;
import model.ClientBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author rachid dev
 */
public class ClientDaoImp implements ClientDao{

    
     static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    @Override
    public ClientBean ajouter(ClientBean c) {
         return null;
        
    }
    @Override
    public Boolean Register(ClientBean c) throws SQLException {
    String query = "INSERT INTO Client (Email,FullName,password) VALUES (?,?,?)";
        con =Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setString(1, c.getEmail());
        ps.setString(2, c.getFullName());
        ps.setString(3, c.getPassword());
      int nbUpdated = ps.executeUpdate();

        con.close();
        return nbUpdated!=0;
     }

    @Override
    public ClientBean search(String cin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClientBean> lister() {
     List<ClientBean> clients = new ArrayList<ClientBean>();
      
        try {
            	
	String query1 = "SELECT * FROM Client";
	con =Factory.dbConnect();
        ps = con.prepareStatement(query1);
        rs = ps.executeQuery();           
            while(rs.next()){
                ClientBean c = new ClientBean();
                c.setIdClient(rs.getInt("idClient"));
                c.setCin(rs.getString("Cin"));
                c.setLogin(rs.getString("login"));
                c.setPassword(rs.getString("password"));
                c.setFullName(rs.getString("FullName"));
                c.setEmail(rs.getString("Email"));
                c.setAdresse(rs.getString("Adresse"));
                
                clients.add(c);
                
            
            }
            
        } catch (SQLException ex) {
            System.out.println("Error during listing Client");
        }
        return clients;    
    }

    @Override
    public ClientBean getClient(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(ClientBean c) throws SQLException{

        String query = "update Client set FullName = ?, Email = ?, Cin = ?, Telephone = ?, Adresse = ? WHERE idClient=?";
        con =Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setString(1, c.getFullName());
        ps.setString(2, c.getEmail());
        ps.setString(3, c.getCin());
        ps.setString(4, c.getTelephone());
        ps.setString(5, c.getAdresse());
        
        ps.setInt(6, c.getIdClient());
        

        int nbUpdated = ps.executeUpdate();

        con.close();
        System.out.println("success Update");
        return nbUpdated!=0;
 
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClientBean VerifierClient(ClientBean c) {
   
      ClientBean cl = null; 
        try {
            String query1 = "SELECT * FROM Client Where email = ? and password = ?";
            con =Factory.dbConnect();
            
            ps = con.prepareStatement(query1);
             ps.setString(1, c.getEmail());
             ps.setString(2, c.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                cl = new ClientBean();
                cl.setIdClient(rs.getInt("idClient"));
                cl.setLogin(rs.getString("login"));
                cl.setPassword(rs.getString("password"));
                cl.setFullName(rs.getString("FullName"));
                cl.setEmail(rs.getString("Email"));
                cl.setAdresse(rs.getString("Adresse"));
                cl.setCin(rs.getString("Cin"));
                cl.setTelephone(rs.getString("Telephone"));
                            }
         } catch (SQLException ex) {
            System.out.println("Error pendent chercher le client");
        }

        return cl;
    }   

    @Override
    public Boolean updatePassword(ClientBean c) throws SQLException {
        
    String query = "update Client set password = ? WHERE idClient=?";
        con =Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setString(1, c.getPassword());
        ps.setInt(2, c.getIdClient());
        
        int nbUpdated = ps.executeUpdate();

        con.close();
        
        return nbUpdated!=0;  
    }
    
    
    
    
    
    
}
