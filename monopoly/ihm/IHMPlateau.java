package monopoly.ihm;
import monopoly.ihm.composants.ArgentJoueurs;
import monopoly.ihm.composants.Fond;
import monopoly.ihm.composants.PanelActions;
import monopoly.ihm.composants.PanelLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class IHMPlateau extends JFrame {

    private final JPanel contentPane;
    private final JPanel panelHaut;
    private final PanelActions panelGauche;
    private final Fond panelDroite;
    private final PanelLog panelBas;
    private ArgentJoueurs composantArgentJoueur;

    public IHMPlateau()
    {
        super("Monopoly");
        this.setSize(900, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.contentPane = new JPanel(new BorderLayout());

        this.panelHaut = new JPanel();
        this.panelGauche = new PanelActions();
        this.panelDroite = new Fond("monopoly.png");
        this.panelBas = new PanelLog();

        this.creerPanelHaut();
        this.creerPanelDroite();

        this.contentPane.add(panelHaut, BorderLayout.NORTH);
        this.contentPane.add(panelGauche, BorderLayout.WEST);
        this.contentPane.add(panelDroite, BorderLayout.EAST);
        this.contentPane.add(panelBas, BorderLayout.SOUTH);

        this.setContentPane(contentPane);
        this.setVisible(true);

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

    public PanelLog getPanelLog()
    {
        return this.panelBas;
    }

    public static void main(String[] args)
    {
        JFrame frame = new IHMPlateau();
    }



}
