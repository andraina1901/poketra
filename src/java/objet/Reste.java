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
public class Reste extends Requete{
    String idmatiere_premiere;
    String libelle;
    double reste;
    
      public static Reste[] getAll(Connexion co) throws Exception{
        Requete [] r = new Reste().selectHafa(co, null, null);
        Reste[] u = Utile.convertToType(r, Reste.class);
        return u;
    }
      
         public static Reste getById(Connexion co, String id) throws Exception{
             String[][]cond = new String[1][3];
             cond[0][0]="idmatiere_premiere";cond[0][1]=id; cond[0][2]="=";
        Requete [] r = new Reste().selectHafa(co, cond, null);
        Reste[] u = Utile.convertToType(r, Reste.class);
        return u[0];
    }

    public String getIdmatiere_premiere() {
        return idmatiere_premiere;
    }

    public void setIdmatiere_premiere(String idmatiere_premiere) {
        this.idmatiere_premiere = idmatiere_premiere;
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

    public Reste() {
    }
}
