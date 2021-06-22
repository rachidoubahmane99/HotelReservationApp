/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rachid dev
 */
public class AdminBean {
    int idAdmin;
    String login;
    String password;
    String FullName;

    public AdminBean(int idAdmin, String login, String password, String FullName) {
        this.idAdmin = idAdmin;
        this.login = login;
        this.password = password;
        this.FullName = FullName;
    }
    public AdminBean(int idAdmin, String password, String FullName) {
        this.idAdmin = idAdmin;
        this.password = password;
        this.FullName = FullName;
    }
    
    
    public AdminBean(){
        
    }
     public AdminBean(String login, String password){
        this.login = login;
        this.password = password;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }
    
    
    
}
