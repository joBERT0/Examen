package repositories;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entities.Classe;
import entities.*;
public class ResponsablePedagogiqueRepository extends Database {
    private final String SQL_SELECT_ALL_CLASSE="select * from classe" ;
    private final String SQL_INSERT_CLASSE="INSERT INTO classe (filiere, niveau) VALUES (?,?)";

    public List<Classe> selectALLClasse(){
        List<Classe> classes=new ArrayList<>();
        try {
            openConnexion();
            initPreparedStatement(SQL_SELECT_ALL_CLASSE);
            ResultSet rs=executeSelect();
            while (rs.next()) {
                Classe classe=new Classe();
                classe.setId_classe(rs.getInt("id_classe"));
                int niveau=rs.getInt("niveau");
                int filiere=rs.getInt("filiere");
                classe.setNiveau(Niveau.values()[niveau]);
                classe.setFiliere(Filiere.values()[filiere]);
                classes.add(classe); 
            }
            rs.close();
            closeConnexion();

        }
         catch (Exception e) {
            System.out.println("Erreur de connection à la BD");
        }
        return classes;
    }

    public void insertClasse(Classe classe){
        openConnexion();
        try {
            initPreparedStatement(SQL_INSERT_CLASSE);
            statement.setDouble(1, classe.getFiliere().ordinal());
            statement.setDouble(2, classe.getNiveau().ordinal());
            int nbreLigne=executeUpdate();
            closeConnexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(Professeur professeur){
        openConnexion();
        try {
            initPreparedStatement(SQL_INSERT_CLASSE);
            statement.setInt(1, professeur.getNci());
            statement.setString(2, professeur.getNomComplet());
            statement.setString(3, professeur.getGrade());
            int nbreLigne=executeUpdate();
            closeConnexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
