import java.util.ArrayList;

public class AllerPrison extends Case{

    int indexCasePrison = 10;

    public AllerPrison(int index){
        super(index);
    }

    @Override
    public void action(Joueur joueur, ArrayList<Case> plateau){

        plateau.get(joueur.ancienneCase).enleverJoueur(joueur);

        joueur.caseActuelle = 10;
        joueur.ancienneCase = joueur.caseActuelle;

        plateau.get(joueur.caseActuelle).ajouterJoueur(joueur);
    }
}
