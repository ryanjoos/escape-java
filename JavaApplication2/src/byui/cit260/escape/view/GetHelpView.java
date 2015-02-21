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
public class GetHelpView {

    private final String MENU = "\n"
            + "\n========================================================="
            + "\n======================  Help Menu  ======================"
            + "\n_________________________________________________________"
            + "\nG - What is the goal of the game?                        "
            + "\nM - How to move                                          "
            + "\nB - View Bag/View Status of Raft/Resources needed        "
            + "\nA - Interact (Harvest certain resources, use items, etc.)"
            + "\nL - View your location.                                  "
            + "\nO - Observe surroundings                                 "
            + "\nQ - Quit or Go Back to Main Menu                         "
            + "\n=========================================================";

    void displayHelpMenu() {
        char selection = ' ';
        do {
            System.out.println(MENU); // display HELP menu

            String input = this.getInput();
            selection = input.charAt(0);

            this.doHelpAction(selection);

        } while (selection != 'Q');
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
            inputValue = inputValue.trim();

            //If the name is invalid
            if (inputValue.length() < 1) {
                System.out.println("Please enter a value from the menu: ");
                continue; // and repeat again
            }
            break; // stop the do while thingy
        }
        return inputValue;
    }

    private void doHelpAction(char helpChoice) {
        switch (helpChoice) {
            case 'G':
                this.gameGoal();
                break;
            case 'M':
                this.howToMove();
                break;
            case 'B':
                this.viewResourceBag();
                break;
            case 'A':
                this.howToInteract();
                break;
            case 'L':
                this.viewLocation();
                break;
            case 'O':
                this.observeSurroundings();
                break;
            case 'Q':    // Quit the help menu
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
    }

    private void gameGoal() {
        System.out.println("*** gameGoal function called ***");
    }

    private void howToMove() {
        System.out.println("*** howToMove function called ***");
    }

    private void viewResourceBag() {
        System.out.println("*** viewResourceBag function called ***");
    }

    private void howToInteract() {
        System.out.println("*** howToInteract function called ***");
    }

    private void viewLocation() {
        System.out.println("*** viewLocation function called ***");
    }

    private void observeSurroundings() {
        System.out.println("*** observeSurroundings function called ***");
    }
}
