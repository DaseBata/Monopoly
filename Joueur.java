import java.util.*;
import java.util.Random;


public class Joueur {

    public boolean enPrison;
    public String nomJoueur;
    public int argentJoueur;
    public int caseActuelle;
    public boolean doubleDes;
    public int compteurDouble;


    public Joueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
        this.argentJoueur = 150 000;
        this.caseActuelle = 0;
        this.enPrison = false;
        this.doubleDes = false;
        this.compteurDouble = 0;
    }

    public void sinscrire(NomJoueur String ) {

    }

    public int lancerDes() {

        int random1 = random.nextInt(6) + 1;
        int random2 = random.nextInt(6) + 1;

        if(random1 == random2){
            this.doubleDes = true;
            this.compteurDouble = this.compteurDouble + 1;
        }

        return random1 + random2;
    }

    public void avancer(int casesAAvancer, ArrayList<Case> listeCase){

    }

    public void acheter(case Case, joueur Joueur) {
        // TODO implement here
    }


    public void payer(montant int, joueur Joueur) {
        // TODO implement here
    }


    public void allerPrison(joueur Joueur) {
        // TODO implement here
    }


    public void beneficieParc(joueur Joueur) {
        // TODO implement here
    }


    public void tirerChance(joueur Joueur) {
        // TODO implement here
    }


    public void toucherArgent(joueur Joueur) {
        // TODO implement here
    }

}
