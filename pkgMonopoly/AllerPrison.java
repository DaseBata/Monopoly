package pkgMonopoly;

import java.util.ArrayList;

public class AllerPrison extends Case {

    int indexCasePrison = 10;

    public AllerPrison(int index, String nomCase) {
        super(index, nomCase);
    }

    @Override
    public void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
            ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {

        listeCase.get(joueur.ancienneCase).enleverJoueur(joueur);

        joueur.caseActuelle = 10;
        joueur.ancienneCase = joueur.caseActuelle;

        listeCase.get(joueur.caseActuelle).ajouterJoueur(joueur);

        joueur.enPrison = true;
    }
}
