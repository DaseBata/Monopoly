package monopoly.ihm.composants;

import monopoly.Jeu;
import monopoly.Joueur;
import monopoly.cases.Propriete;
import monopoly.tools.Logger;

import javax.swing.*;
import java.awt.*;

public class PanelActions extends JPanel {

    private Joueur joueur;
    private final JButton btnDes;
    private final JButton btnAchat;
    private final JButton btnFinTour;
    private final JButton btnPayerPrison;
    private final JButton btnTest, btnTest2, btnTest3;
    private final JLabel resultatDes;
    private final JLabel argentParcGratuit;

    public PanelActions()
    {
        super();
        this.setPreferredSize(new Dimension(270, 800));

        this.btnDes = new JButton("Lancer les dés");
        this.resultatDes = new JLabel("Résultat des dés : ");
        this.btnFinTour = new JButton("Finir mon tour");

        this.btnPayerPrison = new JButton("Sortir de prison (5000F)");

        this.btnAchat = new JButton("Acheter");
        this.argentParcGratuit = new JLabel("Parc gratuit : 0F" );

        this.btnTest = new JButton("Test 0F 1");
        this.btnTest2 = new JButton("Test 0F 2");
        this.btnTest3 = new JButton("Test 0F 3");


        this.btnDes.addActionListener(e -> this.lancerDes());
        this.btnAchat.addActionListener(e -> this.joueur.achatPropriete());
        this.btnFinTour.addActionListener(e -> this.finirTour());
        this.btnPayerPrison.addActionListener(e -> this.payerPrison());

        //this.btnTest.addActionListener(e-> this.joueur.piocherChance());
        this.btnTest.addActionListener(e->this.joueur.deduireArgent(150000));
        this.btnTest2.addActionListener(e->this.joueur.deduireArgent(150000));
        this.btnTest3.addActionListener(e->this.joueur.deduireArgent(150000));


        this.add(this.btnDes);
        this.add(this.resultatDes);

        this.add(this.btnAchat);
        this.add(this.btnPayerPrison);
        this.add(this.btnFinTour);

        this.add(this.btnTest);
        this.add(this.btnTest2);
        this.add(this.btnTest3);

        this.add(this.argentParcGratuit);


    }

    public void setJoueur(Joueur joueur)
    {
        this.joueur = joueur;
        Logger.printLog("------------------------------------------------------------------------");
        Logger.printLog("Au tour de : " + joueur.getNomJoueur());

        this.btnDes.setEnabled(!this.joueur.estEnPrison());
        this.btnPayerPrison.setEnabled(this.joueur.estEnPrison());

        this.resultatDes.setText("Résultat des dés : ");

        this.btnAchat.setEnabled(false);
        this.btnFinTour.setEnabled(this.joueur.estEnPrison()); // le joueur en prison peut décider de ne pas payer

    }

    public void lancerDes()
    {
        int resultatLancer = this.joueur.lancerDes();

        this.changerResultatDes(resultatLancer);
        this.btnDes.setEnabled(false);
        this.btnFinTour.setEnabled(true);

        // Si le joueur est sur une case propriete qui n'est pas déjà possédée
        if(this.joueur.getCaseActuelle() instanceof Propriete && ((Propriete)this.joueur.getCaseActuelle()).getJoueurProprietaire() == null)
        {
            this.btnAchat.setText("Acheter : " + this.joueur.getCaseActuelle().getNomCase() + "("+((Propriete) this.joueur.getCaseActuelle()).getPrixPropriete() + "$)");
        }

    }

    public void activerBoutonAchat(boolean estActif)
    {
        this.btnAchat.setEnabled(estActif);
    }

    public void finirTour()
    {
        Jeu.getInstance().prochainTour(); // joueur suivant
    }

    public void changerResultatDes(int resultatLancer)
    {
        this.resultatDes.setText("Resultat des dés : " + resultatLancer);
    }

    public void updateLabelParcGratuit()
    {
        this.argentParcGratuit.setText("Parc gratuit :" + Jeu.getInstance().getPlateau().getParcGratuit().getArgentParc() + "F");
    }

    public void payerPrison()
    {
        Logger.printLog(this.joueur.getNomJoueur() + " a payé 5000F pour sortir de prison au prochain tour.");
        this.joueur.deduireArgent(5000);
        this.joueur.libererDePrison();
        Jeu.getInstance().prochainTour(); // on passe au joueur suivant
    }


}
