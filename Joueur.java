import java.util.*;

public class Joueur {

    public boolean enPrison;
    public String nomJoueur;
    public int argentJoueur;
    public int caseActuelle;
    public boolean doubleDes;
    public int compteurDouble;
    public int ancienneCase;

    public Joueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
        this.argentJoueur = 150000;
        this.caseActuelle = 0;
        this.ancienneCase = this.caseActuelle;
        this.enPrison = false;
        this.doubleDes = false;
        this.compteurDouble = 0;
    }

    public void sinscrire(String nomJoueur) {

    }

    public int lancerDes() {

        Random random = new Random();

        int random1 = random.nextInt(6) + 1;
        int random2 = random.nextInt(6) + 1;

        if(random1 == random2){
            this.doubleDes = true;
            this.compteurDouble = this.compteurDouble + 1;
        }

        return random1 + random2;
    }

    public void deplacer(int casesAAvancer, ArrayList<Case> listeCase){

        if(this.caseActuelle + casesAAvancer >= listeCase.get(0).numeroCase){
            this.argentJoueur = listeCase.get(0).getArgentPassage();
        }

        this.caseActuelle = (this.caseActuelle + casesAAvancer) % listeCase.size();

        listeCase.get(this.ancienneCase).enleverJoueur(this);
        listeCase.get(this.caseActuelle).ajouterJoueur(this);
    }

    public void avancer(int casesAAvancer, ArrayList<Case> listeCase){

    }

    public void acheter(Case emplacement, Joueur Joueur) {

    }


    public void payer(int montant, Joueur Joueur) {

    }


    public void allerPrison(Joueur joueur) {

    }


    public void beneficieParc(Joueur joueur) {

    }


    public void tirerChance(Joueur joueur) {

    }


    public void toucherArgent(Joueur joueur) {

    }

}
