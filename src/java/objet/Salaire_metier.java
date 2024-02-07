
package objet;

import requete.Requete;


public class Salaire_metier extends Requete{
     String idsalaire_metier ;
     String idmetier;
     double taux_horaire;

    public String getIdsalaire_metier() {
        return idsalaire_metier;
    }

    public void setIdsalaire_metier(String idsalaire_metier) {
        this.idsalaire_metier = idsalaire_metier;
    }

    public String getIdmetier() {
        return idmetier;
    }

    public void setIdmetier(String idmetier) {
        this.idmetier = idmetier;
    }

    public double getTaux_horaire() {
        return taux_horaire;
    }

    public void setTaux_horaire(double taux_horaire) {
        this.taux_horaire = taux_horaire;
    }

    public Salaire_metier(String idmetier, double taux_horaire) {
        this.idmetier = idmetier;
        this.taux_horaire = taux_horaire;
    }

    public Salaire_metier() {
    }
}
