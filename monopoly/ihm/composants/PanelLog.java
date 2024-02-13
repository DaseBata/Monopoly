package monopoly.ihm.composants;

import javax.swing.*;
import java.awt.*;

public class PanelLog extends JPanel {

    private final JTextArea textArea;

    private final JScrollPane scrollPane;

    public PanelLog()
    {
        super();
        this.setPreferredSize(new Dimension(900, 200));

        this.textArea = new JTextArea();
        this.textArea.setLineWrap(true);
        this.textArea.setFocusable(false);

        this.scrollPane = new JScrollPane(this.textArea);
        this.scrollPane.setPreferredSize(new Dimension(850, 180));

        this.add(this.scrollPane);

    }

    public void ajouterLog(String message)
    {
        this.textArea.append(message + "\n");
    }

}
