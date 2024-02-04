package monopoly;

import java.awt.*;

public class Pion {
    private int x;
    private int y;
    private Color couleur;

    private int diametre = 10;

    public Pion(int x, int y, Color couleur) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDiametre() {
        return diametre;
    }

    public Color getCouleur()
    {
        return this.couleur;
    }

    public void setCouleur(Color couleur)
    {
        this.couleur = couleur;
    }

    public void setDiametre(int diametre)
    {
        this.diametre = diametre;
    }


}