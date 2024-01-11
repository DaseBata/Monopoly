
import java.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class Case {

    public int numeroCase;
    ArrayList<Joueur> listeJoueur;
    public String descriptifCase;
    public String nomCase;


    public Case(int numeroCase) {
        listeJoueur = new ArrayList<>();
        numeroCase = numeroCase;
    }

    public boolean contientJoueur(ArrayList<joueur> listeJoueur, Joueur Joueur){

        i = 0;
        while (i<listeJoueur.length()){
            if(listeJoueur.get(i).equals(joueur)){
                return true;
            }
            i++;
        }
        return false;
    }
}
