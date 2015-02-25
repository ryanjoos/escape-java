/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.SaveGameControl;
import byui.cit260.escape.model.Player;
import java.util.Scanner;

/**
 *
 * @author ryanjoos
 */
public class SaveGameView {

//    public void displayMenu() {
//
//        char selection = ' ';
//        do {
//
//            System.out.println(MENU); // display main menu
//
//            String input = this.getInput();
//            selection = input.charAt(0);
//
//            this.doAction(selection);
//
//        } while (selection != 'E');
//    }

    String getSaveInput() {
        boolean valid = false; //Indicates if the name has be retrieved 
        String inputValue = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream

        while (!valid) { //While a valid name has not been retrieved

            //Prompt for User name
            System.out.println("\n Matey, which file would ye like to save ye game: ");

            //get the name from the keyboard and trim off the branks
            inputValue = keyboard.nextLine();
            inputValue = inputValue.trim();

            //If the name is invalid
            if (inputValue.length() < 1) {
                System.out.println("Please enter a file name ");
                continue; // and repeat again
            }
            else 
                SaveGameControl.saveGame();
            break; // stop the do while thingy
        }
        return inputValue;
    }
}
