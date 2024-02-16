package monopoly.cases;

import monopoly.cartes.Carte;
import monopoly.Joueur;
import monopoly.Plateau;

import java.util.ArrayList;

public class AllerPrison extends Case {

    int indexCasePrison = 10;

    public AllerPrison(int index, String nomCase, int coordX, int coordY) {
        super(index, nomCase, coordX, coordY);
    }

    @Override
    public void action(Joueur joueur) {

    }
}
