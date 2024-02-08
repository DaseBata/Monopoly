package monopoly.ihm;
import monopoly.Jeu;
import monopoly.Fond;
import monopoly.Joueur;
import monopoly.ihm.composants.ArgentJoueurs;
import monopoly.ihm.composants.PanelActions;

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
    private final PanelActions panelGauche;
    private final Fond panelDroite;
    private final JPanel panelBas;
    private static final JTextArea textAreaLog = new JTextArea();
    private ArgentJoueurs composantArgentJoueur;

    public IHMPlateau()
    {
        super("Monopoly");
        setSize(900, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        this.contentPane = new JPanel(new BorderLayout());

        this.panelHaut = new JPanel();
        this.panelGauche = new PanelActions();
        this.panelDroite = new Fond("monopoly.png");
        this.panelBas = new JPanel();


        this.creerPanelHaut();
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

    public PanelActions getPanelGauche() {
        return panelGauche;
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
