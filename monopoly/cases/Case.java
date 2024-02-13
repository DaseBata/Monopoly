package monopoly.cases;

import monopoly.cartes.Carte;
import monopoly.Joueur;
import monopoly.Plateau;

import java.util.ArrayList;

public abstract class Case {

    private int numeroCase;
    private ArrayList<Joueur> listeJoueur;
    public String nomCase;
    public Joueur joueurProprietaire;

    private int coordoneePlateauX;
    private int getCoordoneePlateauY;

    public Case(int numeroCase, String nomCase, int coordX, int coordY) {
        this.listeJoueur = new ArrayList<>();
        this.numeroCase = numeroCase;
        this.nomCase = nomCase;
        this.joueurProprietaire = null;
        this.coordoneePlateauX = coordX;
        this.getCoordoneePlateauY = coordY;
    }

    public void ajouterJoueur(Joueur joueur) {
        listeJoueur.add(joueur);
    }

    public void enleverJoueur(Joueur joueur) {
        int i = 0;
        while (i < listeJoueur.size()) {
            if (listeJoueur.get(i).equals(joueur)) {
                listeJoueur.remove(i);
            }
            i++;
        }
    }

    public int getCoordoneePlateauX()
    {
        return this.coordoneePlateauX;
    }

    public int getCoordoneePlateauY()
    {
        return this.getCoordoneePlateauY;
    }

    public String getNomCase() { return this.nomCase; }

    public ArrayList<Joueur> getListeJoueur()
    {
        return this.listeJoueur;
    }

    public Joueur getJoueurProprietaire() { return this.joueurProprietaire; }

    public int getNumeroCase() { return this.numeroCase; }


    public abstract void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
                                ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur);


    /*
     * public boolean contientJoueur(ArrayList<Joueur> listeJoueur, Joueur Joueur){
     *
     * int i = 0;
     * while (i<listeJoueur.size()){
     * if(listeJoueur.get(i).equals(Joueur)){
     * return true;
     * }
     * i++;
     * }
     * return false;
     * }
     */
}
