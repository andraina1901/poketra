package objet;

import base.Connexion;
import requete.Requete;

public class Metier_model extends Requete{
    String idmetier_model;
    String idmodel;
    String idmetier;
    int nombre;

    public String getIdmetier_model() {
        return idmetier_model;
    }

    public void setIdmetier_model(String idmetier_model) {
        this.idmetier_model = idmetier_model;
    }

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public String getIdmetier() {
        return idmetier;
    }

    public void setIdmetier(String idmetier) {
        this.idmetier = idmetier;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public void setNombre(Connexion co, int nombre) throws Exception {
        V_exceptionPersonnel v =  V_exceptionPersonnel.check(co, idmodel);
        if(v.getNombre_limite()-(v.getNombre() + nombre ) < 0){
            throw new Exception("le nombre entre est supperieur au nombre limite,vous devez entrer un nombre inferieur ou egal a  = "+ (v.getNombre_limite()-v.getNombre()));
        }
        this.nombre = nombre;
    }
    
    public Metier_model(Connexion co, String idmodel, String idmetier, int nombre) throws Exception {
        this.setIdmodel(idmodel);
        this.setIdmetier(idmetier);
        this.setNombre(co, nombre);
    }

    
     public Metier_model(String idmodel, String idmetier, int nombre) throws Exception {
        this.setIdmodel(idmodel);
        this.setIdmetier(idmetier);
        this.setNombre(nombre);
    }
     
    public Metier_model() {
    }
}
