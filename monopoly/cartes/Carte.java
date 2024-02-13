package monopoly.cartes;
import monopoly.Joueur;

import java.util.ArrayList;

public abstract class Carte {

    protected String description;
    protected Joueur joueur;

    public Carte(String description) {
        this.description = description;
    }

    public abstract void declencherAction();

    public void setJoueur(Joueur joueur)
    {
        this.joueur = joueur;
    }

    public void unsetJoueur()
    {
        this.joueur = null;
    }

    public String getDescription() { return this.description; }



}
