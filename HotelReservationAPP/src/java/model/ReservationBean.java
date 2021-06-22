/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author rachid dev
 */
public class ReservationBean {
    int idReservation;
    int idClient;
    int idChambre;
    Date dateDebut;
    Date dateFin;
    int NbrPersonne;
    String Note;
    String PaimentMode;
    Double TotalPrice;
    int numChambre;
    boolean annuler;

    public void setAnnuler(boolean annuler) {
        this.annuler = annuler;
    }
    
    public Boolean getAnnuler() {
        return annuler;
    }

    public ReservationBean(int idReservation, Date dateDebut, Date dateFin, int NbrPersonne, String Note, String paimentMode, Double TotalPrice, Boolean valide,Boolean annuler) {
        this.idReservation = idReservation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.NbrPersonne = NbrPersonne;
        this.Note = Note;
        this.PaimentMode=paimentMode;
        this.TotalPrice=TotalPrice;
        this.valide = valide;
        this.annuler = annuler;
    }

    public int getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(int numChambre) {
        this.numChambre = numChambre;
    }
    
    

    public Double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public String getPaimentMode() {
        return PaimentMode;
    }

    public void setPaimentMode(String PaimentMode) {
        this.PaimentMode = PaimentMode;
    }
    Boolean valide;
    
    public  ReservationBean(){
        
    }
    public ReservationBean(int idReservation, int idClient, int idChambre, Date dateDebut, Date dateFin, int NbrPersonne, String Note, String paimentMode, Double TotalPrice, Boolean valide,Boolean annuler) {
        this.idReservation = idReservation;
        this.idClient = idClient;
        this.idChambre = idChambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.NbrPersonne = NbrPersonne;
        this.Note = Note;
        this.PaimentMode=paimentMode;
        this.TotalPrice=TotalPrice;
        this.valide = valide;
        this.annuler = annuler;
    }
    
    public ReservationBean(int idReservation, int numChambre, Date dateDebut, Date dateFin, int NbrPersonne, String Note, String paimentMode, Double TotalPrice, Boolean valide,Boolean annuler) {
        this.idReservation = idReservation;
        this.numChambre = numChambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.NbrPersonne = NbrPersonne;
        this.Note = Note;
        this.PaimentMode=paimentMode;
        this.TotalPrice=TotalPrice;
        this.valide = valide;
        this.annuler = annuler;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrPersonne() {
        return NbrPersonne;
    }

    public void setNbrPersonne(int NbrPersonne) {
        this.NbrPersonne = NbrPersonne;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }
    
    
    
    
}
