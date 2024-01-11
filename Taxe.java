public class Taxe extends Case {

    public int coutTaxe;

    public Taxe(int index, String nomCase, int prixCase){
        super(index);
        coutTaxe = prixCase;
    }
}
