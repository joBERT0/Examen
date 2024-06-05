package services;
import entities.Etudiant;
import repositories.EtudiantRepository;
public class EtudiantService {
    
    EtudiantRepository etudiantRepository = new EtudiantRepository();

    public Etudiant rechercherEtudiantParMatricule(String matricule){
        return etudiantRepository.selectEtudiantByMatricule(matricule);
     }

     public void insertEtudiant(Etudiant etudiant){
        etudiantRepository.insert(etudiant);
     }
     
}
