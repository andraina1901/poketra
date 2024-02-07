
package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;


public class V_matiere_model extends Requete{
    String idmatiere_premiere;
    String idmodel;
    String libelle;
    double quantite;

         public static V_matiere_model[] search(Connexion co, String idmatiere_premiere) throws Exception{
        String[][] condition = new String[1][3];
        condition[0][0] = "idmatiere_premiere"; condition[0][1] = idmatiere_premiere; condition[0][2] = "=";
        Requete [] r = new V_matiere_model().selectHafa(co, condition, null);
        V_matiere_model[] u = Utile.convertToType(r, V_matiere_model.class);
        return u;
    }
    
    public V_matiere_model() {
    }

    public V_matiere_model(String idmatiere_premiere, String idmodel, String libelle, double quantite) {
        this.idmatiere_premiere = idmatiere_premiere;
        this.idmodel = idmodel;
        this.libelle = libelle;
        this.quantite = quantite;
    }

    public String getIdmatiere_premiere() {
        return idmatiere_premiere;
    }

    public void setIdmatiere_premiere(String idmatiere_premiere) {
        this.idmatiere_premiere = idmatiere_premiere;
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

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    
}
