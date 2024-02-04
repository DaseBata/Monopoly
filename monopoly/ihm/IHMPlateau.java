package monopoly.ihm;
import monopoly.Jeu;
import monopoly.Fond;
import monopoly.Joueur;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;



public class IHMPlateau extends JFrame {

    private final JPanel contentPane;
    private final JPanel panelHaut;
    private final JPanel panelGauche;
    private final Fond panelDroite;
    private final JPanel panelBas;
    private static final JTextArea textAreaLog = new JTextArea();

    private JButton btnUn, btnDeux, btnTrois, btnQuatre;

    private JLabel nomJoueur1;
    private JLabel nomJoueur2;
    private JLabel nomJoueur3;
    private JLabel nomJoueur4;

    private JLabel montantJoueur1;
    private JLabel montantJoueur2;
    private JLabel montantJoueur3;
    private JLabel montantJoueur4;


    public IHMPlateau()
    {
        super("Monopoly");
        setSize(900, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        this.contentPane = new JPanel(new BorderLayout());

        this.panelHaut = new JPanel();
        this.panelGauche = new JPanel();
        this.panelDroite = new Fond("monopoly.png");
        this.panelBas = new JPanel();


        this.creerPanelHaut();
        this.creerPanelGauche();
        this.creerPanelDroite();
        this.creerPanelBas();

        contentPane.add(panelHaut, BorderLayout.NORTH);
        contentPane.add(panelGauche, BorderLayout.WEST);
        contentPane.add(panelDroite, BorderLayout.EAST);
        contentPane.add(panelBas, BorderLayout.SOUTH);

        setContentPane(contentPane);
        setVisible(true);

    }

    public void creerPanelHaut()
    {
        this.panelHaut.setPreferredSize(new Dimension(900, 70));
        this.panelHaut.setBackground(Color.RED);
        this.panelHaut.setVisible(true);


        ArrayList<String> nomsJoueurs = Jeu.getInstance().getNomsJoueurs();
        this.nomJoueur1 = new JLabel(nomsJoueurs.get(0));
        this.nomJoueur2 = new JLabel(nomsJoueurs.get(1));
        this.nomJoueur3 = new JLabel(nomsJoueurs.get(2));
        this.nomJoueur4 = new JLabel(nomsJoueurs.get(3));

        JPanel panelArgent = new JPanel();
        panelArgent.setLayout(new GridLayout(1, 4));


        JLabel argentJoueur1 = new JLabel("Joueur 1 : 1000$");
        JLabel argentJoueur2 = new JLabel("Joueur 2 : 1001$");
        JLabel argentJoueur3 = new JLabel("Joueur 3 : 1003$");
        JLabel argentJoueur4 = new JLabel("Joueur 4 : 1004$");

        argentJoueur1.setBorder(new EmptyBorder(0, 20, 0, 20));
        argentJoueur1.setFont(new Font("Sergoe UI", 1, 24));

        argentJoueur2.setBorder(new EmptyBorder(0, 20, 0, 20));
        argentJoueur2.setFont(new Font("Sergoe UI", 1, 24));

        argentJoueur3.setBorder(new EmptyBorder(0, 20, 0, 20));
        argentJoueur3.setFont(new Font("Sergoe UI", 1, 24));

        argentJoueur4.setBorder(new EmptyBorder(0, 20, 0, 20));
        argentJoueur4.setFont(new Font("Sergoe UI", 1, 24));

        panelArgent.add(argentJoueur1);
        panelArgent.add(argentJoueur2);
        panelArgent.add(argentJoueur3);
        panelArgent.add(argentJoueur4);

        panelHaut.add(panelArgent);
    }

    public void creerPanelGauche()
    {
        this.btnUn = new JButton("Deplacer Joueur 1");
        this.btnUn.addActionListener(e -> this.deplacerJoueurUn());

        this.btnDeux = new JButton("Deplacer Joueur 2");
        this.btnTrois = new JButton("Deplacer Joueur 3");
        this.btnQuatre = new JButton("Deplacer Joueur 4");

        this.panelGauche.setPreferredSize(new Dimension(270, 800));

        this.panelGauche.add(this.btnUn);
        this.panelGauche.add(this.btnDeux);
        this.panelGauche.add(this.btnTrois);
        this.panelGauche.add(this.btnQuatre);
    }

    //Tests
    public void deplacerJoueurUn()
    {
        Joueur j1 = Jeu.getInstance().getListeJoueur().get(0);
        j1.deplacer(4);
    }

    public void creerPanelDroite()
    {
        this.panelDroite.setPreferredSize(new Dimension(600, 800));
        this.panelDroite.setBackground(Color.WHITE);
    }

    public void creerPanelBas()
    {
        this.textAreaLog.setPreferredSize(new Dimension(850, 180));
        this.textAreaLog.setLineWrap(true);
        this.textAreaLog.setEditable(false);
        this.textAreaLog.setFocusable(false);

        this.panelBas.setPreferredSize(new Dimension(900, 200));
        this.panelBas.setBackground(Color.YELLOW);
        this.panelBas.add(textAreaLog);

    }

    public Fond getPanelDroite()
    {
        return this.panelDroite;
    }
    
    public void nouveauLog(String message)
    {
        this.textAreaLog.append(message + "\n");
    }

    public static void main(String[] args)
    {
        JFrame frame = new IHMPlateau();
    }



}
