/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.GameControl;
import escapePackage.Escape;
import java.util.Scanner;

/**
 *
 * @author ryanjoos
 */
public class MainMenuView {

    private final String MENU = "\n"
            + "\n============================="
            + "\n=======  Main Menu  ========="
            + "\n_____________________________"
            + "\nN - Start New Game"
            + "\nG - Start Existing Game"
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

        } while (selection != 'E');
    }

    private String getInput() {
        boolean valid = false; //Indicates if the name has be retrieved 
        String inputValue = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream

        while (!valid) { //While a valid name has not been retrieved

            //Prompt for User name
            System.out.println("\nChoose and option from the menu: ");

            //get the name from the keyboard and trim off the branks
            inputValue = keyboard.nextLine();
            inputValue = inputValue.trim().toUpperCase();

            //If the name is invalid
            if (inputValue.length() < 1) {
                System.out.println("Please enter a value from the menu: ");
                continue; // and repeat again
            }
            break; // stop the do while thingy
        }
        return inputValue;
    }

    private void doAction(char choice) {

        switch (choice) {
            case 'N':
                this.startNewGame();
                break;
            case 'G':
                this.startExistingGame();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'E':    // Exit the program
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
    }

    private void startNewGame() {

        // create new game
        GameControl.createNewGame(Escape.getPlayer());

        //Create a new Game Menu View
        GameMenuView gameMenu = new GameMenuView();
        // display the game menu
        gameMenu.displayMenu();

    }

    private void startExistingGame() {
        System.out.println("*** startExistingGame function called ***");
    }

    private void displayHelpMenu() {
        
        //Create a new Game Menu View
        GetHelpView helpMenu = new GetHelpView();
        // display the game menu
        helpMenu.displayHelpMenu();
    }

    private void saveGame() {
         //Create a new Game Menu View
        SaveGameView save = new SaveGameView();
        // display the game menu
        save.getSaveInput();
    }
}
