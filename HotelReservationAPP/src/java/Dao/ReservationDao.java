/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import model.ReservationBean;
import java.sql.SQLException;
import java.util.List;
import model.ClientBean;

/**
 *
 * @author rachid dev
 */
public interface ReservationDao {
    public void ajouter (ReservationBean r) throws SQLException;
    public List<ReservationBean> lister() throws SQLException;
    public List<ReservationBean> lister(ClientBean cl) throws SQLException;
    public boolean AnnulerReservation(ReservationBean r) throws SQLException;
    public boolean ValiderReservation(ReservationBean r) throws SQLException;
    
}
