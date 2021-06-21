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

import java.sql.SQLException;
import java.util.List;

import model.ChambreBean;

public interface CrudChambreDAO {

	public void ajouter(ChambreBean chmb)throws SQLException;
	public List<ChambreBean> getChambers()throws SQLException;
        public ChambreBean getChambre(int id) throws SQLException;
	public void supprimer(int id)throws SQLException;
        public void modifier(ChambreBean chm)throws SQLException;
}