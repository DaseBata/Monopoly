package monopoly.ihm;
import java.awt.*;
import javax.swing.*;

import monopoly.Jeu;
import monopoly.Joueur;

public class IHMInscription extends JFrame {

    private final JPanel panelInscription;
    private final JTextField nomJoueur1;
    private final JTextField nomJoueur2;
    private final JTextField nomJoueur3;
    private final JTextField nomJoueur4;
    private final JLabel labelErreur;


    public IHMInscription()
    {

        super("Inscription des joueurs");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel(new BorderLayout());

        this.panelInscription = new JPanel();
        panelInscription.setLayout(new BoxLayout(panelInscription, BoxLayout.Y_AXIS));
        panelInscription.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel labelTitre = new JLabel("Inscription des joueurs");
        labelTitre.setFont(new Font("Sergoe UI", 1, 24).deriveFont(24f));

        this.labelErreur = new JLabel("");
        labelErreur.setForeground(Color.RED);
        labelErreur.setVisible(false);

        JLabel label1 = new JLabel("Joueur 1");
        nomJoueur1 = new JTextField(10);

        JLabel label2 = new JLabel("Joueur 2");
        nomJoueur2 = new JTextField(10);

        JLabel label3 = new JLabel("Joueur 3");
        nomJoueur3 = new JTextField(10);

        JLabel label4 = new JLabel("Joueur 4");
        nomJoueur4 = new JTextField(10);

        JButton btnInscription = new JButton("Inscription");
        btnInscription.addActionListener(e -> this.inscrireJoueur());

        this.panelInscription.add(labelTitre);
        this.panelInscription.add(this.labelErreur);
        this.panelInscription.add(label1);
        this.panelInscription.add(nomJoueur1);
        this.panelInscription.add(label2);
        this.panelInscription.add(nomJoueur2);
        this.panelInscription.add(label3);
        this.panelInscription.add(nomJoueur3);
        this.panelInscription.add(label4);
        this.panelInscription.add(nomJoueur4);
        this.panelInscription.add(btnInscription);

        contentPanel.add(panelInscription, BorderLayout.CENTER);

        this.setContentPane(contentPanel);
        setVisible(true);

    }

    public void inscrireJoueur()
    {
        if (this.nomJoueur1.getText().isEmpty()
                || this.nomJoueur2.getText().isEmpty()
                || this.nomJoueur3.getText().isEmpty()
                || this.nomJoueur4.getText().isEmpty()
        ) {
            this.displayError("Les noms des joueurs ne sont pas tous renseignés");
            return;
        }
        else {

            Joueur joueur1 = new Joueur(nomJoueur1.getText());
            joueur1.getPion().setCouleur(Color.RED);
            Joueur joueur2 = new Joueur(nomJoueur2.getText());
            joueur2.getPion().setCouleur(Color.GREEN);
            Joueur joueur3 = new Joueur(nomJoueur3.getText());
            joueur3.getPion().setCouleur(Color.BLUE);
            Joueur joueur4 = new Joueur(nomJoueur4.getText());
            joueur4.getPion().setCouleur(Color.YELLOW);

            this.setVisible(false);
            this.dispose();

            Jeu jeu = Jeu.getInstance();
            jeu.initialiserJeu(joueur1, joueur2, joueur3, joueur4);
        }
    }

    public void displayError(String msgErreur)
    {
        this.labelErreur.setText(msgErreur);
        this.labelErreur.setVisible(true);
    }



}
