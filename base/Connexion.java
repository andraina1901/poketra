package base;
import java.sql.*;
import java.lang.*;

public class Connexion{
  Connection con;
  
  public Connection SeConnecter(){
    try
    {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:liantsoa","tovo","tovo");
      con.setAutoCommit(true);
//        Class.forName("org.postgresql.Driver");
//      con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root");
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