package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;

public class Type extends Requete {
    private String idtype;
    private String libelle;

     public static Type[] getAll(Connexion co) throws Exception{
        Requete [] r = new Type().selectHafa(co, null, null);
        Type[] u = Utile.convertToType(r, Type.class);
        return u;
    }
    
    public Type(String libelle) {
        this.libelle = libelle;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    // Getters and setters

    public Type() {
    }
}

