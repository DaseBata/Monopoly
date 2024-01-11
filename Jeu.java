import java.util.*;


public class Jeu {


    public static void main(String[] args) {
        démarrer();
    }


    public void demarrer() {

        boolean fin = false;
        int ordreDeJeu = 0;
        int casesAAvancer;

        Joueur joueur1 = new Joueur("B");
        Joueur joueur2 = new Joueur("V");
        Joueur joueur3 = new Joueur("R");
        Joueur joueur4 = new Joueur("J");
        Joueur joueurActuel;

        listeJoueur.add(joueur1);
        listeJoueur.add(joueur2);
        listeJoueur.add(joueur3);
        listeJoueur.add(joueur4);

        Plateau plateau = new Plateau();
        plateau.initialiserPlateau();
        plateau.initialiserJoueur(joueur1, joueur2, joueur3, joueur4);

        while (fin != true){
            joueurActuel = listeJoueur.get(ordreDeJeu);

            casesAAvancer = joueurActuel.lancerDes();
            joueurActuel.deplacer(casesAAvancer, plateau.listeCase);
        }
    }


    public void inscription() {
        // TODO implement here
    }


    public void fin() {
        // TODO implement here
    }

}
