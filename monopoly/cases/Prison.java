package monopoly.cases;
import monopoly.Carte;
import monopoly.Joueur;
import monopoly.Plateau;

import java.util.ArrayList;

public class Prison extends Case {

    public String nomCase;

    public Prison(int index, String nomCase, int coordX, int coordY) {
        super(index, nomCase, coordX, coordY);
    }

    @Override
    public void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
                       ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {

    }
}
