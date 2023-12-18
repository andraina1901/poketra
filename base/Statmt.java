package base;
import java.sql.*;
import java.lang.*;
public class Statmt{
    
    public Statement getStatmt(Connexion co) throws SQLException{
        if(co.getCon()==null){
            Connection connex = co.SeConnecter();
            Statement stat = connex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            return  stat;
        }else if(co.getCon().isClosed()==true){
            Connection connex = co.SeConnecter();
            Statement stat = connex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            return  stat;
        }else{
            Statement stat = co.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            return  stat;
        }
    }


}