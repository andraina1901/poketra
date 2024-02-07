package gestion;

import base.Connexion;
import date.MyDate;
import func.Utile;
import objet.Achat_matiere;
import objet.Benefice;
import objet.Dimension;
import objet.Embauche;
import objet.Experience;
import objet.Fabrication;
import objet.Look;
import objet.Matiere_look;
import objet.Matiere_premiere;
import objet.Metier;
import objet.Metier_model;
import objet.Model;
import objet.Mouvement;
import objet.Nombre_taille;
import objet.Non_standard;
import objet.Personne;
import objet.Prix_matiere;
import objet.Prix_vente;
import objet.Profil;
import objet.Quantite_model;
import objet.Reste;
import objet.Salaire_metier;
import objet.Standard;
import objet.Statistique;
import objet.Taux_look;
import objet.Tous;
import objet.Type;
import objet.Unite;
import objet.V_matiere_look;
import objet.V_matiere_model;
import objet.V_prix;
import objet.V_profil;
import objet.Vente;
import requete.Requete;

public class Gestion {
    Connexion co;

    public Gestion() throws Exception{
        this.initConnex();
    }
    
    private void initConnex(){
        this.co = new Connexion();
        this.co.SeConnecter();
    }
    
    public void addLook(String look) throws Exception{
        Look k = new Look(look);
        k.insertHafa(co);
    }
    
    public Unite[] getUnites() throws Exception{
        return Unite.getAll(co);
    }
    
    public Look[] getLooks() throws Exception {
        return Look.getAll(co);
    }
    public Matiere_premiere[] getMatieres() throws Exception {
        return Matiere_premiere.getAll(co);
    }
    
    public Type[] getTypes() throws Exception {
        return Type.getAll(co);
    }
       
    public Dimension[] getDimensions() throws Exception {
        return Dimension.getAll(co);
    }
    
    public Model[] getModels() throws Exception {
        return Model.getAll(co);
    }
    
    public void addModel(String idlook, String idtype, String iddim, String lib) throws Exception{
        Model m = new Model(iddim, idlook,idtype,lib);
        m.insertHafa(co);  
    }
    
    public void addQuantite_Model(String idmodel, String idmatiere, String quantite) throws Exception{
        Quantite_model m = new Quantite_model(idmodel, idmatiere,Double.valueOf(quantite));
        m.insertHafa(co);  
    }
    
    public void addPrix_matiere(String idmatiere, String quantite) throws Exception{
        Prix_matiere m = new Prix_matiere(idmatiere, Double.valueOf(quantite), new MyDate());
        m.insertHafa(co);  
    }
    
    public V_prix[] searchPrix(String p1, String p2) throws Exception{
        return V_prix.search(co, p1, p2);
    }
    
     public Benefice[] search(String p1, String p2) throws Exception{
        return Benefice.search(co, p1, p2);
    }
    
    public void addUnite(String unite) throws Exception{
        Unite k = new Unite(unite);
        k.insertHafa(co);
    }
    
    public void addType(String type) throws Exception{
        Type k = new Type(type);
        k.insertHafa(co);
    }
    
     public void addDimension(String dimension) throws Exception{
        Dimension k = new Dimension(dimension);
        k.insertHafa(co);
    }
    
    public void addMatiere_premiere(String libelle, String unite) throws Exception{
        Matiere_premiere m = new Matiere_premiere(libelle, unite);
        m.insertHafa(co);
    }
    
    public void addMatiere_look(String idmatiere_premiere, String idlook) throws Exception{
        Matiere_look m = new Matiere_look(idmatiere_premiere, idlook);
        m.insertHafa(co);
    }
    
    public void addAchat_matiere(String idmatiere_premiere, String quantite, String prix) throws Exception{
        Achat_matiere am = new Achat_matiere(idmatiere_premiere,Double.valueOf(quantite),new MyDate());
        Prix_matiere m = new Prix_matiere(idmatiere_premiere, Double.valueOf(prix), new MyDate());
        m.insertHafa(co);  
        am.insertHafa(co);
    }
    
    public void addMouvement_entree(String idmatiere_premiere, String quantite, String prix) throws Exception{
         Mouvement am = new Mouvement(idmatiere_premiere,Double.valueOf(quantite),new MyDate(), 1);
        Prix_matiere m = new Prix_matiere(idmatiere_premiere, Double.valueOf(prix), new MyDate());
        m.insertHafa(co);  
        am.insertHafa(co);
    }
    
