package pkgMonopoly;
import java.util.*;

public class Jeu {

    public static void main(String[] args) {

        boolean fin = false;
        int ordreDeJeu = 0;
        int casesAAvancer;
        Case caseATraiter;

        Joueur joueur1 = new Joueur("B");
        Joueur joueur2 = new Joueur("V");
        Joueur joueur3 = new Joueur("R");
        Joueur joueur4 = new Joueur("J");
        Joueur joueurActuel;
        ArrayList<Joueur> listeJoueur = new ArrayList<>();

        listeJoueur.add(joueur1);
        listeJoueur.add(joueur2);
        listeJoueur.add(joueur3);
        listeJoueur.add(joueur4);

        Plateau plateau = new Plateau();
        plateau.initialiserPlateau();
        plateau.initialiserJoueur(joueur1, joueur2, joueur3, joueur4);

        while (fin != true){
            joueurActuel = listeJoueur.get(ordreDeJeu);

            if(!plateau.getCase(joueurActuel.caseActuelle).nomCase.equals("Prison")){

                casesAAvancer = joueurActuel.lancerDes();
                joueurActuel.deplacer(casesAAvancer, plateau.listeCase);

                caseATraiter = plateau.getCase(joueurActuel.caseActuelle);

                caseATraiter.action(joueurActuel, plateau.listeCase);
            } else {

            }

            //Propriete
                //acheter ?
                //vendre ?
                //payer impot ?

            //Taxe
                //prelever

            //Chance
                //Tirer carte chance et faire son effet

            //Caisse communauté
                //Tirer carte communauté et faire son effet

            //Aller prison
                //aller en prison

            //Parc gratuit
                //recuperer argent
        }
    }

    public void inscription() {

    }

    public void fin() {

    }
}
