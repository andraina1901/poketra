package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;

public class Look extends Requete {
    private String idlook;
    private String libelle;

       
    public static Look[] getAll(Connexion co) throws Exception{
        Requete [] r = new Look().selectHafa(co, null, null);
        Look[] u = Utile.convertToType(r, Look.class);
        return u;
    }
    
    
    public Look(String libelle) {
        this.libelle = libelle;
    }

    public String getIdlook() {
        return idlook;
    }

    public void setIdlook(String idlook) {
        this.idlook = idlook;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    // Getters and setters

    public Look() {
    }
}
