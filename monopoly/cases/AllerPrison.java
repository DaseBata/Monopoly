package monopoly.cases;

import monopoly.Jeu;
import monopoly.cartes.Carte;
import monopoly.Joueur;
import monopoly.Plateau;
import monopoly.tools.Logger;

import java.util.ArrayList;

public class AllerPrison extends Case {

    public AllerPrison(int index, String nomCase, int coordX, int coordY) {
        super(index, nomCase, coordX, coordY);
    }

    @Override
    public void action(Joueur joueur) {
        joueur.allerEnPrison();
        Jeu.getInstance().getPlateau().getPrison().setJoueurEnPrison(joueur);
        Logger.printLog(joueur.getNomJoueur() + " est allé en prison.");
    }
}
