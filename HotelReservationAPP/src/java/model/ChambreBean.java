/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.InputStream;

/**
 *
 * @author rachid dev
 */
public class ChambreBean {
    
    
int IdChambre;	
String label ;	
int NumChanbre;	
Boolean etat; 	
Double price; 	
  private String base64Image;
 
 
    public ChambreBean() {
    }


    public ChambreBean(int IdChambre, String label, int NumChanbre, Boolean etat, Double price, String image) {
        this.IdChambre = IdChambre;
        this.label = label;
        this.NumChanbre = NumChanbre;
        this.etat = etat;
        this.price = price;
        this.base64Image = image;
    }
    
    public ChambreBean(String label, int NumChanbre, Boolean etat, Double price, String image) {
        
        this.label = label;
        this.NumChanbre = NumChanbre;
        this.etat = etat;
        this.price = price;
        this.base64Image = image;
    }
    
    public ChambreBean(String label, int NumChanbre,Double price,String image) {
        
        this.label = label;
        this.NumChanbre = NumChanbre;
        this.price = price;
        this.base64Image = image;
    }

    public int getIdChambre() {
        return IdChambre;
    }

    public String getLabel() {
        return label;
    }

    public int getNumChanbre() {
        return NumChanbre;
    }

    public Boolean getEtat() {
        return etat;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage() {
        return base64Image;
    }

    public void setIdChambre(int IdChambre) {
        this.IdChambre = IdChambre;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setNumChanbre(int NumChanbre) {
        this.NumChanbre = NumChanbre;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.base64Image = image;
    }
    
    

}
