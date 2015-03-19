/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import java.util.Scanner;

/**
 *
 * @author Carissa
 */
public abstract class View implements ViewInterface {

    private String promptMessage;

    public View(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    @Override
    public void display() {

        boolean result;
        String value;

        do {

            System.out.println(this.promptMessage); // display main menu

            value = this.getInput();

            result = this.doAction(value);

        } while (!result);
    }

    @Override
    public String getInput() {
        boolean valid = false; //Indicates if the name has be retrieved 
        String selection = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream

        while (!valid) { //While a valid name has not been retrieved

            //Prompt for User name
            System.out.println("\nEnter your selection below: ");

            //get the name from the keyboard and trim off the branks
            selection = keyboard.nextLine();
            selection = selection.trim();

            //If the name is invalid
            if (selection.length() < 1) {
                System.out.println("***\n Invalid Selection *** Try again");
                continue; // and repeat again
            }
            break; // stop the do while thingy
        }
        return selection;
    }
    
    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String message) {
        this.promptMessage = message;
    }
    
}
