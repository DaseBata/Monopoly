package monopoly.cases;
import monopoly.cartes.Carte;
import monopoly.Joueur;
import monopoly.Plateau;

import java.util.ArrayList;

public class Communaute extends Case {

    public Communaute(int index, String nomCase, int coordX, int coordY) {
        super(index, nomCase, coordX, coordY);
    }

    @Override
    public void action(Joueur joueur) {
        joueur.piocherCaisseCommunaute();
    }
}