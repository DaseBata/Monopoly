package pkgMonopoly;

import java.util.ArrayList;

public class Gare extends Propriete{

    public String nomGare;
    public int prixGare;
    public Joueur joueurProprietaire;

    public Gare(int index, String nomGare, int prixGare) {
        super(index, nomGare, prixGare);
    }

    @Override
    public void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
            ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {

        int nbGare = joueur.getNbGareJoueur(joueur, listeCase);
        if (joueurProprietaire == null) { // propriété à personne
            joueur.acheter(this,(Case)this, listeJoueur);
        } else if (joueurProprietaire.equals(joueur)) { // propriété appartient au joueur
            // vendre ?

            joueur.vendre(this, (Case)this, nbGare);
        } else { // joueur doit payer la taxe de passage
            joueur.paieTaxe(this, nbGare);
        }
    }

}