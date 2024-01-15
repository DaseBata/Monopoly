package pkgMonopoly;
import java.util.ArrayList;

public class Prison extends Case{

    public String nomCase;

    public Prison(int index, String nomCase){
        super(index);
        this.nomCase = nomCase;
    }

    @Override
    public void action(Joueur joueur, ArrayList<Case> plateau) {

    }
}
