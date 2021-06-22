/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import model.ReservationBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import model.ClientBean;


/**
 *
 * @author rachid dev
 */
public class ReservationDaoImp implements ReservationDao{
    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    @Override
    public void ajouter(ReservationBean r) throws SQLException{
        String query = "INSERT INTO Reservation (idClient,idChambre,dateDebut,dateFin,NbrPersonne,Note,PaimentMode,TotalPrice) VALUES (?,?,?,?,?,?,?,?)";
		con =Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setInt(1, r.getIdClient());
        ps.setInt(2, r.getIdChambre());
        java.sql.Date dateD = new java.sql.Date(r.getDateDebut().getTime());
        java.sql.Date dateF = new java.sql.Date(r.getDateFin().getTime());
        ps.setDate(3, dateD);
        ps.setDate(4, dateF);
        ps.setInt(5, r.getNbrPersonne());
        ps.setString(6, r.getNote());
        ps.setString(7, r.getPaimentMode());
        long diff = r.getDateFin().getTime() - r.getDateDebut().getTime();
        double totalPrice =TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)*r.getTotalPrice();
        System.out.println(totalPrice);
        ps.setDouble(8,totalPrice);
        ps.executeUpdate();
        System.out.println("requete success");
        
        con.close();
    }

    @Override
    public List<ReservationBean> lister() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReservationBean> lister(ClientBean cl) throws SQLException {
    
    ArrayList<ReservationBean> mesreservation = new ArrayList<ReservationBean>();	
	
	String query1 = "select * from Reservation where idClient = "+cl.getIdClient()+"";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query1);
    rs = ps.executeQuery();
    System.out.println("requete : select * from Reservation reussit \n");
    while(rs.next()){
    	ReservationBean res = new ReservationBean(rs.getInt("idReservation"), rs.getInt("idClient"), rs.getInt("idChambre"), rs.getDate("dateDebut"), rs.getDate("dateFin"), rs.getInt("NbrPersonne"), rs.getString("Note"), rs.getString("PaimentMode"), rs.getDouble("TotalPrice") , rs.getBoolean("valide"));
    	mesreservation.add(res);
    }
    
    con.close();
    return mesreservation;  
    }

    @Override
    public boolean AnnulerReservation(ReservationBean r) throws SQLException {
        String query2 = "DELETE FROM Reservation WHERE idReservation=?";
	con =Factory.dbConnect();
        ps = con.prepareStatement(query2);
        ps.setInt(1, r.getIdReservation());
        int nbUpdated = ps.executeUpdate();

        con.close();
        
        return nbUpdated!=0;  
    }
    

}
