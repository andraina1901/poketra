package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;


public class V_exceptionPersonnel extends Requete{
     String idmodel;
     double nombre;
     double nombre_limite;

    public double getNombre_limite() {
        return nombre_limite;
    }

    public void setNombre_limite(double nombre_limite) {
        this.nombre_limite = nombre_limite;
    }

    public static V_exceptionPersonnel check(Connexion co, String idmodel) throws Exception{
        String[][] condition = new String[2][3];
        condition[0][0] = "idmodel"; condition[0][1] = idmodel; condition[0][2] = "=";
        Requete [] r = new V_exceptionPersonnel().selectHafa(co, condition, null);
        V_exceptionPersonnel[] u = Utile.convertToType(r, V_exceptionPersonnel.class);
        return u[0];
    }
     
    public V_exceptionPersonnel() {
    }

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public double getNombre() {
        return nombre;
    }

    public void setNombre(double nombre) {
        this.nombre = nombre;
    }

     
}
