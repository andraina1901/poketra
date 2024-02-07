/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import requete.Requete;

public class Taux_look extends Requete{
    String idTaux_look;
    String idlook;
    double taux;

    public String getIdTaux_look() {
        return idTaux_look;
    }

    public void setIdTaux_look(String idTaux_look) {
        this.idTaux_look = idTaux_look;
    }

    public String getIdlook() {
        return idlook;
    }

    public void setIdlook(String idlook) {
        this.idlook = idlook;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public Taux_look(String idlook, double taux) {
        this.idlook = idlook;
        this.taux = taux;
    }

    public Taux_look() {
    }
}
