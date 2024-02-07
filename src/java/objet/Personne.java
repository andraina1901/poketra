package objet;

import base.Connexion;
import date.MyDate;
import func.Utile;
import requete.Requete;


public class Personne extends Requete{
    String idpersonne;

    
       public static Personne[] getAll(Connexion co) throws Exception{
        Requete [] r = new Personne().selectHafa(co, null, null);
        Personne[] u = Utile.convertToType(r, Personne.class);
        return u;
    }
    
    
    public String getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(String idpersonne) {
        this.idpersonne = idpersonne;
    }

    public String getNompersonne() {
        return nompersonne;
    }

    public void setNompersonne(String nompersonne) {
        this.nompersonne = nompersonne;
    }

   
    public MyDate getDtn() {
        return dtn;
    }

    public void setDtn(MyDate dtn) {
        this.dtn = dtn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    String nompersonne;
    MyDate dtn;
    String adresse;
    String sexe;

    public Personne(String nom, MyDate dtn, String adresse, String sexe) {
        this.nompersonne = nom;
        this.dtn = dtn;
        this.adresse = adresse;
        this.sexe = sexe;
    }

    public Personne() {
    }
}
