package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;


public class V_prix extends Requete{
    String idmodel;
    String libelle;
    double prix;

    public V_prix() {
    }

     public static V_prix[] search(Connexion co, String prix1, String prix2) throws Exception{
        String[][] condition = new String[2][3];
        condition[0][0] = "prix"; condition[0][1] = prix1; condition[0][2] = ">=";
        condition[1][0] = "prix"; condition[1][1] = prix2; condition[1][2] = "<=";
        Requete [] r = new V_prix().selectHafa(co, condition, "and");
        V_prix[] u = Utile.convertToType(r, V_prix.class);
        return u;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
   

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
}
