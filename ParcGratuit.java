import java.util.ArrayList;

public class ParcGratuit extends Case{

    int montantParc;

    public ParcGratuit(int index){
        super(index);
        montantParc = 0;
    }

    @Override
    public void action(Joueur joueur, ArrayList<Case> plateau) {
        joueur.argentJoueur = joueur.argentJoueur + montantParc;
        this.remiseAZero();
    }

    public void remiseAZero(){
        montantParc = 0;
    }

    public int getArgentParc(){
        return montantParc;
    }

    public void setArgentParc(int argent){
        montantParc = montantParc + argent;
    }
}
