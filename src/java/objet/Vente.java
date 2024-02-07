package objet;

import date.MyDate;
import requete.Requete;


public class Vente extends Requete{
    String idvente;
    String idpersonne;
    String idmodel;
    int nombre;
    MyDate date;

    public String getIdvente() {
        return idvente;
    }

    public void setIdvente(String idvente) {
        this.idvente = idvente;
    }

    public String getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(String idpersonne) {
        this.idpersonne = idpersonne;
    }

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public Vente(String idpersonne, String idmodel, int nombre, MyDate date) {
        this.idpersonne = idpersonne;
        this.idmodel = idmodel;
        this.nombre = nombre;
        this.date = date;
    }

    public Vente() {
    }
}
