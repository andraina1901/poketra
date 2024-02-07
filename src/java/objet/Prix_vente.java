package objet;

import requete.Requete;


public class Prix_vente extends Requete{
    String idprix_vente;
    String idmodel;
    double prix_vente;

    public String getIdprix_vente() {
        return idprix_vente;
    }

    public void setIdprix_vente(String idprix_vente) {
        this.idprix_vente = idprix_vente;
    }

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public double getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }

    public Prix_vente(String idmodel, double prix_vente) {
        this.idmodel = idmodel;
        this.prix_vente = prix_vente;
    }

    public Prix_vente() {
    }
}
