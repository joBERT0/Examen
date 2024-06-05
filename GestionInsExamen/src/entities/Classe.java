package entities;
import java.util.List;
public class Classe {
    private  int id_classe;
    private String libelle;
    private Niveau niveau;
    private Filiere filiere;
    List<ProfesseurClasse> professeurClasses;
    public List<ProfesseurClasse> getProfesseurClasses() {
        return professeurClasses;
    }
    public void setProfesseurClasses(List<ProfesseurClasse> professeurClasses) {
        this.professeurClasses = professeurClasses;
    }
   
    List<Inscription> Inscriptions;
   
    public Classe() {
    }
    public int getId_classe() {
        return id_classe;
    }
    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
  
   
    public Niveau getNiveau() {
        return niveau;
    }
    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
    public Filiere getFiliere() {
        return filiere;
    }
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    public List<Inscription> getInscriptions() {
        return Inscriptions;
    }
    public void setInscriptions(List<Inscription> inscriptions) {
        Inscriptions = inscriptions;
    }
} 
