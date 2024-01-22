package pkgMonopoly;
import java.util.*;

public class Jeu {
    public static Jeu instance;
    private ArrayList<Joueur> listeJoueur;
    private Plateau plateau;

    // Singleton
    public static Jeu getInstance()
    {
        if(instance == null)
        {
            instance = new Jeu();
        }
        return instance;
    }
    public void initialiserJeu(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4)
    {

        this.listeJoueur = this.initialiserJoueur(joueur1, joueur2, joueur3, joueur4);
        this.plateau = new Plateau();
        this.plateau.initialiserPlateau();
        this.plateau.placerJoueurs(joueur1, joueur2, joueur3, joueur4, 0);
        this.plateau.getIHM().nouveauLog(joueur1.nomJoueur + ", " + joueur2.nomJoueur + ", " + joueur3.nomJoueur + ", " + joueur4.nomJoueur + " sont arrivés dans la partie");


        boolean fin = false;
        int ordreDeJeu = 0;
        int casesAAvancer;
        Case caseATraiter;
        int indexAllerPrison = 30;
        ArrayList<Carte> carteChance = this.initialiserCarteChance();
        ArrayList<Carte> carteCommunaute = this.initialiserCarteCommunaute();

        Joueur joueurGagnant = null;

        /*
        while (listeJoueur.size() > 1) { //Un joueur gagne
            Iterator<Joueur> iterator = listeJoueur.iterator();

            while (iterator.hasNext() && listeJoueur.size() > 1) {
                Joueur joueurActuel = iterator.next();

                if ((plateau.getCase(joueurActuel.caseActuelle).nomCase.equals("Prison"))
                        && (joueurActuel.enPrison == true)) { // Le joueur est en prison non visiteur
                    casesAAvancer = joueurActuel.lancerDes();
                    if (joueurActuel.doubleDes = true) { // en prison fait un double, sort
                        joueurActuel.enPrison = false;
                        joueurActuel.doubleDes = false;
                        joueurActuel.tourEnPrison = 0;
                    } else { // prend un tour de plus en prison
                        joueurActuel.tourEnPrison = joueurActuel.tourEnPrison + 1;
                    }

                    if (joueurActuel.tourEnPrison == 3) { // si 3 tours en prison, sort et paie une amende
                        joueurActuel.tourEnPrison = 0;
                        joueurActuel.enPrison = false;
                        joueurActuel.argentJoueur = joueurActuel.argentJoueur - 5000;
                        plateau.ajoutParc(5000);
                    }
                } else { // si le joueur n'est pas en prison
                    casesAAvancer = joueurActuel.lancerDes();

                    do{
                        if (joueurActuel.doubleDes == true){
                            joueurActuel.nbDoubleAffile = joueurActuel.nbDoubleAffile + 1;
                            if(joueurActuel.nbDoubleAffile == 3){
                                casesAAvancer = indexAllerPrison - joueurActuel.caseActuelle;
                                joueurActuel.nbDoubleAffile = 0;
                                joueurActuel.doubleDes = false;
                            }
                        }
                        joueurActuel.deplacer(casesAAvancer, plateau.getListeCase());
                        caseATraiter = plateau.getCase(joueurActuel.caseActuelle);
                        caseATraiter.action(joueurActuel, plateau, plateau.getListeCase(), carteChance, carteCommunaute, listeJoueur);

                    } while (joueurActuel.doubleDes == false);
                }

                if(joueurActuel.argentJoueur < 0){
                    iterator.remove();
                }

                if (listeJoueur.size() == 1) {
                    joueurGagnant = listeJoueur.get(0);
                }
            }
        }
        System.out.println("" + joueurGagnant.nomJoueur);
        */

    }

    public ArrayList<Joueur> initialiserJoueur(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4)
    {
        ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
        listeJoueur.add(joueur1);
        listeJoueur.add(joueur2);
        listeJoueur.add(joueur3);
        listeJoueur.add(joueur4);

        return listeJoueur;
    }
    public ArrayList<Carte> initialiserCarteChance() {

        ArrayList<Carte> listeCarteChance = new ArrayList<Carte>();

        Carte carte0 = new Carte("chance", 0);
        Carte carte1 = new Carte("chance", 1);
        Carte carte2 = new Carte("chance", 2);

        listeCarteChance.add(carte0);
        listeCarteChance.add(carte1);
        listeCarteChance.add(carte2);

        return listeCarteChance;
    }

    public ArrayList<Carte> initialiserCarteCommunaute() {

        ArrayList<Carte> listeCarteCommunaute = new ArrayList<Carte>();

        Carte carte0 = new Carte("communaute", 0);
        Carte carte1 = new Carte("communaute", 1);
        Carte carte2 = new Carte("communaute", 2);

        listeCarteCommunaute.add(carte0);
        listeCarteCommunaute.add(carte1);
        listeCarteCommunaute.add(carte2);

        return listeCarteCommunaute;
    }

}
