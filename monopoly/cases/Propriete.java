package monopoly.cases;
import monopoly.Carte;
import monopoly.Joueur;
import monopoly.Plateau;

import java.util.ArrayList;

public class Propriete extends Case {

    public int prixPropriete;
    public String nomPropriete;
    public Joueur joueurProprietaire;

    public Propriete(int index, String nomPropriete, int prixPropriete, int coordX, int coordY) {
        super(index, nomPropriete, coordX, coordY);
        this.prixPropriete = prixPropriete;
    }

    public int getPrixPropriete() {
        return this.prixPropriete;
    }

    @Override
    public void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
                       ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {

        int nbPropriete = 1;
        if (joueurProprietaire == null) { // propriété à personne
            joueur.acheter(this, (Case)this, listeJoueur);
        } else if (joueurProprietaire.equals(joueur)) { // propriété appartient au joueur
            // vendre ?
            joueur.vendre(this, (Case)this);
        } else { // joueur doit payer la taxe de passage
            joueur.paieTaxe(this, nbPropriete);
        }
    }
}
