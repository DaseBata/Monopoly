public class Depart extends Case {

    public String nomCase;
    public int argentDePassage;

    public Depart(int index, String nomPropriete) {
        super(index);
        this.nomCase = nomPropriete;
        this.argentDePassage = 200;
    }
}
