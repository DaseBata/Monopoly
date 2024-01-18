package pkgMonopoly;
import java.util.ArrayList;

public class Communaute extends Case {

    public Communaute(int index) {
        super(index);
    }

    @Override
    public void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
            ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {
        joueur.tirerCarteCommunaute(carteChance, listeJoueur);
    }
}
