import java.util.Scanner;
import entities.Classe;
import entities.Professeur;
import entities.ProfesseurClasse;
import services.ProfesseurService;
public class ResponsablePedagogiqueView {
    public static void main(String[] args) throws Exception {
       int choix;
       Scanner sc=new Scanner(System.in);
        ClasseService classeService =new ClassseService();
        ProfesseurService ProfesseurService =new ProfesseurService();
       do {
            System.out.println("1-Ajouter des classes");
            System.out.println("2-Lister des classes");
            System.out.println("3-Ajouter des professeurs et leur affecter des classes");
            System.out.println("4-Lister les professeurs");
            System.out.println("5-Filtrer les classes d'un professeur");
            System.out.println("6-Quitter");
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                    int choixNiv;
                    do {
                        System.out.println("Choisissez un niveau 1-L1; 2-L2; 3-L3) ");
                        choixNiv= sc.nextInt();
                    } while (choixNiv<1 || choixNiv>3);
                    Niveau niveau = Niveau.values()[choixNiv - 1];

                    int choixFil;
                    do {
                        System.out.println("Choisissez une filière 1-GLRS 2-IAGE 3-ETSE 4-TTL 5-MAIE;");
                        choixFil = sc.nextInt();
                    } while (choixFil<1 || choixFil>7);
                    Filiere filiere = Filiere.values()[choixFil - 1];

                    Classe classe= new Classe();
                    classe.setNiveau(niveau);
                    classe.setFiliere(filiere);
                    classeService.ajouterClasse(classe);
                        break;
                case 2:
                    System.out.println("Voici nos classes :");
                    List<Classe> classes= classeService.listerClasse();
                    for(Classe cl: classes){
                        System.out.println(cl.getNiveau()+ "" + cl.getFiliere());
                    
                    }
                    break;
                case 3:
                    Professeur professeur=new Professeur();
                    System.out.println("Veuillez entrer le nci");
                    professeur.setNci(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Veuillez entrer le nom Complet");
                    professeur.setNomComplet(sc.nextLine());
                    System.out.println("Veuillez entrer le Grade");
                    professeur.setGrade(sc.nextLine());
                        classes=ClasseService.listerClasse();
                        int response=2;
                        List<ProfesseurClasse> ListeClasseProf = new ArrayList<>();
                        do {
                            for(Classe cl: classes){
                                System.out.println(cl.getNiveau()+ "" + cl.getFiliere());
                            }
                            System.out.println("veuillez selectionner la classe à laquelle vous vous voulez affecetr un professeur");
                            int idClasse=sc.nextInt();
                            classe=classeService.findClasseById(idClasse);
                            if(classe!=null){
                                ProfesseurClasse professeurClasse=new ProfesseurClasse(classe);
                                professeurClasse.setProfesseur(professeur);
                                    int inside=0;
                                if(listerClasseProf.size()>0){
                                    for (ProfesseurClasse p: ListeClasseProf){
                                        if(p.getClasse().getId_classe()== classe.getId_classe()){
                                            inside = 1;
                                            System.out.println("Classe déjà donnée au professeur");
                                        }
                                    }
                                    if(inside==0){
                                        ListerClasseProf.add(professeurClasse);

                                    }else{
                                        ListeClasseProf.add(professeurClasse);
                                    }
                                }
                            }else{
                                System.out.println("Cet Id n'existe pas ");
                            }
                            System.out.println("Voulez-vous continuer 1-OUI 2-NON");
                            response=sc.nextInt();
                        } while (response==1);
                        if(professeur.getProfesseurClasses().size()<1){
                            System.out.println("le professeur doit avoir au moins une classe");
                        }else{
                            ProfesseurService.ajouterProfesseur(professeur);
                        }
                break;
                case 4:
                        System.out.println("Voici la liste des étudiants :");
                        List<Professeur> professeurs= professeurService.listerProfesseurs();
                        for (Professeur pc: professeurs){
                            System.out.println(pc.getGrade() +" :"+ pc.getNomComplet());
                        }
                break;
                default:
                    break;
            }
       } while (choix!=6);
    }
}
