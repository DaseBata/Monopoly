public class Depart extends Case {

    public String nomCase;
    public int argentDePassage = 200;

    public Depart(int index, String nomPropriete) {
        super(index);
        this.nomCase = nomPropriete;
    }

    public int getArgentPassage(){
        return this.argentDePassage;
    }
}
