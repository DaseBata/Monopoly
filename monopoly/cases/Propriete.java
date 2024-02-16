package monopoly.cases;
import monopoly.Jeu;
import monopoly.cartes.Carte;
import monopoly.Joueur;
import monopoly.Plateau;
import monopoly.tools.Logger;

import java.util.ArrayList;

public class Propriete extends Case {

    public int prixPropriete;
    public Joueur joueurProprietaire;

    public Propriete(int index, String nomPropriete, int prixPropriete, int coordX, int coordY) {
        super(index, nomPropriete, coordX, coordY);
        this.prixPropriete = prixPropriete;
    }

    public int getPrixPropriete() {
        return this.prixPropriete;
    }

    @Override
    public void action(Joueur joueur) {
        if(this.joueurProprietaire == null)
        {
            Logger.printLog("Cette propriété n'appartient à aucun joueur, vous pouvez l'acheter.");
            Jeu.getInstance().getPlateau().getIHM().getPanelGauche().activerBoutonAchat(true); // On peut acheter
            return;
        }
        if(this.joueurProprietaire == joueur)
        {
            Logger.printLog("Vous possédez déjà cette propriété.");
            Jeu.getInstance().getPlateau().getIHM().getPanelGauche().activerBoutonAchat(false);
        }
        else
        {
            Logger.printLog("Cette propriété appartient déjà au joueur : " + this.getJoueurProprietaire().getNomJoueur());
            joueur.payerProprietaire();
        }
    }

    public void setJoueurProprietaire(Joueur joueur) { this.joueurProprietaire = joueur; }

}
