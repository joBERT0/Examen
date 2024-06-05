package services;

import repositories.ResponsablePedagogiqueRepository;
import entities.Classe;
import entities.Professeur;
import java.util.List;
public class ResponsablePedagogiqueService {
    ResponsablePedagogiqueRepository responsablePedagogiqueRepository= new ResponsablePedagogiqueRepository();

    public void ajouterClasse(Classe classe){
        responsablePedagogiqueRepository.insertClasse(classe);
    }
    public void ajouterProfesseur(Professeur professeur){
        responsablePedagogiqueRepository.insert(professeur);
    }
    public List<Classe>listerClasse(){
        return responsablePedagogiqueRepository.selectALLClasse();
    }
}

