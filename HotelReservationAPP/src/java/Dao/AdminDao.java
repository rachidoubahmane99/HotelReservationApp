/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.SQLException;
import java.util.List;
import model.AdminBean;

/**
 *
 * @author rachid dev
 */
public interface AdminDao {
    public AdminBean ajouter (AdminBean d);
    public List<AdminBean> lister();
    public AdminBean getAdmin (int id); //return un Admin
    public AdminBean update (AdminBean d); //modifier un Admin
    public void delete (int id); 
    public AdminBean VerifierAdmin (AdminBean d); 
}
