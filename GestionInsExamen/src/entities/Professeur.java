package entities;
import java.util.List;
public class Professeur {
    private int id_professeur;
    private int nci;
    private String nomComplet;
    private String grade;
    List<ProfesseurClasse> professeurClasses;
    public List<ProfesseurClasse> getProfesseurClasses() {
        return professeurClasses;
    }
    public void setProfesseurClasses(List<ProfesseurClasse> professeurClasses) {
        this.professeurClasses = professeurClasses;
    }

    private String email;

    List<Classe>classes;

    public Professeur() {
    }
    public int getNci() {
        return nci;
    }

    public void setNci(int nci) {
        this.nci = nci;
    }

   
    public int getId_professeur() {
        return id_professeur;
    }
    public void setId_professeur(int id_professeur) {
        this.id_professeur = id_professeur;
    }
  
    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }
}
