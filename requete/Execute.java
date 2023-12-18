/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requete;

import base.Connexion;
import base.Statmt;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author P15A-56-jeremia
 */
public class Execute {
    public static String[][] execute(Connexion co,String req)throws Exception{
        Statmt st = new Statmt();
        Statement stat = st.getStatmt(co);
//        System.out.println(req);
        ResultSet requete = stat.executeQuery(req);
        
        requete.last();
        int ligne = requete.getRow();
        requete.beforeFirst();
;
        ResultSetMetaData metadata = requete.getMetaData();
        int nbColumn  = metadata.getColumnCount();
        
        String[][] data= new String[ligne][nbColumn];
        int j=0;
        while(requete.next()){
            data[j]= new String[nbColumn];
            for(int i=1; i<=nbColumn;i++){
                data[j][i-1] = new String();
                data[j][i-1] = requete.getString(i);
            }
            j++;
        }
        return data;
    }
}
