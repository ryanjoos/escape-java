/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escapePackage;

import byui.cit260.escape.model.Actor;
import byui.cit260.escape.model.Game;
import byui.cit260.escape.model.Player;

/**
 *
 * @author ryanjoos
 */
public class Escape {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // class instances
        Player playerOne = new Player();
        Game gameOne = new Game();
        Actor actorOne = new Actor();
        
        // call setter functions
        playerOne.setName("Fred Flintstone");
        gameOne.setTotalTime(120.5);
        actorOne.setName("Jaba the Hut");

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
    }

}
