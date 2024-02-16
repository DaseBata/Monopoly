package monopoly.cases;
import monopoly.cartes.Carte;
import monopoly.Joueur;
import monopoly.Plateau;

import java.util.ArrayList;

public class Depart extends Case {

    public String nomCase;
    public static int MONTANT_CASE_DEPART = 20000;

    public Depart(int index, String nomCase, int coordX, int coordY) {
        super(index, nomCase, coordX, coordY);
    }

    @Override
    public void action(Joueur joueur) {
        System.out.println("Vous venez de passer par la case départ, vous gagnez F20 000");
        joueur.ajouterArgent(MONTANT_CASE_DEPART);
    }
}
