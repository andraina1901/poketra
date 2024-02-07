package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;

public class Matiere_look extends Requete {
    private String idmatiere_look;
    private String idmatiere_premiere;
    private String idlook;

    public String getIdmatiere_look() {
        return idmatiere_look;
    }

    public void setIdmatiere_look(String idmatiere_look) {
        this.idmatiere_look = idmatiere_look;
    }

    public String getIdmatiere_premiere() {
        return idmatiere_premiere;
    }

    public void setIdmatiere_premiere(String idmatiere_premiere) {
        this.idmatiere_premiere = idmatiere_premiere;
    }

    public static Matiere_look[] getAll(Connexion co) throws Exception{
        Requete [] r = new Matiere_look().selectHafa(co, null, null);
        Matiere_look[] u = Utile.convertToType(r, Matiere_look.class);
        return u;
    }


    public String getIdlook() {
        return idlook;
    }

    public void setIdlook(String idlook) {
        this.idlook = idlook;
    }


    public Matiere_look(String idmatierePremiere, String idlook) {
        this.idmatiere_premiere= idmatierePremiere;
        this.idlook = idlook;
    }

    // Getters and setters

    public Matiere_look() {
    }
}