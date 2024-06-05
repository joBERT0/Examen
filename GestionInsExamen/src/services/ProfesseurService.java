package services;

import java.util.List;

import entities.Classe;
import entities.Professeur;
import entities.ProfesseurClasse;
import repositories.ProfesseurClasseRepository;
import repositories.ProfesseurRepository;

public class ProfesseurService {
    ProfesseurRepository professeurRepository=new ProfesseurRepository();
    ProfesseurClasseRepository professeurClasseRepository= new ProfesseurClasseRepository();

    public void ajouterProfesseur(Professeur professeur){
        professeurRepository.insert(professeur);

        Professeur lastProfesseur=professeurRepository.selectLastProfesseur();

        List<ProfesseurClasse> professeurClasses = professeur.getProfesseurClasses();
        for(ProfesseurClasse pc : professeurClasses){
            pc.setProfesseur(lastProfesseur);
            professeurClasseRepository.insert(pc);
        }
        
    }
    public void insertProfesseur(Professeur professeur){
        professeurRepository.insert(professeur);
    }
    public List<Professeur>listerProfesseurs(){
        return professeurRepository.selectALL(); 
    }
    
    
}
