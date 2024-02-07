package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;


public class Dimension extends Requete {
    private String iddimension;
    private String libelle;

    public static Dimension[] getAll(Connexion co) throws Exception{
        Requete [] r = new Dimension().selectHafa(co, null, null);
        Dimension[] u = Utile.convertToType(r, Dimension.class);
        return u;
    }
    
    public String getIddimension() {
        return iddimension;
    }

    public void setIddimension(String iddimension) {
        this.iddimension = iddimension;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Dimension(String libelle) {
        this.libelle = libelle;
    }

    // Getters and setters

    public Dimension() {
    }
}