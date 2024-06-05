package entities;

public class Inscription {
    private int id;
    private String AnneScolaire;
    private Etudiant etudiant;
    private Classe classe;
    
    public Inscription() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnneScolaire() {
        return AnneScolaire;
    }

    public void setAnneScolaire(String anneScolaire) {
        AnneScolaire = anneScolaire;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
