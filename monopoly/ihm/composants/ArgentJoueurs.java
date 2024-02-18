package monopoly.ihm.composants;

import monopoly.Jeu;
import monopoly.Joueur;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ArgentJoueurs extends JPanel {

    private JLabel labelJoueur1;
    private JLabel labelJoueur2;
    private JLabel labelJoueur3;
    private JLabel labelJoueur4;


    public ArgentJoueurs()
    {
        super();
        this.setLayout(new GridLayout(1, 4));

        labelJoueur1 = new JLabel("");
        labelJoueur2 = new JLabel("");
        labelJoueur3 = new JLabel("");
        labelJoueur4 = new JLabel("");

        labelJoueur1.setBorder(new EmptyBorder(0, 20, 0, 20));
        labelJoueur1.setFont(new Font("Sergoe UI", 1, 20));

        labelJoueur2.setBorder(new EmptyBorder(0, 20, 0, 20));
        labelJoueur2.setFont(new Font("Sergoe UI", 1, 20));

        labelJoueur3.setBorder(new EmptyBorder(0, 20, 0, 20));
        labelJoueur3.setFont(new Font("Sergoe UI", 1, 20));

        labelJoueur4.setBorder(new EmptyBorder(0, 20, 0, 20));
        labelJoueur4.setFont(new Font("Sergoe UI", 1, 20));

        this.add(labelJoueur1);
        this.add(labelJoueur2);
        this.add(labelJoueur3);
        this.add(labelJoueur4);

        updateLabels();
    }

    /*
    Update de tous les labels
     */
    public void updateLabels()
    {
        ArrayList<Joueur> joueurs = Jeu.getInstance().getListeJoueur();
        Joueur joueur1 = joueurs.get(0);
        Joueur joueur2 = joueurs.get(1);
        Joueur joueur3 = joueurs.get(2);
        Joueur joueur4 = joueurs.get(3);

        labelJoueur1.setText(joueur1.getNomJoueur() + ": " + joueur1.getArgentJoueur() + "F");
        labelJoueur2.setText(joueur2.getNomJoueur() + ": " + joueur2.getArgentJoueur() + "F");
        labelJoueur3.setText(joueur3.getNomJoueur() + ": " + joueur3.getArgentJoueur() + "F");
        labelJoueur4.setText(joueur4.getNomJoueur() + ": " + joueur4.getArgentJoueur() + "F");
    }





}
