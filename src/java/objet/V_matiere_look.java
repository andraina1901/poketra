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
public class V_matiere_look extends Requete{
    String idlook;
    String idmatiere_premiere;
    String libelle;
    
       public static V_matiere_look[] search(Connexion co, String idlook) throws Exception{
        String[][] condition = new String[1][3];
        condition[0][0] = "idlook"; condition[0][1] = idlook; condition[0][2] = "=";
        Requete [] r = new V_matiere_look().selectHafa(co, condition, null);
        V_matiere_look[] u = Utile.convertToType(r, V_matiere_look.class);
        return u;
    }

    public String getIdlook() {
        return idlook;
    }

    public void setIdlook(String idlook) {
        this.idlook = idlook;
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

    public V_matiere_look(String idlook, String idmatiere_premiere, String libelle) {
        this.idlook = idlook;
        this.idmatiere_premiere = idmatiere_premiere;
        this.libelle = libelle;
    }

    public V_matiere_look() {
    }
}
