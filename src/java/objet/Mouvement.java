package objet;

import date.MyDate;
import requete.Requete;

public class Mouvement extends Requete{
     String idmouvement;
     String idmatiere_premiere;
     double entree;
     double sortie;
     MyDate dateheure;

    public Mouvement(String idmatiere_premiere, double quantite, MyDate dateheure, int mouv) {
        this.idmatiere_premiere = idmatiere_premiere;
        if(mouv==1){
            this.entree = quantite;
        }else if(mouv==-1){
            this.sortie = quantite;
        }
        this.dateheure = dateheure;
    }

    

    public String getIdmouvement() {
        return idmouvement;
    }

    public void setIdmouvement(String idmouvement) {
        this.idmouvement = idmouvement;
    }

    public String getIdmatiere_premiere() {
        return idmatiere_premiere;
    }

    public void setIdmatiere_premiere(String idmatiere_premiere) {
        this.idmatiere_premiere = idmatiere_premiere;
    }

    public double getEntree() {
        return entree;
    }

    public void setEntree(double entree) {
        this.entree = entree;
    }

    public double getSortie() {
        return sortie;
    }

    public void setSortie(double sortie) {
        this.sortie = sortie;
    }

    public MyDate getDateheure() {
        return dateheure;
    }

    public void setDateheure(MyDate dateheure) {
        this.dateheure = dateheure;
    }

    public Mouvement(String idmatiere_premiere, double entree, double sortie, MyDate dateheure) {
        this.idmatiere_premiere = idmatiere_premiere;
        this.entree = entree;
        this.sortie = sortie;
        this.dateheure = dateheure;
    }

    public Mouvement() {
    }
}
