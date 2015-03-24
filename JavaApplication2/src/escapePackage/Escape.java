/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escapePackage;

import byui.cit260.escape.model.Game;
import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.Location;
import byui.cit260.escape.model.Map;
import byui.cit260.escape.model.Player;
import byui.cit260.escape.model.Raft;
import byui.cit260.escape.model.Scene;
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
        //Create StartGameView and start the game
        StartGameView startGameView = new StartGameView();
        
        try {
            startGameView.startGame();
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
//            strtGameView.display();
        }
        //Open Games that have been saved

        // class instances
        Player playerOne = new Player();
        Game gameOne = new Game();
//        Actor actorOne = new Actor();
        Map gameMap = new Map();
        Item itemOne = new Item();
        Raft raftOne = new Raft();
        Location locationOne = new Location();
//        Resource resourceOne = new Resource();
        Scene sceneOne = new Scene();

        // call setter functions
        playerOne.setName("Fred Flintstone");
        gameOne.setTotalTime(120.5);
//        actorOne.setName("Jaba the Hutt");
        gameMap.setRowCount(10);
        gameMap.setColumnCount(5);
//        itemOne.setItemType("Berries");
        raftOne.setRaftStatus(50.00);
        raftOne.setDescription("Good");
        locationOne.setColumn(1);
        locationOne.setRow(2);
        locationOne.setVisited(true);
//        resourceOne.setType("Berries");
//        resourceOne.setAmount(2);
        sceneOne.setDescription("Beach");
        sceneOne.setBlocked(true);

        // display player
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);

        // display game
        String gameInfo = gameOne.toString();
        System.out.println(gameInfo);
        // System.out.println(gameOne);

        // display actor
//        String actorInfo = actorOne.toString();
//        System.out.println(actorInfo);
        // display map
        String mapInfo = gameMap.toString();
        System.out.println(mapInfo);

        // display item
        String itemInfo = itemOne.toString();
        System.out.println(itemInfo);

        //display raft
        String raftInfo = raftOne.toString();
        System.out.println(raftInfo);
        //display location
        String locationInfo = locationOne.toString();
        System.out.println(locationInfo);
        //display scene
        String sceneInfo = sceneOne.toString();
        System.out.println(sceneInfo);
        //resource scene
//        String resourceInfo = resourceOne.toString();
//        System.out.println(resourceInfo);       
    }
}
