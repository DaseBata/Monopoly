package monopoly;
import monopoly.cartes.Carte;
import monopoly.cases.Case;
import monopoly.cases.Depart;
import monopoly.cases.Gare;
import monopoly.cases.Propriete;
import monopoly.tools.Logger;

import java.awt.*;
import java.util.*;

public class Joueur {

    public boolean enPrison;
    public String nomJoueur;
    public int argentJoueur;
    public int caseActuelle;
    public boolean doubleDes;
    public int compteurDouble;
    public int ancienneCase;
    public int tourEnPrison;
    private boolean estEnPrison;
    public Scanner scanner;
    public int nbDoubleAffile;
    public Pion pion;
    private ArrayList<Gare> garesPossedee;

    public Joueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
        this.argentJoueur = 150000;
        this.caseActuelle = 0;
        this.ancienneCase = this.caseActuelle;
        this.enPrison = false;
        this.doubleDes = false;
        this.compteurDouble = 0;
        this.tourEnPrison = 0;
        this.scanner = new Scanner(System.in);
        this.nbDoubleAffile = 0;
        this.pion = new Pion(0, 0, Color.RED);
        this.garesPossedee = new ArrayList<Gare>();

    }

    public int lancerDes()
    {

        Random random = new Random();

        int random1 = random.nextInt(6) + 1;
        int random2 = random.nextInt(6) + 1;

        int resultat = random1 + random2;
        if (random1 == random2) {
            this.doubleDes = true;
            this.compteurDouble = this.compteurDouble + 1;
        }


        Logger.printLog(this.getNomJoueur() + " a lancé les dés, résultat : " + resultat + " (" + random1 + " + " + random2 + ")");
        this.deplacer(resultat);

        return resultat;
    }

    public void deplacer(int casesAAvancer) {

        ArrayList<Case> listeCase = Jeu.getInstance().getPlateau().getListeCase();

        // regarde si la prochaine case passe devant le départ
        if ((this.caseActuelle + casesAAvancer) % listeCase.size() <= this.caseActuelle)
        {
            this.ajouterArgent(20000);
            Logger.printLog(this.getNomJoueur() + " est repassé par la case Départ et empoche 20 000$");
        }

        this.caseActuelle = (this.caseActuelle + casesAAvancer) % listeCase.size();

        listeCase.get(this.ancienneCase).enleverJoueur(this);
        listeCase.get(this.caseActuelle).ajouterJoueur(this);

        this.pion.updatePositionPion(caseActuelle);

        Jeu.getInstance().getPlateau().getIHM().getPanelDroite().rafraichirPlateau();
        Logger.printLog("Le joueur : " + this.getNomJoueur() + ", est arrivé sur la case : " + Jeu.getInstance().getPlateau().getCase(caseActuelle).getNomCase());

        this.getCaseActuelle().action(this);

        this.ancienneCase = caseActuelle;
    }

    public void achatPropriete()
    {
        if(this.argentJoueur - ((Propriete) this.getCaseActuelle()).getPrixPropriete() > 0) // assez d'argent ?
        {
            this.deduireArgent(((Propriete) this.getCaseActuelle()).getPrixPropriete());
            Logger.printLog(this.getNomJoueur() + " a acheté la propriété : " + this.getCaseActuelle().getNomCase() + " pour : " + ((Propriete) this.getCaseActuelle()).getPrixPropriete() + "$");

            ((Propriete) this.getCaseActuelle()).setJoueurProprietaire(this);

            Jeu.getInstance().getPlateau().getIHM().getPanelGauche().activerBoutonAchat(false);

            if(this.getCaseActuelle() instanceof Gare)
            {
                this.garesPossedee.add((Gare)this.getCaseActuelle()); // calcul
            }
        }
        else
        {
            Logger.printLog("Vous n'avez pas assez d'argent pour acheter cette propriété");
            Jeu.getInstance().getPlateau().getIHM().getPanelGauche().activerBoutonAchat(false);

        }

    }

    public void payerProprietaire()
    {
        int prixAPayer = 0;

        if(this.getCaseActuelle() instanceof Gare)
        {
            prixAPayer = ((Gare) this.getCaseActuelle()).getPrixPropriete() * ((Propriete)this.getCaseActuelle()).getJoueurProprietaire().getNbGares();
            Logger.printLog("Le propriétaire de cette Gare possède : " + ((Propriete)this.getCaseActuelle()).getJoueurProprietaire().getNbGares() + " gares");
        }
        else
        {
            Propriete caseActuelle = (Propriete) this.getCaseActuelle();
            prixAPayer = caseActuelle.getPrixPropriete();
        }
        this.deduireArgent(prixAPayer);
        ((Propriete)this.getCaseActuelle()).getJoueurProprietaire().ajouterArgent(prixAPayer);
    }


    public String getNomJoueur()
    {
        return this.nomJoueur;
    }

    public int getArgentJoueur()
    {
        return this.argentJoueur;
    }

    public void ajouterArgent(int somme)
    {
        this.argentJoueur = this.argentJoueur + somme;
        Jeu.getInstance().getPlateau().getIHM().getComposantArgentJoueur().updateLabels();
        Logger.printLog("Le joueur :" + this.getNomJoueur() + ", a reçu " + somme + "$");
    }

    public void deduireArgent(int sommeADeduire)
    {
        this.argentJoueur = this.argentJoueur - sommeADeduire;
        Jeu.getInstance().getPlateau().getIHM().getComposantArgentJoueur().updateLabels();
        Logger.printLog("Le joueur :" + this.getNomJoueur() + ", a perdu " + sommeADeduire + "$");
    }

    public void piocherChance()
    {
        Jeu.getInstance().getListeCarteChance().tirerCarte(this);
    }

    public void piocherCaisseCommunaute()
    {
        Jeu.getInstance().getListeCarteCommunaute().tirerCarte(this);
    }

    public Pion getPion()
    {
        return this.pion;
    }

    public Case getCaseActuelle()
    {
        return Jeu.getInstance().getPlateau().getCase(this.caseActuelle);
    }

    public void setCaseActuelle(int numCase) {
        this.caseActuelle = numCase;
        Jeu.getInstance().getPlateau().getIHM().getPanelDroite().rafraichirPlateau();
    }

    public int getNbGares()
    {
        return this.garesPossedee.size();
    }

    public boolean estEnPrison()
    {
        return this.estEnPrison;
    }

    public void allerEnPrison()
    {
        this.estEnPrison = true;
        this.tourEnPrison = 3;
        this.setCaseActuelle(30);
    }

    public void libererDePrison()
    {
        this.estEnPrison = false;
        this.tourEnPrison = 0;
    }

}
