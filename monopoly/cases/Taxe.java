package monopoly.cases;
import monopoly.Jeu;
import monopoly.cartes.Carte;
import monopoly.Joueur;
import monopoly.Plateau;
import monopoly.tools.Logger;

import java.util.ArrayList;

public class Taxe extends Case {

    private int coutTaxe;

    public Taxe(int index, String nomCase, int prixTaxe, int coordX, int coordY) {
        super(index, nomCase, coordX, coordY);
        this.coutTaxe = prixTaxe;
    }

    @Override
    public void action(Joueur joueur) {
        Logger.printLog("Vous devez payer la taxe : " + this.getNomCase() + " s'élevant à " + this.coutTaxe);
        joueur.deduireArgent(this.coutTaxe);
        Jeu.getInstance().getPlateau().ajoutParc(coutTaxe);
    }
}
