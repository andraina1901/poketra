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
public class Prix_matiere extends Requete{
    String idprix_matiere;
    String idmatiere_premiere;
    double prix ;
    MyDate date;

    public Prix_matiere(String idmatiere_premiere, double prix, MyDate date) {
        this.idmatiere_premiere = idmatiere_premiere;
        this.prix = prix;
        this.date = date;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

//    public Prix_matiere(String idmatiere_premiere, double prix) {
//        this.idmatiere_premiere = idmatiere_premiere;
//        this.prix = prix;
//    }

    public Prix_matiere() {
    }

    public String getIdprix_matiere() {
        return idprix_matiere;
    }

    public void setIdprix_matiere(String idprix_matiere) {
        this.idprix_matiere = idprix_matiere;
    }

    public String getIdmatiere_premiere() {
        return idmatiere_premiere;
    }

    public void setIdmatiere_premiere(String idmatiere_premiere) {
        this.idmatiere_premiere = idmatiere_premiere;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) throws Exception {
        if(prix > 0){
            this.prix = prix;
        }else{
            throw new Exception("prix invalide");
        }
    }
}
