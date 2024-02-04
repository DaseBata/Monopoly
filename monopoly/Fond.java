package monopoly;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

        for (Joueur joueur : Jeu.getInstance().getListeJoueur()) {
            g.setColor(joueur.getPion().getCouleur());
            Pion pionJoueur = joueur.getPion();
            pionJoueur.setX(Jeu.getInstance().getPlateau().getCase(joueur.caseActuelle).getCoordoneePlateauX());
            pionJoueur.setY(Jeu.getInstance().getPlateau().getCase(joueur.caseActuelle).getCoordoneePlateauY());
            g.fillOval(pionJoueur.getX(), pionJoueur.getY(), pionJoueur.getDiametre() * 2, pionJoueur.getDiametre() * 2);
        }
    }

    public void rafraichirPlateau()
    {
        this.repaint();
    }
}