/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.MapControl;
import java.util.Scanner;

/**
 *
 * @author ryanjoos
 */
public class CrossRiverView {
    private final String RIVER = "\n"
            + "\n========================================================="
            + "\n======================  What next  ======================"
            + "\n_________________________________________________________"
            + "\nYou've come to a river. The current is far too strong.   "
            + "\nIn order to be able to cross you must construct a bridge."
            + "\nWhat is your next move to safety? Quick!                 "
            + "\nL - Leave and come back later                            "            
            + "\nC - Check my resources to see if I can build             "
            + "\nB - Build the Bridge                                     "
            + "\n=========================================================";

    public void displayMenu() {

        char selection = ' ';
        do {

            System.out.println(RIVER); // display main menu

            String input = this.getInput();
            selection = input.charAt(0);

            this.doAction(selection);

        } while (selection != 'L');
    }

    private String getInput() {
        boolean valid = false; //Indicates if the name has be retrieved 
        String inputValue = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream

        while (!valid) { //While a valid name has not been retrieved

            //Prompt for User name
            System.out.println("\nWhat do you want to do? ");

            //get the name from the keyboard and trim off the branks
            inputValue = keyboard.nextLine();
            inputValue = inputValue.trim().toUpperCase();

            //If the name is invalid
            if (inputValue.length() < 1) {
                System.out.println("I'm sorry, Try again.");
                continue; // and repeat again
            }
            break; // stop the do while thingy
        }
        return inputValue;
    }

    private void doAction(char choice) {

        switch (choice) {

            case 'C':
                this.checkResources();
                break;
            case 'B':
                this.buildBridge();
                break;
            case 'L':    
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
    }

    private void checkResources() {
        System.out.println("Looks Good, Go ahead and Build the Bridge");
    }

    private void buildBridge() {
        MapControl.calcBridgeSize(10,10,1);
    }
}
