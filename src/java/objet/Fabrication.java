/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objet;

import base.Connexion;
import base.Statmt;
import func.Utile;
import java.sql.ResultSet;
import java.sql.Statement;
import requete.Requete;


public class Fabrication extends Requete{
    String idfabrication;
    String idmodel ;
    double quantite;

    public static void updateFab(Connexion co, double quantite, String idModel) throws Exception{
        String[][] condition = new String[1][3];
        condition[0][0] = "idmodel"; condition[0][1] = idModel; condition[0][2] = "=";
        Requete [] r = new Fabrication().selectHafa(co, null, null);
        Fabrication[] u = Utile.convertToType(r, Fabrication.class);
        Fabrication fab = u[0];
        fab.setQuantite(fab.quantite- quantite);
        fab.update(co);
//        return u;
//         update fabrication set quantite = quantite-1 where idModel='Model000003';
    }
    
    public Fabrication(Connexion co, String idmodel, double quantite) throws Exception {
        this.idmodel = idmodel;
        this.setQuantite(co, quantite);
    }

    public Fabrication() {
    }

    public String getIdfabrication() {
        return idfabrication;
    }

    public void setIdfabrication(String idfabrication) {
        this.idfabrication = idfabrication;
    }

    public String getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(String idmodel) {
        this.idmodel = idmodel;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    
      public static Fabrication[] getAll(Connexion co) throws Exception{
        Requete [] r = new Fabrication().selectHafa(co, null, null);
        Fabrication[] u = Utile.convertToType(r, Fabrication.class);
        return u;
    }
    public void setQuantite(Connexion co,double quantite) throws Exception {
        Verify []v = Verify.getById(co, idmodel);
        for(int i=0; i< v.length; i++){
            if(v[i].getQuantite()*quantite > v[i].getReste()){
                double rep =(v[i].getQuantite()*quantite )- v[i].getReste();
                throw new Exception("tsy ampy "+ v[i].libelle+" "+ rep);
            }
        }
        this.quantite = quantite;
    }
}
