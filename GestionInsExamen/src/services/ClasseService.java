package services;
import java.util.List;
import repositories.ClasseRepository;
import entities.Classe;
public class ClasseService {
    ClasseRepository classeRepository= new ClasseRepository();

    public void ajouterClasse(Classe classe){
        classeRepository.insertClasse(classe);
    }
    public List<Classe>listerClasse(){
        return classeRepository.selectAll();
    }
    public Classe findClasseById(int id_classe){
        return classeRepository.selectClasseById(id_classe);
    }
}
