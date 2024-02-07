/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import requete.Requete;

/**
 *
 * @author itu
 */
public class Non_standard extends Requete{
    String idnon_standard;
    String idprofil;
    double coefficient;

    public String getIdnon_standard() {
        return idnon_standard;
    }

    public void setIdnon_standard(String idnon_standard) {
        this.idnon_standard = idnon_standard;
    }

    public String getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(String idprofil) {
        this.idprofil = idprofil;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public Non_standard(String idprofil, double coefficient) {
        this.idprofil = idprofil;
        this.coefficient = coefficient;
    }

    public Non_standard() {
    }
}
