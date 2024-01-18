import java.util.ArrayList;

public class Carte {

    public String descriptionCarte;
    public String typeCarte;
    public int index;

    public Carte(String type, int index) {
        this.typeCarte = type;
        this.index = index;
    }

    public void action(String typeCarte, int index, ArrayList<Joueur> listeJoueur) {
        if (typeCarte.equals("chance")) {
            switch (index) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
            }
        } else {
            switch (index) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
            }
        }
    }
}