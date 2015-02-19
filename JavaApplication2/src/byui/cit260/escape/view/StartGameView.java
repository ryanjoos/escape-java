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
public class StartGameView {
    
    public StartGameView(){
        
    }
    
    public void startGame(){
        
        //display banner screen
        this.displayBanner();
        //Get the players name
        String playersName = this.getPlayersName();
        //Create a New player
        //Display Customized Welcome Message
        //Display main menu
    }

    private void displayBanner() {
        System.out.println("\n\n****************************");
        
        System.out.println("*"
                + "\n*You are the captain of your ship. *"
                + "\n*You have an awesome crew *"
                + "\n*Unfortunately, whilst sailt the seven seas, *"  
                + "\n*Your crew was caught in a massive storm. *"
                + "\n*Your ship was thrown upon the rocks *"
                + "\n*You are now stranded upon this seemingly uninhabited island. *"
                );
        System.out.println("*"
                + "\n*You are the captain of your ship. *"
                + "\n*You have an awesome crew *"
                + "\n*Unfortunately, whilst sailt the seven seas, *"  
                + "\n*Your crew was caught in a massive storm. *"
                + "\n*Your ship was thrown upon the rocks *"
                + "\n*You are now stranded upon this seemingly uninhabited island. *"
                );
        System.out.println("\n*****************************");
        
    }    

    private String getPlayersName() {
        boolean valid = false; //Indicates if the name has be retrieved 
        String playersName = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //While a valid name has not been retrieved
            
            //Prompt for User name
            System.out.println("Enter Yo' Name, Matee(sp?)");
            
            //get the name from the keyboard and trim off the branks
            playersName = keyboard.nextLine();
            playersName = playersName.trim();
            
            //If the name is invalid
            if (playersName.length() < 1) {
                System.out.println("Your name is less than 1 character? That's silly. Try again please!");
                continue; // and repeat again
            }
            break; // stop the do while thingy
        }
        return playersName; //Takes that value and puts it back up yonder
    }
}
