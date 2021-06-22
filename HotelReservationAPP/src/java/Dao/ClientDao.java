/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.SQLException;
import java.util.List;
import model.ClientBean;

/**
 *
 * @author rachid dev
 */
public interface ClientDao {
    public ClientBean ajouter (ClientBean c);
    public ClientBean search (String cin); //chercher un client par son Cin
    public List<ClientBean> lister();
    public ClientBean getClient (int id); //return un client
    public Boolean update (ClientBean c) throws SQLException; //modifier un client
    public Boolean updatePassword (ClientBean c) throws SQLException; //modifier un client
    public void delete (int id); 
    public ClientBean VerifierClient (ClientBean c); 
    public Boolean Register(ClientBean c) throws SQLException;
}
