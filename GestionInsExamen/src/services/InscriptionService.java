package services;
import java.util.List;
import entities.Inscription;
import repositories.InscriptionRepository; 

public class InscriptionService {
     InscriptionRepository inscriptionRepository=new InscriptionRepository();

    public void faireInscription(Inscription inscription){
        inscriptionRepository.insert(inscription);
    }
    public List<Inscription>listerInscriptionParAnnee(String anneeScolaire){
        return inscriptionRepository.selectInscriptionByAnnee(anneeScolaire);
    }

    public List<Inscription>listerInscriptionParAnnee(String anneeScolaire, int id){
        return inscriptionRepository.selectInscriptionByAnnee(anneeScolaire);
    }
    public Inscription rechercheInscriptionParMatriculeInscription(String matricule){
        return inscriptionRepository.selectInscriptionByMatricule(matricule);
    }
    
    
}
