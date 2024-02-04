package monopoly.ihm;
import monopoly.Jeu;
import monopoly.Fond;
import monopoly.Joueur;
import monopoly.ihm.composants.ArgentJoueurs;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


public class IHMPlateau extends JFrame {

    private final JPanel contentPane;
    private final JPanel panelHaut;
    private final JPanel panelGauche;
    private final Fond panelDroite;
    private final JPanel panelBas;
    private static final JTextArea textAreaLog = new JTextArea();
    private JButton btnUn, btnDeux, btnTrois, btnQuatre, btnCinq, btnSix, btnSept, btnHuit;
    private ArgentJoueurs composantArgentJoueur;

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
        this.panelHaut.setBackground(Color.WHITE);
        this.panelHaut.setVisible(true);

        this.composantArgentJoueur = new ArgentJoueurs();

        panelHaut.add(this.composantArgentJoueur);
    }

    public void creerPanelGauche()
    {
        this.btnUn = new JButton("Deplacer Joueur 1");
        this.btnDeux = new JButton("Deplacer Joueur 2");
        this.btnTrois = new JButton("Deplacer Joueur 3");
        this.btnQuatre = new JButton("Deplacer Joueur 4");

        this.btnCinq = new JButton("Donner argent Joueur 1");
        this.btnSix = new JButton("Donner argent Joueur 2");
        this.btnSept = new JButton("Donner argent Joueur 3");
        this.btnHuit = new JButton("Donner argent Joueur 4");



        this.btnUn.addActionListener(e -> this.deplacerJoueur(0));
        this.btnDeux.addActionListener(e -> this.deplacerJoueur(1));
        this.btnTrois.addActionListener(e -> this.deplacerJoueur(2));
        this.btnQuatre.addActionListener(e -> this.deplacerJoueur(3));

        ArrayList<Joueur> joueurs = Jeu.getInstance().getListeJoueur();
        this.btnCinq.addActionListener(e -> joueurs.get(0).ajouterArgent(100));
        this.btnSix.addActionListener(e -> joueurs.get(1).ajouterArgent(102));
        this.btnSept.addActionListener(e -> joueurs.get(2).ajouterArgent(103));
        this.btnHuit.addActionListener(e -> joueurs.get(3).ajouterArgent(104));

        this.panelGauche.setPreferredSize(new Dimension(270, 800));

        this.panelGauche.add(this.btnUn);
        this.panelGauche.add(this.btnDeux);
        this.panelGauche.add(this.btnTrois);
        this.panelGauche.add(this.btnQuatre);
        this.panelGauche.add(this.btnCinq);
        this.panelGauche.add(this.btnSix);
        this.panelGauche.add(this.btnSept);
        this.panelGauche.add(this.btnHuit);
    }

    //Tests
    public void deplacerJoueur(int numJoueur)
    {
        Joueur j1 = Jeu.getInstance().getListeJoueur().get(numJoueur);
        int nouvelleCase = new Random().nextInt(38);
        j1.deplacer(1);
        this.nouveauLog("Deplacement du joueur " + numJoueur + " sur la case : " + nouvelleCase );
    }

    public void creerPanelDroite()
    {
        this.panelDroite.setPreferredSize(new Dimension(600, 800));
        this.panelDroite.setBackground(Color.WHITE);
        this.panelDroite.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX() + "," + e.getY());
            }
        });
    }

    public void creerPanelBas()
    {
        textAreaLog.setPreferredSize(new Dimension(850, 180));
        textAreaLog.setLineWrap(true);
        textAreaLog.setEditable(false);

        JScrollPane scroll = new JScrollPane(textAreaLog);

        this.panelBas.setPreferredSize(new Dimension(900, 200));
        this.panelBas.setBackground(Color.YELLOW);
        this.panelBas.add(scroll);

    }

    public Fond getPanelDroite()
    {
        return this.panelDroite;
    }

    public ArgentJoueurs getComposantArgentJoueur()
    {
        return this.composantArgentJoueur;
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
