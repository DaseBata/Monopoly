package monopoly.cases;

import monopoly.*;
import monopoly.cartes.Carte;

import java.util.ArrayList;

public class Gare extends Propriete {

    public Gare(int index, String nomGare, int prixGare, int coordX, int coordY) {
        super(index, nomGare, prixGare, coordX, coordY);
    }

    @Override
    public void action(Joueur joueur) {
        super.action(joueur);
    }

}
