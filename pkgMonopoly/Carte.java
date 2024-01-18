package pkgMonopoly;
import java.util.ArrayList;

public class Carte {

    public String descriptionCarte;
    public String typeCarte;
    public int index;

    public Carte(String type, int index) {
        this.typeCarte = type;
        this.index = index;
    }

    public void action(Joueur joueur, String typeCarte, int index, ArrayList<Joueur> listeJoueur) {
        if (typeCarte.equals("chance")) {
            switch (index) {
                case 0:
                    joueur.argentJoueur = joueur.argentJoueur + 50000;
                    break;
                case 1:

                    break;
            }
        } else {
            switch (index) {
                case 0:
                    //Tous les joueurs perdes 20 000
                    for (int i = 0; i < listeJoueur.size(); i++) {
                        Joueur joueuraAtraiter = listeJoueur.get(i);
                        joueuraAtraiter.argentJoueur = joueuraAtraiter.argentJoueur - 20000;
                    }
                    break;
                case 1:

                    break;
            }
        }
    }
}
