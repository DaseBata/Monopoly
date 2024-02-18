package monopoly.ihm.composants;

import monopoly.Jeu;
import monopoly.Joueur;
import monopoly.Pion;
import monopoly.cases.Case;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Fond extends JPanel {

    private Image imageDeFond;
    private ArrayList<Pion> pions;

    public Fond(String cheminImage) {
        this.imageDeFond = new ImageIcon(cheminImage).getImage();
        this.pions = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageDeFond, 0, 0, getWidth(), getHeight(), this);

        for(Joueur joueur: Jeu.getInstance().getListeJoueur())
        {
            Pion pion = joueur.getPion();
            g.setColor(pion.getCouleur());
            g.fillOval(pion.getX(), pion.getY(), 20, 20);

        }
    }

    public void rafraichirPlateau()
    {
        this.repaint();
    }
}