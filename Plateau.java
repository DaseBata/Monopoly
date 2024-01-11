import java.util.ArrayList;

public class Plateau {

    ArrayList<Case> listeCase;
    int argentParcGratuit;

    public Plateau() {
        listeCase = new ArrayList<>();
        argentParcGratuit = 0;
    }

    public void initialiserPlateau(){

        listeCase.add(new Depart(0, "Départ"));
        listeCase.add(new Propriete(1, "Boul. de Belleville", 6000));
        listeCase.add(new Communaute(2));
        listeCase.add(new Propriete(3, "Rue Lecourbe", 6000));
        listeCase.add(new Taxe(4, "Impots sur le Revenu", 20000));
        listeCase.add(new Gare(5, "Gare MontParnasse", 20000));
        listeCase.add(new Propriete(6, "Rue de Vaugirard", 10000));
        listeCase.add(new Chance(7));
        listeCase.add(new Propriete(8, "Rue de Courcelles", 10000));
        listeCase.add(new Propriete(9, "Avenue de la Republique", 10000));

        listeCase.add(new Prison(10, "Prison"));
        listeCase.add(new Propriete(11, "Boul. de la Vilette", 14000));
        listeCase.add(new Taxe(12, "Compagnie de dist. d'Electricite", 15000));
        listeCase.add(new Propriete(13, "Avenue de Neuilly", 14000));
        listeCase.add(new Propriete(14, "Rue de Paradis", 16000));
        listeCase.add(new Gare(15, "Gare de Lyon", 20000));
        listeCase.add(new Propriete(16, "Avenue Mozart", 18000));
        listeCase.add(new Communaute(17));
        listeCase.add(new Propriete(18, "Boulevard Saint-Michel", 18000));
        listeCase.add(new Propriete(19, "Place Pigalle", 20000));

        listeCase.add(new ParcGratuit(20));
        listeCase.add(new Propriete(21, "Avenue Matignon", 22000));
        listeCase.add(new Chance(22));
        listeCase.add(new Propriete(23, "Boulevard Malesherbes", 22000));
        listeCase.add(new Propriete(24, "Avenue Henri-Martin", 24000));
        listeCase.add(new Gare(25, "Gare du Nord", 20000));
        listeCase.add(new Propriete(26, "Faubourg Saint-Honore", 26000));
        listeCase.add(new Propriete(27, "Place de la Bourse", 26000));
        listeCase.add(new Taxe(28, "Compagnie de dist. des eaux", 15000));
        listeCase.add(new Propriete(29, "Rue la Fayette", 28000));

        listeCase.add(new AllerPrison(30));
        listeCase.add(new Propriete(31, "Avenue Breteuil", 30000));
        listeCase.add(new Propriete(32, "Avenue Foch", 30000));
        listeCase.add(new Communaute(33));
        listeCase.add(new Propriete(34, "Boul. des Capucines", 32000));
        listeCase.add(new Gare(35, "Gare Saint-Lazare", 20000));
        listeCase.add(new Chance(36));
        listeCase.add(new Propriete(37, "Avenue des Champs-Elysees", 35000));
        listeCase.add(new Taxe(38, "Taxe de Luxe", 10000));
        listeCase.add(new Propriete(39, "Rue de la Paix", 40000));
    }

    public void initialiserJoueur(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4){
        listeCase.get(0).listeJoueur.add(joueur1);
        listeCase.get(0).listeJoueur.add(joueur2);
        listeCase.get(0).listeJoueur.add(joueur3);
        listeCase.get(0).listeJoueur.add(joueur4);
    }
}
