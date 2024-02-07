package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;


public class Profil extends Requete{
    String idprofil;
    String libelle;

    public static Profil[] getAll(Connexion co) throws Exception{
        Requete [] r = new Profil().selectHafa(co, null, null);
        Profil[] u = Utile.convertToType(r, Profil.class);
        return u;
    }
    
    
    
    public String getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(String idprofil) {
        this.idprofil = idprofil;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Profil(String libelle) {
        this.libelle = libelle;
    }

    public Profil() {
    }
}
