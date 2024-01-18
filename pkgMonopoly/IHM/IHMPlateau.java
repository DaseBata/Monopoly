package pkgMonopoly.IHM;
import javax.swing.*;
import java.awt.*;


public class IHMPlateau extends JFrame {

    private final JPanel contentPane;
    private final JPanel panelHaut;
    private final JPanel panelGauche;
    private final JPanel panelDroite;
    private final JPanel panelBas;
    private static final JTextArea textAreaLog = new JTextArea();


    public IHMPlateau()
    {
        super("Monopoly");
        setSize(900, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.contentPane = new JPanel(new BorderLayout());

        this.panelHaut = new JPanel();
        this.panelGauche = new JPanel();
        this.panelDroite = new JPanel();
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
        this.panelHaut.setPreferredSize(new Dimension(900, 100));
        this.panelHaut.setBackground(Color.RED);
        this.panelHaut.setVisible(true);
    }

    public void creerPanelGauche()
    {
        this.panelGauche.setPreferredSize(new Dimension(300, 800));
        this.panelGauche.setBackground(Color.BLUE);
    }

    public void creerPanelDroite()
    {
        this.panelDroite.setPreferredSize(new Dimension(600, 800));
        this.panelDroite.setBackground(Color.GREEN);
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
    
    public void nouveauLog(String message)
    {
        this.textAreaLog.append(message + "\n");
    }

    public static void main(String[] args)
    {
        JFrame frame = new IHMPlateau();
    }



}
