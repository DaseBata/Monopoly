package monopoly.cartes;

import monopoly.Joueur;
import monopoly.tools.Logger;

import java.util.ArrayList;

public abstract class Paquet {

    protected ArrayList<Carte> paquetCarte;

    public Paquet()
    {
        this.paquetCarte = new ArrayList<>();
        this.creerCarte();
    }

    public abstract void creerCarte();

    public void tirerCarte(Joueur joueur)
    {
        Carte carteTiree = this.paquetCarte.get(0);
        Logger.printLog(carteTiree.getDescription());

        carteTiree.setJoueur(joueur);
        carteTiree.declencherAction();
        carteTiree.unsetJoueur();
    }



}
