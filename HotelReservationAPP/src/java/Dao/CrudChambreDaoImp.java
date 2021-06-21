/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author rachid dev
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Factory;
import model.ChambreBean;
public class CrudChambreDaoImp implements CrudChambreDAO{
    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    @Override
    public void ajouter(ChambreBean chmb) throws SQLException {
        String query = "INSERT INTO Chambre (label,NumChanbre,price,image ) VALUES (?,?,?,?)";
		con =Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setString(1, chmb.getLabel());
        ps.setInt(2, chmb.getNumChanbre());
        ps.setDouble(3, chmb.getPrice());
        ps.setString(4, chmb.getImage());
        ps.executeUpdate();
        System.out.println("requete");
        
        con.close();
    }

    @Override
    public List<ChambreBean> getChambers() throws SQLException {
    ArrayList<ChambreBean> chambers = new ArrayList<ChambreBean>();	
	
	String query1 = "select * from Chambre";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query1);
    rs = ps.executeQuery();
    System.out.println("requete : select * from Chambre reussit \n");
    while(rs.next()){
    	System.out.println("label :"+rs.getString("label")+" | Num Chambre :"+rs.getInt("NumChanbre")+""); 
    	chambers.add(new ChambreBean(rs.getInt("idChambre"), rs.getString("label"), rs.getInt("NumChanbre"), rs.getBoolean("etat"), rs.getDouble("price"), rs.getString("image")));}
    
    con.close();
    return chambers;    
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String query2 = "DELETE FROM Chambre WHERE idChambre=?";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query2);
    ps.setInt(1, id);
    ps.executeUpdate();
    
    con.close();
    }

    @Override
    public void modifier(ChambreBean chm) throws SQLException {
        String query = "update Chambre set label = ?, NumChanbre = ?, etat = ?, price = ?, image = ? WHERE idChambre=?";
        con =Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setString(1, chm.getLabel());
        ps.setInt(2, chm.getNumChanbre());
        ps.setBoolean(3, chm.getEtat());
        ps.setDouble(4, chm.getPrice());
        ps.setString(5, chm.getImage());
        
        ps.setInt(6, chm.getIdChambre());
        
        ps.executeUpdate();
        
        System.out.println("ediiiitedddd");
    
        con.close();
        
    }

    @Override
    public ChambreBean getChambre(int id) throws SQLException {
        ChambreBean chambre = new ChambreBean();	
	
	String query1 = "select * from Chambre where idChambre = ?";
	con =Factory.dbConnect();
        ps = con.prepareStatement(query1);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while(rs.next()){
            chambre = new ChambreBean(rs.getInt("idChambre"), rs.getString("label"), rs.getInt("NumChanbre"), rs.getBoolean("etat"), rs.getDouble("price"), rs.getString("image"));
        }

        con.close();
        return chambre; 
    }
    
}
