package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    protected Connection conn=null;
    protected PreparedStatement statement=null;
       public void  openConnexion(){
             try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaexamen" 
                , "root", ""); 
            } catch (ClassNotFoundException e) {
                System.out.println("Erreur de chargement du Driver");
            }
            catch (SQLException e) {
                System.out.println("Erreur Ouverture de la BD");
            } 
       }

    public void  closeConnexion(){
         if (conn!=null) {
            try {
                conn.close() ;
            } catch (SQLException e) {
                System.out.println("Erreur Fermeture de la BD");
            }   
         }
    }

     public void initPreparedStatement(String sql) throws SQLException{
            statement = conn.prepareStatement(sql);
     }

    public ResultSet  executeSelect(){
      ResultSet rs=null;
        try {
            rs= statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Erreur de Requete");
        }
        return rs;
    }

    public int  executeUpdate(){
        int nbreLigne=0;
        try {
            nbreLigne= statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Initialisation de Requete");
        }
        return nbreLigne;
    }

}
