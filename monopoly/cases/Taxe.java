package monopoly.cases;
import monopoly.Jeu;
import monopoly.cartes.Carte;
import monopoly.Joueur;
import monopoly.Plateau;

import java.util.ArrayList;

public class Taxe extends Case {

    int coutTaxe;

    public Taxe(int index, String nomCase, int prixCase, int coordX, int coordY) {
        super(index, nomCase, coordX, coordY);
        coutTaxe = prixCase;
    }

    @Override
    public void action(Joueur joueur) {
        joueur.argentJoueur = joueur.argentJoueur - coutTaxe;
        Jeu.getInstance().getPlateau().ajoutParc(coutTaxe);
    }
}
