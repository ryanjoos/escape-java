/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

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
       //Dipslay Loading “name of game” to let them know it was successful
    }

    private void displayBanner() {
        System.out.println("*You are trying to open a game, what game would you like to open?*");
    }
            
}
