package monopoly.cartes;

public class CarteGain extends Carte {

    public int gainArgent;

    public CarteGain(String description, int gainArgent)
    {
        super(description);
        this.gainArgent = gainArgent;
    }

    @Override
    public void declencherAction()
    {
        this.joueur.ajouterArgent(this.gainArgent);
    }

}
