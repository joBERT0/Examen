package repositories;

import java.sql.SQLException;

import entities.ProfesseurClasse;
public class ProfesseurClasseRepository extends Database{
    private final String SQL_INSERT= "INSERT INTO professeurClasse ( `id_classe`, `id_professeur`) VALUES ( ?, ?)";

     public void insert(ProfesseurClasse professeurClasse){
        try {
            openConnexion();
            initPreparedStatement(SQL_INSERT);
            statement.setInt(1,professeurClasse.getId());
            statement.setDouble(2, professeurClasse.getClasse().getId_classe());
            statement.setDouble(3, professeurClasse.getProfesseur().getId_professeur());
             executeUpdate();
        } catch (SQLException e) {
          
            e.printStackTrace();
        }
 }
}
