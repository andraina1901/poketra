package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;

public class Benefice extends Requete{
    
    String libelle;
    double prix_vente;
    double prix_revient;
    double benefice;

      public static Benefice[] getAll(Connexion co) throws Exception{
        Requete [] r = new Benefice().selectHafa(co, null, null);
        Benefice[] u = Utile.convertToType(r, Benefice.class);
        return u;
    }
      
        public static Benefice[] search(Connexion co, String prix1, String prix2) throws Exception{
        String[][] condition = new String[2][3];
        condition[0][0] = "benefice"; condition[0][1] = prix1; condition[0][2] = ">=";
        condition[1][0] = "benefice"; condition[1][1] = prix2; condition[1][2] = "<=";
        Requete [] r = new Benefice().selectHafa(co, condition, "and");
        Benefice[] u = Utile.convertToType(r, Benefice.class);
        return u;
    }
      
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }

    public double getPrix_revient() {
        return prix_revient;
    }

    public void setPrix_revient(double prix_revient) {
        this.prix_revient = prix_revient;
    }

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }

    public Benefice(String libelle, double prix_vente, double prix_revient, double benefice) {
        this.libelle = libelle;
        this.prix_vente = prix_vente;
        this.prix_revient = prix_revient;
        this.benefice = benefice;
    }

    public Benefice() {
    }
}
