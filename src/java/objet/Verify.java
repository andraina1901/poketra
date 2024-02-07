/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;

/**
 *
 * @author itu
 */
public class Verify extends Requete{
    String idmodel;
    String libelle;
    double reste;
    double quantite;
    
    public static Verify[] getById(Connexion co, String id) throws Exception{
             String[][]cond = new String[1][3];
             cond[0][0]="idmodel";cond[0][1]=id; cond[0][2]="=";
        Requete [] r = new Verify().selectHafa(co, cond, null);
        Verify[] u = Utile.convertToType(r, Verify.class);
        return u;
    }

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public Verify() {
    }
}
