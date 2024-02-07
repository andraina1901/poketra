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
public class V_profil extends Requete{
    String nom;
    String idprofil;
    String profil;
    double taux;

    public String getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(String idprofil) {
        this.idprofil = idprofil;
    }
    
     public static V_profil[] getById(Connexion co, String idprofil) throws Exception{
        String[][] condition = new String[1][3];
        condition[0][0] = "idprofil"; condition[0][1] = idprofil; condition[0][2] = "=";
        Requete [] r = new V_profil().selectHafa(co, condition, "=");
        V_profil[] u = Utile.convertToType(r, V_profil.class);
        return u;
    }
    
    
    public static V_profil[] getAll(Connexion co) throws Exception{
        Requete [] r = new V_profil().selectHafa(co, null, null);
        V_profil[] u = Utile.convertToType(r, V_profil.class);
        return u;
    }

    public V_profil() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
    
}
