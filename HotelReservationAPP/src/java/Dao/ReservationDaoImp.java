/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.CrudChambreDaoImp.con;
import static Dao.CrudChambreDaoImp.ps;
import static Dao.CrudChambreDaoImp.rs;
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
import model.ChambreBean;
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
    public List<ReservationBean> lister() throws SQLException{
        List<ReservationBean> reservations = new ArrayList<ReservationBean>();	
	
	String query1 = "select c.NumChanbre,r.idReservation,r.dateDebut,r.dateFin,r.NbrPersonne,r.Note,r.PaimentMode,r.TotalPrice,r.valide,r.annuler from Reservation r, Chambre c where c.idChambre=r.idChambre order by r.idReservation desc";
	con =Factory.dbConnect();
        ps = con.prepareStatement(query1);
        rs = ps.executeQuery();
        System.out.println("DONE");
        while(rs.next()){
            int numReservation = rs.getInt("r.idReservation");
            int numChambre = rs.getInt("c.NumChanbre");
            Date dateDebut = rs.getDate("r.dateDebut");
            Date dateFin = rs.getDate("r.dateFin");
            int nbrPersonne = rs.getInt("r.NbrPersonne");
            String note = rs.getString("r.Note");
            String paimentMode = rs.getString("r.PaimentMode");
            Double totalPrice = rs.getDouble("r.TotalPrice");
            Boolean valide = rs.getBoolean("r.valide");
            Boolean Annuler = rs.getBoolean("r.annuler");
            ReservationBean res = new ReservationBean(numReservation, numChambre, dateDebut, dateFin, nbrPersonne, note, paimentMode, totalPrice, valide,Annuler);
            reservations.add(res);
        }
        
        return reservations;
        
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
    	ReservationBean res = new ReservationBean(rs.getInt("idReservation"), rs.getInt("idClient"), rs.getInt("idChambre"), rs.getDate("dateDebut"), rs.getDate("dateFin"), rs.getInt("NbrPersonne"), rs.getString("Note"), rs.getString("PaimentMode"), rs.getDouble("TotalPrice") , rs.getBoolean("valide") ,rs.getBoolean("annuler"));
    	mesreservation.add(res);
    }
    
    con.close();
    return mesreservation;  
    }

    @Override
    public boolean AnnulerReservation(ReservationBean r) throws SQLException {
        String query2 = "UPDATE Reservation SET annuler = ? WHERE idReservation=?";
	con =Factory.dbConnect();
        ps = con.prepareStatement(query2);
        ps.setBoolean(1, true);
        ps.setInt(2, r.getIdReservation());
        int nbUpdated = ps.executeUpdate();
        
        System.out.println("Annuler");
        con.close();
        
        return nbUpdated!=0;  
    }

    @Override
    public boolean ValiderReservation(ReservationBean r) throws SQLException {
        String req="UPDATE Reservation SET valide=? WHERE idReservation=?";
        con =Factory.dbConnect();
        ps = con.prepareStatement(req);
        ps.setBoolean(1, true);
        ps.setInt(2,r.getIdReservation());
        int nbUpdated = ps.executeUpdate();
        
        System.out.println("Valiiderrr");

        con.close();
        
        return nbUpdated!=0;
    }
    

}
