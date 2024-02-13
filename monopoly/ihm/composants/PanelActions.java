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

    private final JButton btnTest;

    private JLabel resultatDes;

    public PanelActions()
    {
        super();
        this.setPreferredSize(new Dimension(270, 800));

        this.btnDes = new JButton("Lancer les dés");
        this.resultatDes = new JLabel("Résultat des dés : ");
        this.btnFinTour = new JButton("Finir mon tour");


        this.btnAchat = new JButton("Acheter");

        this.btnTest = new JButton("test chance");


        this.btnDes.addActionListener(e -> this.lancerDes());
        this.btnAchat.addActionListener(e -> this.joueur.achatPropriete());
        this.btnFinTour.addActionListener(e -> this.finirTour());
        this.btnTest.addActionListener(e-> this.joueur.piocherChance());

        this.add(this.btnDes);
        this.add(this.resultatDes);

        this.add(this.btnAchat);
        this.add(this.btnFinTour);

        this.add(this.btnTest);


    }

    public void setJoueur(Joueur joueur)
    {
        this.joueur = joueur;
        Logger.printLog("------------------------------------------------------------------------");
        Logger.printLog("Au tour de : " + joueur.getNomJoueur());

        this.btnDes.setEnabled(true);
        this.resultatDes.setText("Résultat des dés : ");

        this.btnAchat.setEnabled(false);
        this.btnFinTour.setEnabled(false);

    }

    public void lancerDes()
    {
        int resultatLancer = this.joueur.lancerDes();

        this.changerResultatDes(resultatLancer);
        this.btnDes.setEnabled(false);
        this.btnFinTour.setEnabled(true);

        // Si le joueur est sur une case propriete qui n'est pas déjà possédée
        if(this.joueur.getCaseActuelle() instanceof Propriete && this.joueur.getCaseActuelle().getJoueurProprietaire() == null)
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


}
