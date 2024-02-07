package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;


public class Matiere_premiere extends Requete {
    private String idmatiere_premiere;
    private String idunite;
    private String libelle;

    public String getIdmatiere_premiere() {
        return idmatiere_premiere;
    }

    public void setIdmatiere_premiere(String idmatiere_premiere) {
        this.idmatiere_premiere = idmatiere_premiere;
    }

    public String getUnite() {
        return idunite;
    }

    public void setUnite(String unite) {
        this.idunite = unite;
    }



    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Matiere_premiere(String unite, String libelle) {
        this.idunite = unite;
        this.libelle = libelle;
    }

    // Getters and setters

    public Matiere_premiere() {
    }
    
     public static Matiere_premiere[] getAll(Connexion co) throws Exception{
        Requete [] r = new Matiere_premiere().selectHafa(co, null, null);
        Matiere_premiere[] u = Utile.convertToType(r, Matiere_premiere.class);
        return u;
    }
}