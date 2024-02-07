/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import requete.Requete;

/**
 *
 * @author itu
 */
public class Experience extends Requete{
    String idexperience;
    String idprofil;
    int annee1;
    int annee2;

    public String getIdexperience() {
        return idexperience;
    }

    public void setIdexperience(String idexperience) {
        this.idexperience = idexperience;
    }

    public String getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(String idprofil) {
        this.idprofil = idprofil;
    }

    public int getAnnee1() {
        return annee1;
    }

    public void setAnnee1(int annee1) {
        this.annee1 = annee1;
    }

    public int getAnnee2() {
        return annee2;
    }

    public void setAnnee2(int annee2) {
        this.annee2 = annee2;
    }

    public Experience(String idprofil, int annee1, int annee2) {
        this.idprofil = idprofil;
        this.annee1 = annee1;
        this.annee2 = annee2;
    }

    public Experience() {
    }
}
