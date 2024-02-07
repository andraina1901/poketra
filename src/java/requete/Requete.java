package requete;
import base.*;
import date.MyDate;
import java.lang.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.lang.reflect.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Requete extends Object{

    public void setValue(String[] valeur){

    }
    
    public String getTest(){
        return "ca va";
    }
    
    public String prepareQuery(String table, String[][] condition, String param){
         String query= "SELECT*FROM " + table;
        if(condition!=null){
            query = query + " WHERE ";
            if(condition[0][2].equalsIgnoreCase("=")==true || condition[0][2].equalsIgnoreCase("!=")==true || condition[0][2].equalsIgnoreCase("like")==true){
                            query = query + condition[0][0] +" "+condition[0][2]+" '" + condition[0][1] + "'";
                    }else{
                         query = query + condition[0][0] +condition[0][2]+ condition[0][1];
                    }
            if(param!=null){
                 int nbcond = condition.length;
                for(int i=1; i<nbcond;i++){
                    query = query + " " + param + " ";
                    if(condition[i][2].equalsIgnoreCase("=")==true || condition[i][2].equalsIgnoreCase("!=")==true || condition[i][2].equalsIgnoreCase("like")==true){
                         query = query + condition[i][0] +" "+condition[i][2]+" '" + condition[i][1] + "'";
                    }else{
                         query = query + condition[i][0] +condition[i][2]+ condition[i][1];
                    }
                   
                }
            }
        }
        Field[] attribut = this.getClass().getDeclaredFields();
        query  = query+" order by "+attribut[0].getName()+" asc";
        return query;
    }
    public Requete[] returnRequete(ResultSet resultat)throws Exception{
        resultat.last();
        int ligne = resultat.getRow();
        
        resultat.beforeFirst();
        Requete[] req = new Requete[ligne];
        for(int i =0; i<req.length; i++){
            req[i] = this.getClass().getConstructor().newInstance();
        }

        return req;
    }

    public Requete[] select(Connexion co,String table,String[][] condition, String param) throws Exception{
        Statmt st = new Statmt();
        Statement stat = st.getStatmt(co);
        String query= prepareQuery(table,condition,param);
        System.out.println(query);
        ResultSet requete = stat.executeQuery(query);
        if(requete==null){
            return null;
        }
        Requete[] donne = returnRequete(requete);

        ResultSetMetaData metadata = requete.getMetaData();
        int nbColumn  = metadata.getColumnCount();

        String[][] data= new String[donne.length][nbColumn];
        int j=0;
        while(requete.next()){
            data[j]= new String[nbColumn];
            for(int i=1; i<=nbColumn;i++){
                data[j][i-1] = new String();
                data[j][i-1] = requete.getString(i);
            }
            j++;
        }
        for(int i=0; i<data.length;i++){
            donne[i].setValue(data[i]);
        }
        co.fermer();
        return donne;
    }

    public Requete[] selectHafa(Connexion co,String[][] condition, String param) throws Exception{
        Statmt st = new Statmt();
        String table = this.getClass().getSimpleName();
        Statement stat = st.getStatmt(co);
        String query= prepareQuery(table,condition,param);
        System.out.println(query);
        ResultSet requete = stat.executeQuery(query);
        Requete[] donne = returnRequete(requete);
        

        ResultSetMetaData metadata = requete.getMetaData();
        int nbColumn  = metadata.getColumnCount();

        String[][] data= new String[donne.length][nbColumn];
        int j=0;
        String[] colone = new String[nbColumn];
        for(int i=1; i<=nbColumn; i++){
            colone[i-1] = new String(metadata.getColumnName(i));
        }
        while(requete.next()){
            data[j]= new String[nbColumn];
            for(int i=1; i<=nbColumn;i++){
                data[j][i-1] = new String();
                data[j][i-1] = requete.getString(i);
            }
            j++;
        }
        int[] tab = getOrdre(colone);
        
        for(int i=0; i<data.length;i++){
            
            donne[i].setValeur(data[i],tab,colone);
        }
        co.fermer();
        return donne;
    }
    
    public Requete[] selectHafa(Connexion co,String table,String[][] condition, String param) throws Exception{
        Statmt st = new Statmt();
        Statement stat = st.getStatmt(co);
        String query= prepareQuery(table,condition,param);
        System.out.println(query);
        ResultSet requete = stat.executeQuery(query);
        Requete[] donne = returnRequete(requete);
        

        ResultSetMetaData metadata = requete.getMetaData();
        int nbColumn  = metadata.getColumnCount();

        String[][] data= new String[donne.length][nbColumn];
        int j=0;
        String[] colone = new String[nbColumn];
        for(int i=1; i<=nbColumn; i++){
            colone[i-1] = new String(metadata.getColumnName(i));
        }
        while(requete.next()){
            data[j]= new String[nbColumn];
            for(int i=1; i<=nbColumn;i++){
                data[j][i-1] = new String();
                data[j][i-1] = requete.getString(i);
            }
            j++;
        }
        int[] tab = getOrdre(colone);
        for(int i=0; i<data.length;i++){
            donne[i].setValeur(data[i],tab,colone);
        }
        co.fermer();
        return donne;
    }

    public int[] getOrdre(String[] col){
        Field[] attribut = this.getClass().getDeclaredFields();
        String[] attr = new String[attribut.length];
        for(int i=0; i<attribut.length; i++){
            attr[i] = new String();
             attr[i] = attribut[i].getName();
             
        }
        int k= 0;
        for(int j=0; j<attr.length; j++){
            for(int i=0; i<col.length; i++){
                if(attr[j].toUpperCase().hashCode()==col[i].toUpperCase().hashCode()){
                    k++;
                    i=attr.length;
                }
            }   
        }
        int[] tab = new int[k];
        int o = 0;
        for(int j=0; j<attr.length; j++){
            for(int i=0; i<col.length; i++){
                if(attr[j].toUpperCase().hashCode()==col[i].toUpperCase().hashCode()){
                    tab[o] = i;
                    o++;
                    i=attr.length;
                }
            }   
        }
        return tab;
    }

    public void setValeur(String[] data,int[] tab,String[] colone) throws Exception{
        Object c = this;
        int j = 0;
        Field[] attribut = c.getClass().getDeclaredFields();
        for(int i=0; i<tab.length; i++){
            attribut[i].setAccessible(true);
            if(isContain(attribut[i].getName(), colone)){
                if(data[tab[j]]!=null){
                    if(attribut[i].getType()==int.class){
                    attribut[i].set(c,Integer.valueOf(data[tab[j]]));
                    }if(attribut[i].getType()==String.class){
                        attribut[i].set(c,data[tab[j]]);
                    }if(attribut[i].getType()==double.class){
                        attribut[i].set(c,Double.valueOf(data[tab[j]]));
                    }if(attribut[i].getType()==float.class){
                        attribut[i].set(c,Float.valueOf(data[tab[j]]));
                    }if(attribut[i].getType()==Calendar.class){
                        Calendar ca= Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
                        ca.setTime(sdf.parse(data[tab[j]]));
                        attribut[i].set(c,ca);
                    }if(attribut[i].getType()==MyDate.class){
                        MyDate d = new MyDate(data[tab[j]]);
                        attribut[i].set(c,d);
                    }
                }
                
                j++;
            }

        }
        
    }

    public String[] getStringArray(String word){
        int nb =0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)==','){
                nb++;
            }
        }
        String[] aRetourner=new String[nb++];
        StringBuffer manangona=new StringBuffer();
        int j = 0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)==','){
                aRetourner[j] = new String(manangona);
                manangona = new StringBuffer();
                j++;
                i++;
            }
            if(i!=word.length()){
            manangona.append(word.charAt(i));
            }
        } 
        return aRetourner;
    }

    public void insert(Connexion co, String added)throws SQLException{    
        String table = this.getClass().getSimpleName();
        Statmt st = new Statmt();
        Statement stat = st.getStatmt(co);
        String[] inserer = getStringArray(added);
        String query= "INSERT INTO "+table+" VALUES(";
        query = query + "'" + inserer[0] + "'";
        for(int i=1; i<inserer.length; i++){
            query = query + ",'" + inserer[i] + "'";
        }
        query = query + ")";
        System.out.println(query);
        stat.executeQuery(query);
        stat.executeQuery("commit");
        co.fermer();
    }

