package monopoly.cartes;

import java.util.Collections;

public class PaquetCaisseCommunaute extends Paquet {

    public PaquetCaisseCommunaute()
    {
        super();
    }

    public void creerCarte()
    {
        // Carte déplacement
        this.paquetCarte.add(new CarteDeplacement("Placez-vous sur la case départ", 0));
        this.paquetCarte.add(new CarteDeplacement("Retournez à Boul. de Belleville", 1));


        //Carte gain d'argent
        this.paquetCarte.add(new CarteGain("Erreur de la banque en votre faveur. Recevez F20 000", 20000));
        this.paquetCarte.add(new CarteGain("La vente de votre stock vous rapporte F5 000", 5000));
        this.paquetCarte.add(new CarteGain("Recevez votre revenu annuel F10 000", 10000));
        this.paquetCarte.add(new CarteGain("Les contributions vous remboursent la somme de F2 000", 2000));
        this.paquetCarte.add(new CarteGain("Recevez votre intérêt sur l’emprunt à 7% F2 500", 2500));
        this.paquetCarte.add(new CarteGain("Vous avez gagné le deuxième Prix de Beauté. Recevez F1 000", 1000));
        this.paquetCarte.add(new CarteGain("Vous héritez F10 000", 10000));

        // Carte perte d'argent
        this.paquetCarte.add(new CartePerte("Payez la note du médecin F5 000", 5000));
        this.paquetCarte.add(new CartePerte("Payez votre Police d’Assurance F5 000", 5000));
        this.paquetCarte.add(new CartePerte("Payez une amende de F1 000", 1000));

        Collections.shuffle(this.paquetCarte);

    }


}
