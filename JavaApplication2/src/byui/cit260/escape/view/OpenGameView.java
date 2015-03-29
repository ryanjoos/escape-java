/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import java.io.IOException;

/**
 *
 * @author ryanjoos
 */
public class OpenGameView extends View{
    
    
    public OpenGameView(){
        super ("Open the game son.");
    }
    
    public void openGame() throws IOException{
       //Display What they have selected
        this.displayBanner();
       //Display list of available saved Games
       //Get input to what game they wish to open
        String selectGame = this.getSelectGame();
       //Display Loading “name of game” to let them know it was successful
    }

    private void displayBanner() {
        this.console.println("*You have selected open game,     *"
                          + "\n*what game would you like to open?*");
    }

    private String getSelectGame() throws IOException {
           
        boolean valid = false; //Indicates if the game has been selected 
        String selectGame = null;
        
        
        while(!valid) { //While a valid game has not been retrieved
            
            //Prompt for User to select Game
            this.console.println("\n***Available Games***"
                    + "\n -Carissa1"
                    + "\n -Ryan1");
            
            //get the name from the keyboard and trim off the branks
            selectGame = this.keyboard.readLine();
            selectGame = selectGame.trim();
            
            //If the game is invalid
            if (selectGame.length() < 1) {
                this.console.println("You didn't select a game. Be sure to spell it "
                        + "\n*correctly and it is case senstive. Try again please!");
                continue; // and repeat again
            }
            break; // stop the do while thingy
            
        }
        this.console.println("Success, Loading Game");
        return selectGame; //Takes that value and puts it back up yonder
        
    }

    @Override
    public boolean doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


            
}
