/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escapePackage;

import byui.cit260.escape.model.Actor;
import byui.cit260.escape.model.Game;
import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.Location;
import byui.cit260.escape.model.Map;
import byui.cit260.escape.model.Player;
import byui.cit260.escape.model.Raft;
import byui.cit260.escape.model.Resource;
import byui.cit260.escape.model.Scene;
import byui.cit260.escape.view.StartGameView;

/**
 *
 * @author ryanjoos
 */
public class Escape {
    
    private static Game currentGame = null;
    private static Player player = null;

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

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Create StartGameView and start the game
        StartGameView startGameView = new StartGameView();
        startGameView.startGame();
        
        //Open Games that have been saved

        
        // class instances
        Player playerOne = new Player();
        Game gameOne = new Game();
        Actor actorOne = new Actor();
        Map gameMap = new Map();
        Item itemOne = new Item();
        Raft raftOne = new Raft();
        Location locationOne = new Location();
        Resource resourceOne = new Resource();
        Scene sceneOne = new Scene();

        // call setter functions
        playerOne.setName("Fred Flintstone");
        gameOne.setTotalTime(120.5);
        actorOne.setName("Jaba the Hutt");
        gameMap.setRowCount(10);
        gameMap.setColumnCount(5);
        itemOne.setItemType("Berries");
        raftOne.setRaftStatus(50.00);
        raftOne.setDescription("Good");
        locationOne.setColumn(1);
        locationOne.setRow(2);
        locationOne.setVisited(true);
        resourceOne.setType("Berries");
        resourceOne.setAmount(2);
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
        String actorInfo = actorOne.toString();
        System.out.println(actorInfo);

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
        String resourceInfo = resourceOne.toString();
        System.out.println(resourceInfo);       
    }
}
