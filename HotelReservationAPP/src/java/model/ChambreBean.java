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
public class ChambreBean {
    
    
int IdChambre;	
String label ;	
int NumChanbre;	
Boolean etat; 	
Double price; 	
String image;

    public ChambreBean(int IdChambre, String label, int NumChanbre, Boolean etat, Double price, String image) {
        this.IdChambre = IdChambre;
        this.label = label;
        this.NumChanbre = NumChanbre;
        this.etat = etat;
        this.price = price;
        this.image = image;
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
        return image;
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
        this.image = image;
    }
    
    

}