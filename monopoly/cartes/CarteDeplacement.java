package monopoly.cartes;

import monopoly.Jeu;
import monopoly.tools.Logger;

public class CarteDeplacement extends Carte {
    private int numCase;

    public CarteDeplacement(String description, int numCase)
    {
        super(description);
        this.numCase = numCase;
    }

    @Override
    public void declencherAction()
    {
        int distance = this.joueur.getCaseActuelle().getNumeroCase() - this.numCase;

        if(distance > 0)
        {
            int taillePlateau = Jeu.getInstance().getPlateau().getListeCase().size(); // 40
            int distanceCaseDepart = taillePlateau - this.joueur.getCaseActuelle().getNumeroCase(); // 38
            int distanceAParcourir  = distanceCaseDepart + numCase;

            this.joueur.deplacer(distanceAParcourir);
        }
        if(distance < 0)
        {
            this.joueur.deplacer(distance * -1); // valeur absolue
        }
        if(distance == 0)
        {
            Logger.printLog(this.joueur.getNomJoueur() + ": est déjà sur cette case.");
        }


    }
}
