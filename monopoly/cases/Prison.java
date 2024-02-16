package monopoly.cases;
import monopoly.cartes.Carte;
import monopoly.Joueur;
import monopoly.Plateau;

import java.util.ArrayList;

public class Prison extends Case {

    public String nomCase;

    public Prison(int index, String nomCase, int coordX, int coordY) {
        super(index, nomCase, coordX, coordY);
    }

    @Override
    public void action(Joueur joueur) { }
}
