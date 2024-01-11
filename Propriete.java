import java.util.ArrayList;

public class Propriete extends Case {

    public int prixPropriete;
    public ArrayList<Batiment> maisonsHotels;
    public String nomPropriete;

    public Propriete(int index, String nomPropriete, int prixPropriete) {
        super(index);
        this.nomPropriete = nomPropriete;
        this.prixPropriete = prixPropriete;
    }
}
