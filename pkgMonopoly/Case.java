package pkgMonopoly;

import java.util.ArrayList;

public abstract class Case {

    public int numeroCase;
    ArrayList<Joueur> listeJoueur;
    public String nomCase;
    public Joueur joueurProprietaire;

    public Case(int numeroCase, String nomCase) {
        this.listeJoueur = new ArrayList<>();
        this.numeroCase = numeroCase;
        this.nomCase = nomCase;
        this.joueurProprietaire = null;
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
