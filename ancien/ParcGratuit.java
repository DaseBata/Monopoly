import java.util.ArrayList;

public class ParcGratuit extends Case {

    int montantParc;

    public ParcGratuit(int index) {
        super(index);
        montantParc = 0;
    }

    @Override
    public void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
            ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {
        joueur.argentJoueur = joueur.argentJoueur + montantParc;
        this.remiseAZero();
    }

    public void remiseAZero() {
        montantParc = 0;
    }

    public int getArgentParc() {
        return montantParc;
    }

    public void setArgentParc(int argent) {
        montantParc = montantParc + argent;
    }
}
