package pkgMonopoly;
import java.util.ArrayList;

public class Depart extends Case {

    public String nomCase;
    public int argentDePassage = 20000;

    public Depart(int index, String nomPropriete) {
        super(index);
        this.nomCase = nomPropriete;
    }

    public int getArgentPassage() {
        return this.argentDePassage;
    }

    @Override
    public void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
            ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {
        System.out.println("Vous venez de passer par la case départ");
    }
}
