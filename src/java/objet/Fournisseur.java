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
public class Fournisseur extends Requete{
    String idfounisseur;
    String libelle;

    public String getIdfounisseur() {
        return idfounisseur;
    }

    public void setIdfounisseur(String idfounisseur) {
        this.idfounisseur = idfounisseur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Fournisseur(String idfounisseur, String libelle) {
        this.idfounisseur = idfounisseur;
        this.libelle = libelle;
    }

    public Fournisseur() {
    }
}
