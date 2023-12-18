
package gestion;

import base.Connexion;
import requete.Requete;


public class GestionPanneau {
    Connexion co;

    public GestionPanneau(){
        co = new Connexion("panneau","panneau");
        co.SeConnecter();
    }

    
}
