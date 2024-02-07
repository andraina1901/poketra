package objet;

import requete.Requete;

/**
 *
 * @author itu
 */
public class Standard extends Requete{
    String idstandard;
    String idprofil;
    double taux_horaire;

    public Standard() {
    }

    public Standard(String idprofil, double taux_horaire) {
        this.idprofil = idprofil;
        this.taux_horaire = taux_horaire;
    }

    public String getIdstandard() {
        return idstandard;
    }

    public void setIdstandard(String idstandard) {
        this.idstandard = idstandard;
    }

    public String getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(String idprofil) {
        this.idprofil = idprofil;
    }

    public double getTaux_horaire() {
        return taux_horaire;
    }

    public void setTaux_horaire(double taux_horaire) {
        this.taux_horaire = taux_horaire;
    }
    
}
