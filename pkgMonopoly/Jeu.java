package pkgMonopoly;
import java.util.*;

public class Jeu {

    ArrayList<Joueur> listeJoueur;

    public Jeu(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4)
    {

        this.listeJoueur = new ArrayList<Joueur>();
        this.listeJoueur.add(joueur1);
        this.listeJoueur.add(joueur2);
        this.listeJoueur.add(joueur3);
        this.listeJoueur.add(joueur4);

    }
    public static void main(String[] args) {

        int casesAAvancer;
        Case caseATraiter;
        int indexAllerPrison = 30;

        Joueur joueur1 = new Joueur("B");
        Joueur joueur2 = new Joueur("V");
        Joueur joueur3 = new Joueur("R");
        Joueur joueur4 = new Joueur("J");
        ArrayList<Joueur> listeJoueur = new ArrayList<>();

        ArrayList<Carte> carteChance = initialiserCarteChance();
        ArrayList<Carte> carteCommunaute = initialiserCarteCommunaute();

        listeJoueur.add(joueur1);
        listeJoueur.add(joueur2);
        listeJoueur.add(joueur3);
        listeJoueur.add(joueur4);

        Plateau plateau = new Plateau();
        plateau.initialiserPlateau();
        plateau.initialiserJoueur(joueur1, joueur2, joueur3, joueur4);

        Joueur joueurGagnant = null;

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
                        joueurActuel.deplacer(casesAAvancer, plateau.listeCase);
                        caseATraiter = plateau.getCase(joueurActuel.caseActuelle);
                        caseATraiter.action(joueurActuel, plateau, plateau.listeCase, carteChance, carteCommunaute, listeJoueur);

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
    }

    // FAIT :
    // Propriete
    // acheter ?
    // vendre ?
    // payer impot ?
    // gares + augmentation prix taxe
    // Défaite + fin du jeu


    // A FAIRE :

    // Tirer carte chance et faire son effet (créer les cartes)
    // Tirer carte communauté et faire son effet (créer les cartes)
    // Maisons liste ? Attribut de propriété
    // Hotels

    public static ArrayList<Carte> initialiserCarteChance() {

        ArrayList<Carte> listeCarteChance = new ArrayList<Carte>();

        Carte carte0 = new Carte("chance", 0);
        Carte carte1 = new Carte("chance", 1);
        Carte carte2 = new Carte("chance", 2);

        listeCarteChance.add(carte0);
        listeCarteChance.add(carte1);
        listeCarteChance.add(carte2);

        return listeCarteChance;
    }

    public static ArrayList<Carte> initialiserCarteCommunaute() {

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
