package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Classe;
import entities.Filiere;
import entities.Niveau;

public class ClasseRepository extends Database {
    private final String SQL_SELECT_CLASSE="select * from classe";
    private final String SQL_INSERT_CLASSE="INSERT INTO `classe` ( `id_classe`,`niveau`,`filiere`) VALUES (?,?,?);";
    private final String SQL_SELECT_BY_ID_CLASSE="SELECT * FROM `classe` where id like ? ";


    public List <Classe> selectAll(){
        List <Classe> classes= new ArrayList<>();
        try{
            openConnexion();
            initPreparedStatement(SQL_SELECT_CLASSE);
            ResultSet rs= executeSelect();
            while(rs.next()){
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
        catch(SQLException e){
            System.out.println("Erreur de connexion a la BD");
        }
        return classes;

    }
    public void insertClasse(Classe classe){
        try {
            openConnexion();
            initPreparedStatement(SQL_INSERT_CLASSE);
            statement.setInt(1,classe.getId_classe());
            statement.setDouble(2, classe.getFiliere().ordinal());
            statement.setDouble(3, classe.getNiveau().ordinal());
             executeUpdate();
        } catch (SQLException e) {
          
            e.printStackTrace();
        }
    }

    
       public Classe selectClasseById(int id_classe){
        Classe classe = null;
        try{
            openConnexion();
            initPreparedStatement(SQL_SELECT_BY_ID_CLASSE);
            statement.setInt(1,id_classe);
            ResultSet rs=executeSelect();
            if(rs.next()){
                classe=new Classe();
                classe.setId_classe(rs.getInt ("id_classe"));
                int niveau=rs.getInt("niveau");
                int filiere=rs.getInt("filiere");
                classe.setNiveau(Niveau.values()[niveau]);
                classe.setFiliere(Filiere.values()[filiere]);
                 
              

            }
            statement.close();
            rs.close();
            conn.close();

        }catch (SQLException e) {
            System.out.println("Erreur de connexion à la BD");
        }
        return classe;
    }
}
