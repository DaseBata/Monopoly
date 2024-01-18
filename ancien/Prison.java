import java.util.ArrayList;

public class Prison extends Case {

    public String nomCase;

    public Prison(int index, String nomCase) {
        super(index);
        this.nomCase = nomCase;
    }

    @Override
    public void action(Joueur joueur, Plateau plateau, ArrayList<Case> listeCase, ArrayList<Carte> carteChance,
            ArrayList<Carte> carteCommunaute, ArrayList<Joueur> listeJoueur) {

    }
}
