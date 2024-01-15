import java.util.ArrayList;

public class Taxe extends Case {

    int coutTaxe;
    int indexCasePrison = 20;

    public Taxe(int index, String nomCase, int prixCase){
        super(index);
        coutTaxe = prixCase;
    }

    @Override
    public void action(Joueur joueur, ArrayList<Case> plateau) {

        plateau.get()
    }
}
