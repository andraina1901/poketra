
package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;

public class Unite extends Requete {
    private String idunite;
    private String libelle;

    
    public static Unite[] getAll(Connexion co) throws Exception{
        Requete [] r = new Unite().selectHafa(co, null, null);
        Unite[] u = Utile.convertToType(r, Unite.class);
        return u;
    }
    
    public String getIdunite() {
        return idunite;
    }

    public void setIdunite(String idunite) {
        this.idunite = idunite;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Unite(String libelle) {
        this.libelle = libelle;
    }

    // Getters and setters

    public Unite() {
    }
}