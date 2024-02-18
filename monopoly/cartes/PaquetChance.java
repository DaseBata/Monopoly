package monopoly.cartes;

import monopoly.tools.Logger;

import java.util.Collections;

public class PaquetChance extends Paquet {

    public PaquetChance()
    {
        super();
    }

    public void creerCarte()
    {
        // Carte déplacement
        this.paquetCarte.add(new CarteDeplacement("Rendez-vous à l’Avenue Henri-Martin. Si vous passez par la case départ, recevez F20 000", 24));
        this.paquetCarte.add(new CarteDeplacement("Avancez au Boulevard de La Villette. Si vous passez par la case départ, recevez F20 000", 11));
        this.paquetCarte.add(new CarteDeplacement("Avancez jusqu’à la Gare de Lyon. Si vous passez par la case départ, recevez F20 000", 15));
        this.paquetCarte.add(new CarteDeplacement("Rendez-vous à la Rue de la Paix", 39));
        this.paquetCarte.add(new CarteDeplacement("Avancer jusqu’à la case départ", 0));


        //Carte gain d'argent
        this.paquetCarte.add(new CarteGain("Vous avez gagné le prix de mots croisés. Recevez F10 000", 10000));
        this.paquetCarte.add(new CarteGain("La banque vous verse un dividende de F5 000", 5000));
        this.paquetCarte.add(new CarteGain("Votre immeuble et votre prêt rapportent. Vous devez toucher F15 000", 15000));

        // Carte perte d'argent
        this.paquetCarte.add(new CartePerte("Amende pour ivresse F2 000", 2000));
        this.paquetCarte.add(new CartePerte("Amende pour excès de vitesse F1 500", 1500));
        this.paquetCarte.add(new CartePerte("Payez pour frais de scolarité F15 000", 15000));

        Collections.shuffle(this.paquetCarte);
    }


}
