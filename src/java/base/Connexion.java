package base;
import java.sql.*;
import java.lang.*;

public class Connexion{
  Connection con;
  
  public Connection SeConnecter(){
    try
    {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/poketra","postgres","root");
    }
    catch(Exception e){ 
      System.out.println(e); 
    }
    return con;
    }

    public void fermer() throws SQLException{
      con.close();
    }
    
    public void commit() throws SQLException{
        con.commit();
    }
    
    public void rollback() throws SQLException{
        con.rollback();
    }

    public Connection getCon(){
      return con;
    }

}