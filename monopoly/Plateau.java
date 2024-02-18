package monopoly;
import monopoly.ihm.IHMPlateau;
import monopoly.cases.*;

import java.util.ArrayList;

public class Plateau {

    private ArrayList<Case> listeCase;
    private ParcGratuit parc;
    private IHMPlateau ihm;
    private Prison prison;

    public Plateau() {
        this.listeCase = new ArrayList<>();
        this.parc = new ParcGratuit(20, "Parc gratuit", 26, 30);
        this.prison = new Prison(10, "Prison", 11, 457);
        this.ihm = new IHMPlateau();
    }

    public void initialiserPlateau() {

        listeCase.add(new Depart(0, "Départ", 550, 450));
        listeCase.add(new Propriete(1, "Boul. de Belleville", 6000, 493, 457));
        listeCase.add(new Communaute(2, "Communaute", 441, 457));
        listeCase.add(new Propriete(3, "Rue Lecourbe", 6000, 392, 457));
        listeCase.add(new Taxe(4, "Impots sur le Revenu", 20000, 346, 457));
        listeCase.add(new Gare(5, "Gare MontParnasse", 20000, 290, 457));
        listeCase.add(new Propriete(6, "Rue de Vaugirard", 10000, 251, 457));
        listeCase.add(new Chance(7, "Chance", 190, 457));
        listeCase.add(new Propriete(8, "Rue de Courcelles", 10000, 156, 457));
        listeCase.add(new Propriete(9, "Avenue de la Republique", 10000, 104, 457));
        listeCase.add(this.prison);

        listeCase.add(new Propriete(11, "Boul. de la Vilette", 14000, 26, 390));
        listeCase.add(new Taxe(12, "Compagnie de dist. d'Electricite", 15000, 26, 350));
        listeCase.add(new Propriete(13, "Avenue de Neuilly", 14000, 26, 310));
        listeCase.add(new Propriete(14, "Rue de Paradis", 16000, 26, 270));
        listeCase.add(new Gare(15, "Gare de Lyon", 20000, 26, 230));
        listeCase.add(new Propriete(16, "Avenue Mozart", 18000, 26, 190));
        listeCase.add(new Communaute(17, "Communaute", 26, 150));
        listeCase.add(new Propriete(18, "Boulevard Saint-Michel", 18000, 26, 110));
        listeCase.add(new Propriete(19, "Place Pigalle", 20000, 26, 81));
        listeCase.add(this.parc);

        listeCase.add(new Propriete(21, "Avenue Matignon", 22000, 105, 26));
        listeCase.add(new Chance(22, "Chance", 151, 26));
        listeCase.add(new Propriete(23, "Boulevard Malesherbes", 22000, 201, 26));
        listeCase.add(new Propriete(24, "Avenue Henri-Martin", 24000, 248, 26));
        listeCase.add(new Gare(25, "Gare du Nord", 20000, 299, 26));
        listeCase.add(new Propriete(26, "Faubourg Saint-Honore", 26000, 335, 26));
        listeCase.add(new Propriete(27, "Place de la Bourse", 26000, 393, 26));
        listeCase.add(new Taxe(28, "Compagnie de dist. des eaux", 15000, 444, 26));
        listeCase.add(new Propriete(29, "Rue la Fayette", 28000, 484, 26));
        listeCase.add(new AllerPrison(30, "Aller Prison", 567, 26));

        listeCase.add(new Propriete(31, "Avenue Breteuil", 30000, 567, 70));
        listeCase.add(new Propriete(32, "Avenue Foch", 30000, 567, 110));
        listeCase.add(new Communaute(33, "Communaute", 567, 150));
        listeCase.add(new Propriete(34, "Boul. des Capucines", 32000, 567, 190));
        listeCase.add(new Gare(35, "Gare Saint-Lazare", 20000, 567, 230));
        listeCase.add(new Chance(36, "Chance", 567, 270));
        listeCase.add(new Propriete(37, "Avenue des Champs-Elysees", 35000, 567, 310));
        listeCase.add(new Taxe(38, "Taxe de Luxe", 10000, 567, 350));
        listeCase.add(new Propriete(39, "Rue de la Paix", 40000, 567, 390));
    }

    public void placerJoueurs(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, int numCase) {
        listeCase.get(numCase).getListeJoueur().add(joueur1);
        listeCase.get(numCase).getListeJoueur().add(joueur2);
        listeCase.get(numCase).getListeJoueur().add(joueur3);
        listeCase.get(numCase).getListeJoueur().add(joueur4);
    }

    public Case getCase(int index) {
        return this.listeCase.get(index);
    }

    public ArrayList<Case> getListeCase() {
        return listeCase;
    }

    public void ajoutParc(int ajoutParc) {
        int argentActuelle = parc.getArgentParc();
        parc.setArgentParc(argentActuelle);
    }

    public IHMPlateau getIHM()
    {
        return this.ihm;
    }

    public ParcGratuit getParcGratuit()
    {
        return this.parc;
    }

    public Prison getPrison()
    {
        return this.prison;
    }

}

