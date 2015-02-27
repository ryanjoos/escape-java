/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import java.util.Scanner;

/**
 *
 * @author ryanjoos
 */
public class OpenGameView {
    
    public OpenGameView(){
        
    }
    
    public void openGame(){
       //Display What they have selected
        this.displayBanner();
       //Display list of available saved Games
       //Get input to what game they wish to open
        String selectGame = this.getSelectGame();
       //Display Loading “name of game” to let them know it was successful
    }

    private void displayBanner() {
        System.out.println("*You have selected open game,     *"
                          + "\n*what game would you like to open?*");
    }

    private String getSelectGame() {
           
        boolean valid = false; //Indicates if the game has been selected 
        String selectGame = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //While a valid game has not been retrieved
            
            //Prompt for User to select Game
            System.out.println("\n***Available Games***"
                    + "\n -Carissa1"
                    + "\n -Ryan1");
            
            //get the name from the keyboard and trim off the branks
            selectGame = keyboard.nextLine();
            selectGame = selectGame.trim();
            
            //If the game is invalid
            if (selectGame.length() < 1) {
                System.out.println("You didn't select a game. Be sure to spell it "
                        + "\n*correctly and it is case senstive. Try again please!");
                continue; // and repeat again
            }
            break; // stop the do while thingy
            
        }
        System.out.println("Success, Loading Game");
        return selectGame; //Takes that value and puts it back up yonder
        
    }


            
}