public int[] getOrdreHafa(String[] col){
        Field[] attribut = this.getClass().getDeclaredFields();
        String[] attr = new String[attribut.length];
        for(int i=0; i<attribut.length; i++){
            attr[i] = new String();
             attr[i] = attribut[i].getName();
        }
        int[] tab = new int[attr.length];
        for(int j=0; j<col.length; j++){
            for(int i=0; i<attr.length; i++){
                if(attr[i].toUpperCase().hashCode()==col[j].toUpperCase().hashCode()){
                    tab[j] = i;
                    i=attr.length;
                }
            }   
        }
        return tab;
    }

    public String[] requireValue(int[] tab)throws Exception{
        String[] mois= new String[12];
        mois[11] = new String();
        mois[0] = "JAN";mois[1] = "FEB";mois[2] = "MAR";mois[3] = "APR";mois[4] = "MAY";mois[5] = "JUN";mois[6] = "JUL";mois[7] = "AUG";mois[8] = "SEP";mois[9] = "OCT";mois[10] = "NOV";mois[11] = "DEC";
        Object c = this;
        Field[] attribut = c.getClass().getDeclaredFields();
        String[] attr = new String[attribut.length];
        for(int i=0; i<attribut.length; i++){
        attr[i] = new String();
        attr[i] = attribut[i].getName().substring(0,1).toUpperCase()+""+attribut[i].getName().substring(1); 
        }
        String[] envoyer = new String[attribut.length];
        for(int i=0; i<tab.length; i++){
        envoyer[i] = new String();
        if(attribut[tab[i]].getType()==Date.class){
            Date d = (Date) c.getClass().getMethod("get"+attr[tab[i]]).invoke(c);
            
            envoyer[i] = d.getDay()+"-"+d.getMonth()+"-"+d.getYear();
        }
        else if(attribut[tab[i]].getType()==int.class){
        
        envoyer[i] = String.valueOf(c.getClass().getMethod("get"+attr[tab[i]]).invoke(c));
        }
        else if(attribut[tab[i]].getType()==double.class){
        
        String a = String.valueOf(c.getClass().getMethod("get"+attr[tab[i]]).invoke(c));
        double b = Double.valueOf(a);
        int o = (int) b;
        envoyer[i] = String.valueOf(o);
        }
        else if(attribut[tab[i]].getType()==Calendar.class){
            Calendar d = (Calendar) c.getClass().getMethod("get"+attr[tab[i]]).invoke(c);
            
            envoyer[i] = d.get(Calendar.DAY_OF_MONTH)+"-"+(d.get(Calendar.MONTH)+1)+"-"+d.get(Calendar.YEAR);
        }
        else if(attribut[tab[i]].getType()==MyDate.class){
            MyDate d = (MyDate) c.getClass().getMethod("get"+attr[tab[i]]).invoke(c);
            
        }
        else{
        envoyer[i] = String.valueOf(c.getClass().getMethod("get"+attr[tab[i]]).invoke(c));
        }
        }

        
        return envoyer;
    }

    public String maka(int i){
        String nb = String.valueOf(i);
        String valiny = "";
        for(int j = 0; j<6-nb.length(); j++){
            valiny = valiny + "0";
        }
        valiny = valiny + nb;
        return valiny;
    }

    public boolean isContain(String name, String[] colonnes){
        for (int i = 0; i < colonnes.length; i++) {
            if(name.equalsIgnoreCase(colonnes[i])){
                return true;
            }
        }
        return false;
    }

    public String getRequete(String[] colonnes,String id)throws Exception{
        Field[] attribut = this.getClass().getDeclaredFields();
        String requete = "INSERT INTO "+this.getClass().getSimpleName()+" ("+attribut[0].getName();
        String valeur = "VALUES ('"+this.getClass().getSimpleName()+id+"'";
        
        for(int i=1; i<attribut.length; i++){
            attribut[i].setAccessible(true);
            if(isContain(attribut[i].getName(), colonnes)){
                System.out.println(attribut[i].getName());
                requete +=","+attribut[i].getName();
                if(attribut[i].getType().equals(int.class) || attribut[i].getType().equals(double.class)){
                    valeur += ","+attribut[i].get(this);
                }else if(attribut[i].getType().equals(MyDate.class)){
                    MyDate d = (MyDate) this.getClass().getMethod("get"+attribut[i].getName().substring(0,1).toUpperCase()+""+attribut[i].getName().substring(1)).invoke(this);
                    valeur += ",to_timestamp('"+d.getDate("yyyy-MM-dd HH:mm:ss")+"','YYYY-MM-DD HH24:MI:SS')";
                }else {
                    valeur += ",'"+attribut[i].get(this)+"'";
                }
            }
        }
        valeur += ")";
        requete += ") "+valeur;
        return requete;
    }

    public String getRequeteUpdate(String[] colonnes)throws Exception{
        Field[] attribut = this.getClass().getDeclaredFields();
        String requete = "UPDATE "+this.getClass().getSimpleName()+" SET ";
        String virgule = "";
        for(int i=1; i<attribut.length; i++){
            attribut[i].setAccessible(true);
            if(isContain(attribut[i].getName(), colonnes)){
                if(i>1){
                    virgule = ",";
                }
                requete = requete + virgule+attribut[i].getName()+"='"+attribut[i].get(this)+"'"; 
            }
        }
        attribut[0].setAccessible(true);
        requete += " WHERE "+attribut[0].getName()+" = '"+attribut[0].get(this)+"'";
        return requete;
    }
    
    public String insertHafa(Connexion co,String table) throws Exception{
        Statmt st = new Statmt();
        Statement state = st.getStatmt(co);
        Statement statet = st.getStatmt(co);
        ResultSet requete = state.executeQuery("select*from "+table);
//        ResultSet requetes= statet.executeQuery("select sq"+table+".nextval from dual");
        ResultSet requetes = statet.executeQuery(" select nextval ('sq" + table +"')");
        requetes.next();
        int v = (int) requetes.getInt(1);
        
        
        ResultSetMetaData metadata = requete.getMetaData();
        int nbColumn  = metadata.getColumnCount();
        String[] colone = new String[nbColumn];
        
        for(int i=1; i<=nbColumn; i++){
            colone[i-1] = metadata.getColumnName(i);
        }
        
        String id = maka(v);
        
        String req= getRequete(colone, id);
        
        System.out.println(req);
        Statement stat = st.getStatmt(co);
        stat.executeQuery(req);
        stat.executeQuery("commit");
        co.fermer();
        return table+id;
    }
    
    public String insertHafa(Connexion co) throws Exception{    
        String table = this.getClass().getSimpleName();
        Statmt st = new Statmt();
        Statement state = st.getStatmt(co);
        Statement statet = st.getStatmt(co);
        ResultSet requete = state.executeQuery("select*from "+table);
//        ResultSet requetes= statet.executeQuery("select sq"+table+".nextval from dual");
        ResultSet requetes = statet.executeQuery(" select nextval ('sq" + table +"')");
        requetes.next();
        int v = (int) requetes.getInt(1);
        
        
        ResultSetMetaData metadata = requete.getMetaData();
        int nbColumn  = metadata.getColumnCount();
        String[] colone = new String[nbColumn];
        
        for(int i=1; i<=nbColumn; i++){
            colone[i-1] = new String(metadata.getColumnName(i));
        }
        
        int[] tab = getOrdreHafa(colone);
        
        String id = maka(v);
        
        String req= getRequete(colone, id);
        
        System.out.println(req);
        Statement stat = st.getStatmt(co);
        stat.execute(req);
//        stat.executeQuery("commit");
        co.fermer();
        return table+id;
    }

    public static void dater(Connexion co)throws SQLException{
        Statmt st = new Statmt();
        Statement stat = st.getStatmt(co);
        stat.executeQuery("alter session set nls_timestamp_format = 'YYYY-MM-DD HH24:MI:SS.FF5'");
        co.fermer();
    }

    public void update(Connexion co)throws Exception{
        try{
            String table = this.getClass().getSimpleName();
            Statmt st = new Statmt();
            Statement state = st.getStatmt(co);
            Statement statet = st.getStatmt(co);
    
            ResultSet requete = state.executeQuery("select*from "+table);
    
            ResultSetMetaData metadata = requete.getMetaData();
            int nbColumn  = metadata.getColumnCount();
            String[] colone = new String[nbColumn];
            for(int i=1; i<=nbColumn; i++){
           
                colone[i-1] = new String(metadata.getColumnName(i));
            }
            int[] tab = getOrdreHafa(colone);
            String[] inserer = requireValue(tab);
            String req= getRequeteUpdate(colone);
            System.out.println(req);
            Statement stat = st.getStatmt(co);
            stat.executeQuery(req);
         //   stat.executeQuery("commit");
            co.fermer();
            }catch(Exception ee){System.out.println(ee);}
    }

    public void delete(){
        
    }

}