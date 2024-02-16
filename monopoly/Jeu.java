package monopoly;
import monopoly.cartes.Carte;
import monopoly.cartes.Paquet;
import monopoly.cartes.PaquetCaisseCommunaute;
import monopoly.cartes.PaquetChance;
import monopoly.cases.Case;
import monopoly.tools.Logger;

import java.util.*;

public class Jeu {
    public static Jeu instance;
    private ArrayList<Joueur> listeJoueur;
    private PaquetChance listeCarteChance;
    private PaquetCaisseCommunaute listeCarteCommunaute;
    private Plateau plateau;
    private int numeroJoueurActuel;

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

        this.listeCarteChance = new PaquetChance();
        this.listeCarteCommunaute = new PaquetCaisseCommunaute();

        this.listeJoueur = this.initialiserJoueur(joueur1, joueur2, joueur3, joueur4);
        this.plateau = new Plateau();
        this.plateau.initialiserPlateau();
        this.plateau.placerJoueurs(joueur1, joueur2, joueur3, joueur4, 0);

        Logger.printLog(joueur1.nomJoueur + ", " + joueur2.nomJoueur + ", " + joueur3.nomJoueur + ", " + joueur4.nomJoueur + " sont arrivés dans la partie");

        this.initPositionPion();

        // Initialisation premier tour
        this.numeroJoueurActuel = 0;
        this.plateau.getIHM().getPanelGauche().setJoueur(this.listeJoueur.get(numeroJoueurActuel));
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

    public void initPositionPion()
    {
        for(Joueur joueur : this.listeJoueur)
        {
            joueur.getPion().updatePositionPion(0);
        }
    }

    public void prochainTour()
    {
        this.numeroJoueurActuel = (this.numeroJoueurActuel + 1) % 4;
        this.plateau.getIHM().getPanelGauche().setJoueur(this.listeJoueur.get(numeroJoueurActuel));
        Logger.printLog("C'est au tour de : " + this.listeJoueur.get(numeroJoueurActuel).getNomJoueur() + " de jouer");
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public ArrayList<Joueur> getListeJoueur() {
        return listeJoueur;
    }

    public PaquetChance getListeCarteChance() { return this.listeCarteChance; }

    public PaquetCaisseCommunaute getListeCarteCommunaute() {
        return listeCarteCommunaute;
    }
}
