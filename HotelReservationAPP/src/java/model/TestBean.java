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
public class TestBean {
    int idClient; 	
    String Cin;
    String login; 	
    String password;
    String FullName; 	String Email;
    String Adresse;
    
    public TestBean(){
        
    }
    
    public TestBean(int idClient, String Cin, String login, String password, String FullName, String Email, String Adresse) {
        this.idClient = idClient;
        this.Cin=Cin;
        this.login = login;
        this.password = password;
        this.FullName = FullName;
        this.Email = Email;
        this.Adresse = Adresse;
    }

    public int getIdClient() {
        return idClient;
    }

     public String getCin() {
        return Cin;
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

    public String getEmail() {
        return Email;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
     public void setCin(String cin) {
        this.Cin = cin;
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

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }
    
}
