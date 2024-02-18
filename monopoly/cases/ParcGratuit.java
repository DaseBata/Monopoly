package monopoly.cases;
import monopoly.Jeu;
import monopoly.cartes.Carte;
import monopoly.Joueur;
import monopoly.Plateau;
import monopoly.tools.Logger;

import java.util.ArrayList;

public class ParcGratuit extends Case {
    private int montantParc;

    public ParcGratuit(int index, String nomCase, int coordX, int coordY) {
        super(index, nomCase, coordX, coordY);
        montantParc = 0;
    }

    @Override
    public void action(Joueur joueur) {
        Logger.printLog("Bravo, vous êtes arrivé sur le parc gratuit.");
        joueur.ajouterArgent(this.montantParc);
        this.remiseAZero();
    }

    public void remiseAZero() {
        this.montantParc = 0;
        Jeu.getInstance().getPlateau().getIHM().getPanelGauche().updateLabelParcGratuit();
    }

    public int getArgentParc() {
        return this.montantParc;
    }

    public void setArgentParc(int somme) {
        montantParc = montantParc + somme;
        Jeu.getInstance().getPlateau().getIHM().getPanelGauche().updateLabelParcGratuit();
    }

}
