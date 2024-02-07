package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;


public class Metier extends Requete{
    String idmetier;
    String libelle;

      public static Metier[] getAll(Connexion co) throws Exception{
        Requete [] r = new Metier().selectHafa(co, null, null);
        Metier[] u = Utile.convertToType(r, Metier.class);
        return u;
    }
    
    public Metier() {
    }

    public Metier(String libelle) {
        this.libelle = libelle;
    }

    public String getIdmetier() {
        return idmetier;
    }

    public void setIdmetier(String idmetier) {
        this.idmetier = idmetier;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
}
