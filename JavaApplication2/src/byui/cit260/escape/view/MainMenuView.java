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
public class MainMenuView {
    
    private final String MENU = "\n"
            + "\n============================="
            + "\n=======  Main Menu  ========="
            + "\n_____________________________"
            + "\nG - Start Game"
            + "\nH - Get Help"
            + "\nS - Save Game"   
            + "\nE - Exit"
            + "\n=============================";

    public void displayMenu() {
        
        char selection = ' ';
        do {
          
            System.out.println(MENU); // display main menu
            
            String input = this.getInput();
            selection = input.charAt(0);
            
            this.doAction(selection);
            
        }while (selection != 'E');
    }
    
    
    
}