    public void addMouvement_sortie(String idmatiere_premiere, String quantite) throws Exception{
         Mouvement am = new Mouvement(idmatiere_premiere,Double.valueOf(quantite),new MyDate(), -1);
        am.insertHafa(co);
    }
    
    
    public void addFabrication(String idmodel, String quantite) throws Exception{
        Fabrication f = new Fabrication(co, idmodel, Double.valueOf(quantite));
        Quantite_model[] qm = Quantite_model.getById(co, idmodel);
        for(int i=0; i< qm.length; i++){
            Mouvement m = new Mouvement(qm[i].getIdmatiere_premiere(),Double.valueOf(quantite)*qm[i].getQuantite(),new MyDate(), -1);
            m.insertHafa(co);
        }
        f.insertHafa(co);
    }
    
    public void addSalaire_metier(String idmetier, String salaire) throws Exception{
        Salaire_metier am = new Salaire_metier(idmetier,Double.valueOf(salaire));
        am.insertHafa(co);
    }
    
    public void addNombre_taille(String idtaille, String nombre) throws Exception{
        Nombre_taille am = new Nombre_taille(idtaille,Double.valueOf(nombre));
        am.insertHafa(co);
    }
    
    public void addMetier(String libelle) throws Exception{
        Metier m = new Metier(libelle);
        m.insertHafa(co);
    }
    
     public void addTaux_look(String idlook, String volume) throws Exception{
        Taux_look am = new Taux_look(idlook,Double.valueOf(volume));
        am.insertHafa(co);
    }
     
    public void addMetier_model(String idmodel, String idmetier, String nombre) throws Exception{
        Metier_model am = new Metier_model(idmodel, idmetier, Integer.valueOf(nombre));
        am.insertHafa(co);
    }
    
    public void addPrix_vente(String idmodel, String prix_vente) throws Exception{
        Prix_vente pv = new Prix_vente(idmodel, Double.valueOf(prix_vente));
        pv.insertHafa(co);
    }
    
    
    public void addPersonne(String  nompersonne, String dtn, String adresse, String sexe) throws Exception{
        MyDate my = new MyDate(dtn, "yyyy-MM-dd");
        Personne p = new Personne(nompersonne, my,adresse, sexe);
        p.insertHafa(co);
    }
    
    public void addProfil(String libelle) throws Exception{
        Profil p = new Profil(libelle);
        p.insertHafa(co);
    }
    
    public void addEmbauche(String idpersonne,String idprofil, String dateembauche) throws Exception{
        MyDate my = new MyDate(dateembauche, "yyyy-MM-dd");
        Embauche e = new Embauche(idpersonne,idprofil,my);
        e.insertHafa(co);
    }
    
    public void addStandard(String idprofil, String taux) throws Exception{
        Standard d = new Standard(idprofil,Double.valueOf(taux));
        d.insertHafa(co);
    }
    
    public void addExperience(String idprofil, String annee1, String annee2) throws Exception{
        Experience ex = new Experience(idprofil,Integer.valueOf(annee1),Integer.valueOf(annee2));
        ex.insertHafa(co);
    }
    
    public void addNonStandard(String idprofil, String coefficient) throws Exception{
        Non_standard s = new Non_standard(idprofil,Double.valueOf(coefficient));
        s.insertHafa(co);
    }
    
    
    public void addVente(String idpersonne,String idmodel,String nombre,String date) throws Exception{
        MyDate m = new MyDate(date,"yyyy-MM-dd");
        Vente v= new Vente(idpersonne,idmodel,Integer.valueOf(nombre),m);
        Fabrication.updateFab(co, Double.valueOf(nombre), idmodel);
        v.insertHafa(co);
    }
    
    public Statistique[] getStatistique(String idmodel) throws Exception{
        return Statistique.getById(co, idmodel);
    }
    
     public Tous[] getTous() throws Exception{
        return Tous.getAll(co);
    }
    
    
    public Profil[] getProfil() throws Exception{
        return Profil.getAll(co);
    }
    
    public V_profil[] getV_profils ()throws Exception{
        return V_profil.getAll(co);
    }
    
    public V_profil[] getV_profil (String idprofil)throws Exception{
        return V_profil.getById(co,idprofil);
    }
    
    public V_matiere_look[] getV_matiere_look(String idlook) throws Exception{
        return V_matiere_look.search(co, idlook);
    }
    
    public V_matiere_model[] getV_matiere_model(String idmatiere) throws Exception{
        return V_matiere_model.search(co, idmatiere);
    }
    
    public Personne[] getPersonnes() throws Exception{
        return Personne.getAll(co);
    }
    
    public Reste[] getReste() throws Exception{
        return Reste.getAll(co);
    }
    
    public Metier[] getMetier() throws Exception{
        return Metier.getAll(co);
    }
    
    public Benefice[] getBenefice() throws Exception{
        return Benefice.getAll(co);
    }
    
    public Connexion getCo() {
        return co;
    }

    public void setCo(Connexion co) {
        this.co = co;
    }
    
    
}
