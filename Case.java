import java.util.ArrayList;

public abstract class Case {

    public int numeroCase;
    ArrayList<Joueur> listeJoueur;
    public String descriptifCase;
    public String nomCase;

    public Case(int numeroCase) {
        this.listeJoueur = new ArrayList<>();
        this.numeroCase = numeroCase;
    }

    public void ajouterJoueur(Joueur joueur){
        listeJoueur.add(joueur);
    }

    public void enleverJoueur(Joueur joueur){
        int i = 0;
        while (i<listeJoueur.size()){
            if(listeJoueur.get(i).equals(joueur)){
                listeJoueur.remove(i);
            }
            i++;
        }
    }

    public abstract void action(Joueur joueur, ArrayList<Case> plateau);

    /*
    public boolean contientJoueur(ArrayList<Joueur> listeJoueur, Joueur Joueur){

        int i = 0;
        while (i<listeJoueur.size()){
            if(listeJoueur.get(i).equals(Joueur)){
                return true;
            }
            i++;
        }
        return false;
    }
    */
}
