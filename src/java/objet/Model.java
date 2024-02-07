package objet;

import base.Connexion;
import func.Utile;
import requete.Requete;


public class Model extends Requete{
    String idModel;
    String iddimension;
    String idlook;
    String idtype;
    
       
    public static Model[] getAll(Connexion co) throws Exception{
        Requete [] r = new Model().selectHafa(co, null, null);
        Model[] u = Utile.convertToType(r, Model.class);
        return u;
    }

    public Model(String iddimension, String idlook, String idtype, String libelle) {
        this.iddimension = iddimension;
        this.idlook = idlook;
        this.idtype = idtype;
        this.libelle = libelle;
    }
    String libelle;

    public String getIdModel() {
        return idModel;
    }

    public void setIdModel(String idModel) {
        this.idModel = idModel;
    }

    public String getIddimension() {
        return iddimension;
    }

    public void setIddimension(String iddimension) {
        this.iddimension = iddimension;
    }

    public String getIdlook() {
        return idlook;
    }

    public void setIdlook(String idlook) {
        this.idlook = idlook;
    }

    public String getIdtype() {
        return idtype;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }


    public Model() {
    }
}
