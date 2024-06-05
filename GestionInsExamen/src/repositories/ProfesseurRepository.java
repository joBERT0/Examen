package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Professeur;

public class ProfesseurRepository extends Database {
    private final String SQL_INSERT_PROFESSEUR = "INSERT INTO professeur (`nci`, `nomComplet`, `grade`) VALUES ( ?, ?, ?)";
    private final String SQL_LAST_VALUE_INSERT="SELECT Max(`id_professeur`) as max FROM `professeur`";
    private final String SQL_SELECT_ALL_PROFESSEUR="SELECT * from professeur ";
    // Méthode pour insérer un professeur
    // Méthode pour insérer un professeur
    public void insert(Professeur professeur) {
        try {
            openConnexion();
            initPreparedStatement(SQL_INSERT_PROFESSEUR);
            statement.setInt(1, professeur.getNci());
            statement.setString(2, professeur.getNomComplet());
            statement.setString(3, professeur.getGrade());
            executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

     public  Professeur selectLastProfesseur(){
        Professeur professeur=null;
        try {
            openConnexion();
            initPreparedStatement(SQL_LAST_VALUE_INSERT);
     
            ResultSet rs = executeSelect();
            while (rs.next()) {
                professeur=new Professeur(); 
                professeur.setId_professeur(rs.getInt("max")); 
             
            }
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return professeur;
      }
      public List<Professeur> selectALL(){
        List <Professeur> professeurs=new ArrayList<>();
        try{
            openConnexion();
            initPreparedStatement(SQL_SELECT_ALL_PROFESSEUR);
            ResultSet rs=executeSelect();
            while(rs.next()){
                Professeur professeur=new Professeur();
                professeur.setId_professeur(rs.getInt("id_professeur"));
                professeur.setNci(rs.getInt("Nci"));
                professeur.setNomComplet(rs.getString("nomComplet"));
                professeur.setGrade(rs.getString("grade"));
                professeurs.add(professeur);
            }
            rs.close();
            closeConnexion();
        }
        catch(SQLException e){
            System.out.println("Erreur de connexion à la BD");
        }
        return professeurs;
      }
    
}
