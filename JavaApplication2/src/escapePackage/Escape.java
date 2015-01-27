/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escapePackage;

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
        Player playerOne = new Player();

        playerOne.setName("Fred Flintstone");

        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }

}
