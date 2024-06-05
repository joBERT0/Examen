import java.util.Scanner;
import entities.Inscription;
import services.EtudiantService;
import services.ClasseService;
import services.InscriptionService;
public class AttacheView {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        EtudiantService etudiantService=new EtudiantService();
        ClasseService classeService=new ClasseService();
        InscriptionService inscriptionService= new InscriptionService();
        do {
            System.out.println("1-Faire une inscription ou une réinscription");
            System.out.println("2 Lister les étudiants inscrits dans une classe");
            System.out.println("3-Quitter");
             choix=sc.nextInt();
             sc.nextLine();
             switch (choix) {
                case 1:
                System.out.println("Entrer le matricule de l'etudiant");
                String matricule=sc.nextLine();
                Etudiant etudiant  =new Etudiant();
                etudiant= etudiantService.rechercheEtudiantParMatricule(matricule);
                if (etudiant==null) {
                    System.out.println("Etudiant n'existe pas.Veuillez l'inscrire");
                    System.out.println("Entrer le matricule de l'etudiant");
                    matricule=sc.nextLine();
                    System.out.println("Veuillez entrer le nom complet de l'etudiant");
                    String nomComplet=sc.nextLine();
                    System.out.println("Veuillez entrer le tuteur de l'etudiant");
                    String tuteur=sc.nextLine();
                    etudiant =new Etudiant();
                    etudiant.setMatricule(matricule);
                    etudiant.setNomComplet(nomComplet);
                    etudiant.setTuteur(tuteur);
                    etudiantService.ajouterEtudiant(etudiant);
                }else{
                    System.out.println("La matricule existe deja.Reinscrivez l'etudiant");
                }
                Inscription inscription=new Inscription();
                System.out.println("Veuillez choisir l'année");
                String anneeScolaire=sc.nextLine();
                System.out.println("Les classes sont les suivantes");
                List <Classe> classes= classeService.ListerClasse();
                for(Classe cl:classes){
                    System.out.println(cl.getId()+""+cl.getNiveau()+""+cl.getFiliere());
                }
                int idClasse=sc.nextInt();
                Classe classe=new Classe();
                classe=classeService.findClasseById(idClasse);
                inscription.setClasse(classe);
                inscription.setAnneeScolaire(anneeScolaire);
                inscription.setEtudiant(etudiant);
                inscriptionService.faireInscription(inscription);
                break;

                case 2:
                System.out.println("Saisir l'année d'inscription");
                anneeScolaire=sc.nextLine();
                List<Inscription> inscriptions=inscriptionService.listerInscriptionParAnnee(anneeScolaire);
                for (Inscription inscript : inscriptions) {
                    System.out.println("Matricule: "+inscript.getEtudiant().getMatricule()+"\n Nom complet : "+inscript.getEtudiant().getNomComplet()+"\n Tuteur : "+inscript.getEtudiant().getNomComplet());
                    
                }
                System.out.println("Voulez vous filtrez cette liste par classe oui/non");
                String reponse=sc.nextLine();
                if(reponse.equalsIgnoreCase("oui")){
                    System.out.println("les classes sont les suivantes :");
                    classes= classeService.ListerClasse();
                    for(Classe cl: classes){
                        System.out.println(cl.getId()+"-"+cl.getNiveau()+""+ cl.getFiliere());
                    }
                    idClasse=sc.nextInt();

                    inscriptions= inscriptionService.listerInscriptionParAnnee(anneeScolaire,idClasse);
                    for (Inscription inscript : inscriptions) {
                        System.out.println("Matricule: "+inscript.getEtudiant().getMatricule()+"\n Nom complet : "+inscript.getEtudiant().getNomComplet()+"\n Tuteur : "+inscript.getEtudiant().getNomComplet());
                        
                    }

                }
                break;
             
                default:
                    break;
             }

        } while (choix!=4);
    
    }
}
