import java.util.ArrayList;

public class Depart extends Case {

    public String nomCase;
    public int argentDePassage = 20000;

    public Depart(int index, String nomPropriete) {
        super(index);
        this.nomCase = nomPropriete;
    }

    public int getArgentPassage(){
        return this.argentDePassage;
    }

    @Override
    public void action(Joueur joueur, ArrayList<Case> plateau){
        System.out.println("Vous venez de passer par la case départ");
    }
}
