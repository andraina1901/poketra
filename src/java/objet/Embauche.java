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
public class Embauche extends Requete{
    String idembauche;
    String idpersonne;
    String idprofil;
    MyDate dateembauche;

    public String getIdembauche() {
        return idembauche;
    }

    public void setIdembauche(String idembauche) {
        this.idembauche = idembauche;
    }

    public String getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(String idpersonne) {
        this.idpersonne = idpersonne;
    }

    public String getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(String idprofil) {
        this.idprofil = idprofil;
    }

    public MyDate getDateembauche() {
        return dateembauche;
    }

    public void setDateembauche(MyDate dateembauche) {
        this.dateembauche = dateembauche;
    }

    public Embauche(String idpersonne, String idprofil, MyDate dateembauche) {
        this.idpersonne = idpersonne;
        this.idprofil = idprofil;
        this.dateembauche = dateembauche;
    }

    public Embauche() {
    }
}
