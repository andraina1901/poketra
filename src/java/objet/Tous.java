/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;


public class Tous extends Requete{
    String sexe;
    int nombre;

    public Tous() {
    }

      public static Tous[] getAll(Connexion co) throws Exception{
        Requete [] r = new Tous().selectHafa(co, null, null);
        Tous[] u = Utile.convertToType(r, Tous.class);
        return u;
    }
    
    public Tous(String sexe, int nombre) {
        this.sexe = sexe;
        this.nombre = nombre;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
}
