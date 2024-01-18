import java.util.ArrayList;

public class Propriete extends Case {

    public int prixPropriete;
    public ArrayList<Batiment> maisonsHotels;
    public String nomPropriete;
    public Joueur joueurProprietaire;

    public Propriete(int index, String nomPropriete, int prixPropriete) {
        super(index);
        this.nomPropriete = nomPropriete;
        this.prixPropriete = prixPropriete;
    }

    @Override
    public void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
            ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {
        if (joueurProprietaire == null) { // propriété à personne
            joueur.acheter(this, listeJoueur);
        } else if (joueurProprietaire.equals(joueur)) { // propriété appartient au joueur
            // vendre ?
            joueur.vendre(this);
        } else { // joueur doit payer la taxe de passage
            joueur.paieTaxe(this);
        }
    }
}
