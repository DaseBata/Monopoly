package pkgMonopoly;
import java.util.ArrayList;

public class Chance extends Case {

    public Chance(int index, String nomCase) {
        super(index, nomCase);
    }

    @Override
    public void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
            ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {
        joueur.tirerCarteChance(carteChance, listeJoueur);
    }
}
