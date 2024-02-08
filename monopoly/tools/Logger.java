package monopoly.tools;

import monopoly.Jeu;

import javax.swing.*;

public class Logger {

    public static int numeroLog = 0;

    public static void printLog(String message)
    {
        numeroLog = numeroLog + 1;
        Jeu.getInstance().getPlateau().getIHM().nouveauLog("["+numeroLog+"] " + message);
    }


}
