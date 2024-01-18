package pkgMonopoly;
import java.util.ArrayList;

public class Propriete extends Case {

    public int prixPropriete;
    public ArrayList<Batiment> maisonsHotels;
    public String nomPropriete;
    public Joueur joueurProprietaire;

    public Propriete(int index, String nomPropriete, int prixPropriete) {
        super(index, nomPropriete);
        this.prixPropriete = prixPropriete;
    }

    @Override
    public void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
            ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {

        int nbPropriete = 1;
        if (joueurProprietaire == null) { // propriété à personne
            joueur.acheter(this, (Case)this, listeJoueur);
        } else if (joueurProprietaire.equals(joueur)) { // propriété appartient au joueur
            // vendre ?
            joueur.vendre(this, (Case)this, nbPropriete);
        } else { // joueur doit payer la taxe de passage
            joueur.paieTaxe(this, nbPropriete);
        }
    }
}
