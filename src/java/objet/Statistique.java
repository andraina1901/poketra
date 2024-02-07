/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;


public class Statistique extends Requete{
    String idmodel;
    String sexe;
    int nombre;

    public static Statistique[] getById(Connexion co, String id) throws Exception{
        String[][]cond = new String[1][3];
        cond[0][0]="idmodel";cond[0][1]=id; cond[0][2]="=";
        Requete [] r = new Statistique().selectHafa(co, cond, null);
        Statistique[] u = Utile.convertToType(r, Statistique.class);
        return u;
    }
    
    public Statistique() {
    }

    public Statistique(String sexe, int nombre) {
        this.sexe = sexe;
        this.nombre = nombre;
    }

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
}
