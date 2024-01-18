import java.util.*;

public class Joueur {

    public boolean enPrison;
    public String nomJoueur;
    public int argentJoueur;
    public int caseActuelle;
    public boolean doubleDes;
    public int compteurDouble;
    public int ancienneCase;
    public int tourEnPrison;
    public Scanner scanner;

    public Joueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
        this.argentJoueur = 150000;
        this.caseActuelle = 0;
        this.ancienneCase = this.caseActuelle;
        this.enPrison = false;
        this.doubleDes = false;
        this.compteurDouble = 0;
        this.tourEnPrison = 0;
        this.scanner = new Scanner(System.in);
    }

    public void sinscrire(String nomJoueur) {

    }

    public int lancerDes() {

        Random random = new Random();

        int random1 = random.nextInt(6) + 1;
        int random2 = random.nextInt(6) + 1;

        if (random1 == random2) {
            this.doubleDes = true;
            this.compteurDouble = this.compteurDouble + 1;
        }

        return random1 + random2;
    }

    public void deplacer(int casesAAvancer, ArrayList<Case> listeCase) {

        // regarde si la prochaine case passe devant le départ
        if ((this.caseActuelle + casesAAvancer) % listeCase.size() <= this.caseActuelle) {
            // si oui on fait un "nouveau" depart et on gagne de l'argent
            Depart passageDepart = new Depart(0, "Depart");
            passageDepart.getArgentPassage();
        }

        this.caseActuelle = (this.caseActuelle + casesAAvancer) % listeCase.size();

        listeCase.get(this.ancienneCase).enleverJoueur(this);
        listeCase.get(this.caseActuelle).ajouterJoueur(this);

        this.ancienneCase = caseActuelle;
    }

    public void acheter(Propriete emplacement, ArrayList<Joueur> listeJoueur) {
        // acheter ?
        System.out.print("Voulez-vous acheter la propriété? (oui/non): ");
        String choix = this.scanner.nextLine();
        if (choix.equals("oui")) {
            if (this.argentJoueur >= emplacement.prixPropriete) {
                emplacement.joueurProprietaire = this;
                this.argentJoueur = this.argentJoueur - emplacement.prixPropriete;
            }
        } else {
            proposerAchat(listeJoueur, this, emplacement);
        }
    }

    public void proposerAchat(ArrayList<Joueur> listeJoueur, Joueur joueur, Propriete emplacement) { // proposer l'achat
                                                                                                     // aux autres
                                                                                                     // joueurs en cas
                                                                                                     // de refus d'achat
                                                                                                     // du premier
        Joueur joueurAcheteur;
        for (int i = 0; i < listeJoueur.size(); i++) {
            joueurAcheteur = listeJoueur.get(i);
            if (emplacement.joueurProprietaire == null) {
                if (!joueurAcheteur.equals(joueur)) {
                    System.out.print(joueurAcheteur.nomJoueur + ", voulez-vous acheter la propriété? (oui/non): ");
                    String choix = this.scanner.nextLine();
                    if (choix.equals("oui")) {
                        if (joueur.argentJoueur >= emplacement.prixPropriete) {
                            emplacement.joueurProprietaire = joueur;
                            joueur.argentJoueur = joueur.argentJoueur - emplacement.prixPropriete;
                        }
                    }
                }
            }
        }
    }

    public void vendre(Propriete emplacement) {

        System.out.print("Voulez-vous vendre votre propriété? (oui/non): ");
        String choix = this.scanner.nextLine();
        if (choix.equals("oui")) {
            emplacement.joueurProprietaire = null;
            this.argentJoueur = this.argentJoueur + emplacement.prixPropriete; // revoir l'opération avec les maisons
        }
    }

    public void paieTaxe(Propriete emplacement) {
        this.argentJoueur = this.argentJoueur - emplacement.prixPropriete; // revoir l'opération avec les maisons
    }

    public void tirerCarteChance(ArrayList<Carte> carteChance, ArrayList<Joueur> listeJoueur) {
        Random random = new Random();
        int random1 = random.nextInt(2) + 0;

        Carte carte = carteChance.get(random1);
        carte.action(carte.typeCarte, carte.index, listeJoueur);
    }

    public void tirerCarteCommunaute(ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {
        Random random = new Random();
        int random1 = random.nextInt(2) + 0;

        Carte carte = carteCommunaute.get(random1);
        carte.action(carte.typeCarte, carte.index, listeJoueur);
    }
}
