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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public ClientBean update(ClientBean c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
