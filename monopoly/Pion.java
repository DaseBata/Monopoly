package monopoly;

import monopoly.cases.Case;

import java.awt.*;
import java.util.ArrayList;

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

    public ArrayList<Integer> updatePositionPion(int numeroCase)
    {
        Case caseActuelleJoueur = Jeu.getInstance().getPlateau().getCase(numeroCase);


        // si meme case liste joueur > x changer position
        if(caseActuelleJoueur.getListeJoueur().size() == 2)
        {
            System.out.println("2 joueurs");
            this.setX(caseActuelleJoueur.getCoordoneePlateauX()-15);
            this.setY(caseActuelleJoueur.getCoordoneePlateauY());
        }
        else if(caseActuelleJoueur.getListeJoueur().size() == 3)
        {
            System.out.println("3 joueurs");
            this.setX(caseActuelleJoueur.getCoordoneePlateauX());
            this.setY(caseActuelleJoueur.getCoordoneePlateauY()+15);
        }
        else if(caseActuelleJoueur.getListeJoueur().size() == 4)
        {
            System.out.println("4 joueurs");
            this.setX(caseActuelleJoueur.getCoordoneePlateauX()-15);
            this.setY(caseActuelleJoueur.getCoordoneePlateauY()+15);
        }
        else {
            System.out.println("aucun autre joueur sur la case");
            this.setX(caseActuelleJoueur.getCoordoneePlateauX());
            this.setY(caseActuelleJoueur.getCoordoneePlateauY());
        }


        ArrayList<Integer> nouvellesPositions = new ArrayList<>();
        nouvellesPositions.add(this.getX());
        nouvellesPositions.add(this.getY());

        System.out.println("Joueur " + nouvellesPositions + " " + nouvellesPositions);

        return nouvellesPositions;
    }



}