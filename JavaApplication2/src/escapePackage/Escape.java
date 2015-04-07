/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escapePackage;

import byui.cit260.escape.model.Game;
import byui.cit260.escape.model.Player;
import byui.cit260.escape.view.StartGameView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryanjoos
 */
public class Escape {

    private static Game currentGame = null;
    private static Player player = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    private static PrintWriter logFile = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Escape.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Escape.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        Escape.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        Escape.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        Escape.logFile = logFile;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // did not change System.in
        try {
            Escape.inFile
                    = new BufferedReader(new InputStreamReader(System.in));

            Escape.outFile = new PrintWriter(System.out, true);

            // open log file
            String filePath = "log.txt";
            Escape.logFile = new PrintWriter(filePath);

            StartGameView startGameView = new StartGameView();
            startGameView.startGame();
        } catch (Exception e) {
            // temp
            System.out.println("Exception: " + e.toString()
                    + "\nCause: " + e.getCause()
                    + "\nMessage: " + e.getMessage());
        } finally {
            try {
                if (Escape.inFile != null) {
                    Escape.inFile.close();
                }

                if (Escape.outFile != null) {
                    Escape.outFile.close();
                }

                if (Escape.logFile != null) {
                    Escape.logFile.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Escape.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }

    }
}
