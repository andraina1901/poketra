/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import date.MyDate;
import requete.Requete;

/**
 *
 * @author itu
 */
public class Achat_matiere extends Requete{
    String idachat_matiere;
    String idmatiere_premiere;
    double quantite;
    MyDate dateheure;

    public String getIdachat_matiere() {
        return idachat_matiere;
    }

    public void setIdachat_matiere(String idachat_matiere) {
        this.idachat_matiere = idachat_matiere;
    }

    public String getIdmatiere_premiere() {
        return idmatiere_premiere;
    }

    public void setIdmatiere_premiere(String idmatiere_premiere) {
        this.idmatiere_premiere = idmatiere_premiere;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }


    public MyDate getDateheure() {
        return dateheure;
    }

    public void setDateheure(MyDate dateheure) {
        this.dateheure = dateheure;
    }

    public Achat_matiere(String idmatiere_premiere, double quantite, MyDate dateheure) {
        this.idmatiere_premiere = idmatiere_premiere;
        this.quantite = quantite;
//        this.prix = prix;
        this.dateheure = dateheure;
    }

    public Achat_matiere() {
    }
}
