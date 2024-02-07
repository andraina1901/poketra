package objet;

import requete.Requete;


public class Nombre_taille extends Requete{
     String idnombre_taille ;
     String idtaille ;
     double nombre;

    public String getIdnombre_taille() {
        return idnombre_taille;
    }

    public void setIdnombre_taille(String idnombre_taille) {
        this.idnombre_taille = idnombre_taille;
    }

    public String getIdtaille() {
        return idtaille;
    }

    public void setIdtaille(String idtaille) {
        this.idtaille = idtaille;
    }

    public double getNombre() {
        return nombre;
    }

    public void setNombre(double nombre) {
        this.nombre = nombre;
    }

    public Nombre_taille(String idtaille, double nombre) {
        this.idtaille = idtaille;
        this.nombre = nombre;
    }

    public Nombre_taille() {
    }
    
}
