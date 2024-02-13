package monopoly;
import monopoly.cartes.Carte;
import monopoly.cases.Case;
import monopoly.cases.Depart;
import monopoly.cases.Propriete;
import monopoly.tools.Logger;

import java.awt.*;
import java.util.*;

public class Joueur {

    public boolean enPrison;
    public String nomJoueur;
    public double argentJoueur;
    public int caseActuelle;
    public boolean doubleDes;
    public int compteurDouble;
    public int ancienneCase;
    public int tourEnPrison;
    public Scanner scanner;
    public int nbDoubleAffile;
    public Pion pion;

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


        Logger.printLog(this.getNomJoueur() + " a lancé les dés, résultat : " + resultat);
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

        if(this.getCaseActuelle() instanceof Propriete)
        {

            if(this.getCaseActuelle().getJoueurProprietaire() == null)
            {
                Logger.printLog("Cette propriété n'appartient à aucun joueur, vous pouvez l'acheter.");
                Jeu.getInstance().getPlateau().getIHM().getPanelGauche().activerBoutonAchat(true); // On peut acheter
                return;
            }
            if(this.getCaseActuelle().getJoueurProprietaire() == this)
            {
                Logger.printLog("Vous possédez déjà cette propriété.");
                Jeu.getInstance().getPlateau().getIHM().getPanelGauche().activerBoutonAchat(false);
                return;
            }
            if(this.getCaseActuelle().getJoueurProprietaire() != this)
            {
                Logger.printLog("Cette propriété appartient déjà au joueur : " + this.getCaseActuelle().getJoueurProprietaire().getNomJoueur());
                this.payerProprietaire();
                return;
            }
        }

        this.ancienneCase = caseActuelle;
    }

    public void acheter(Propriete emplacement, Case caseATraiter, ArrayList<Joueur> listeJoueur) {
        // Tout sauf case départ
        if(!(caseATraiter instanceof Depart)) {
            System.out.print("Voulez-vous acheter la propriété " + caseATraiter.nomCase + "? (oui/non): ");
            String choix = this.scanner.nextLine();
            if (choix.equals("oui")) {
                if (this.argentJoueur >= emplacement.prixPropriete) {
                    caseATraiter.joueurProprietaire = this;
                    this.argentJoueur = this.argentJoueur - emplacement.prixPropriete;
                }
            } else {
                //proposerAchat(listeJoueur, this, emplacement);
            }
        }

    }

    public void achatPropriete()
    {
        if(this.argentJoueur - ((Propriete) this.getCaseActuelle()).getPrixPropriete() > 0) // assez d'argent ?
        {
            this.deduireArgent(((Propriete) this.getCaseActuelle()).getPrixPropriete());
            Logger.printLog(this.getNomJoueur() + " a acheté la propriété : " + this.getCaseActuelle().getNomCase() + " pour : " + ((Propriete) this.getCaseActuelle()).getPrixPropriete() + "$");
            Jeu.getInstance().getPlateau().getIHM().getPanelGauche().activerBoutonAchat(false);
        }
        else
        {
            Logger.printLog("Vous n'avez pas assez d'argent pour acheter cette propriété");
            Jeu.getInstance().getPlateau().getIHM().getPanelGauche().activerBoutonAchat(false);

        }

    }

    public void payerProprietaire()
    {
        Propriete caseActuelle = (Propriete) this.getCaseActuelle();
        Joueur proprietaire = caseActuelle.getJoueurProprietaire();
        int prixApayer = caseActuelle.getPrixPropriete();

        this.deduireArgent(prixApayer);
        proprietaire.ajouterArgent(prixApayer);

    }

    public void vendre(Propriete emplacement, Case caseATraiter) {

        System.out.print("Voulez-vous vendre votre propriété? (oui/non): ");
        String choix = this.scanner.nextLine();
        if (choix.equals("oui")) {
            caseATraiter.joueurProprietaire = null;
            this.argentJoueur = this.argentJoueur + emplacement.prixPropriete ;
        }
    }

    public void paieTaxe(Propriete emplacement, int nbPropriete) {
        this.argentJoueur = this.argentJoueur - (emplacement.prixPropriete * (1 + (nbPropriete * 0.25))); // revoir l'opération avec les maisons
    }


    public int getNbGareJoueur(Joueur joueur, ArrayList<Case> listeCase){

        int nombreGare = 0;

        for( int i =0; i < listeCase.size(); i++){
            Case caseATraiter = listeCase.get(i);
            String nomATraiter = caseATraiter.nomCase.substring(0, 4);
            if (nomATraiter.equals("Gare")){
                if(caseATraiter.joueurProprietaire.equals(joueur)){
                    nombreGare = nombreGare + 1;
                }
            }
        }
        return nombreGare;
    }

    public String getNomJoueur()
    {
        return this.nomJoueur;
    }

    public double getArgentJoueur()
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

    public Pion getPion()
    {
        return this.pion;
    }

    public Case getCaseActuelle()
    {
        return Jeu.getInstance().getPlateau().getCase(this.caseActuelle);
    }

}
