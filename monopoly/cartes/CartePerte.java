package monopoly.cartes;

public class CartePerte extends Carte {

    private int sommeAPerdre;
    public CartePerte(String description, int sommeAPerdre)
    {
        super(description);
        this.sommeAPerdre = sommeAPerdre;
    }

    @Override
    public void declencherAction() {
        this.joueur.deduireArgent(this.sommeAPerdre);
        this.unsetJoueur();
    }
}
