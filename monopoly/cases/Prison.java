package monopoly.cases;
import monopoly.cartes.Carte;
import monopoly.Joueur;
import monopoly.Plateau;
import monopoly.tools.Logger;

import java.util.ArrayList;

public class Prison extends Case {

    private Joueur joueurEnPrison;

    public Prison(int index, String nomCase, int coordX, int coordY) {
        super(index, nomCase, coordX, coordY);
    }

    @Override
    public void action(Joueur joueur) {
        //Simple visite de prison ne se passe rien
    }

    public void setJoueurEnPrison(Joueur joueurEnPrison) {

        if(this.joueurEnPrison != null)
        {
            this.joueurEnPrison.libererDePrison();
            Logger.printLog(this.joueurEnPrison.getNomJoueur() + "a été libéré de prison.");
        }

        this.joueurEnPrison = joueurEnPrison;


    }
}
