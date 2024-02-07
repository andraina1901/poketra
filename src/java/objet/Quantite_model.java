package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;

public class Quantite_model extends Requete{
    String idquantite_model;
    String idmodel;
    String idmatiere_premiere;
    double quantite;

    public Quantite_model(String idmodel, String idmatiere_premiere, double quantite) {
        this.idmodel = idmodel;
        this.idmatiere_premiere = idmatiere_premiere;
        this.quantite = quantite;
    }
    
      public static Quantite_model[] getById(Connexion co, String id) throws Exception{
        String[][]cond = new String[1][3];
        cond[0][0]="idmodel";cond[0][1]=id; cond[0][2]="=";
        Requete [] r = new Quantite_model().selectHafa(co, cond, null);
        Quantite_model[] u = Utile.convertToType(r, Quantite_model.class);
        return u;
    }
    
    public String getIdmatiere_premiere() {
        return idmatiere_premiere;
    }

    public void setIdmatiere_premiere(String idmatiere_premiere) {
        this.idmatiere_premiere = idmatiere_premiere;
    }

    public String getIdquantite_model() {
        return idquantite_model;
    }

    public void setIdquantite_model(String idquantite_model) {
        this.idquantite_model = idquantite_model;
    }

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }


    public Quantite_model() {
    }
}
