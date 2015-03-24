/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import escapePackage.Escape;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carissa
 */
public abstract class View implements ViewInterface {

    private String promptMessage;
    
    protected final BufferedReader keyboard = Escape.getInFile();
    protected final PrintWriter console = Escape.getOutFile();

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

        while (!valid) { //While a valid name has not been retrieved

            //Prompt for User name
            System.out.println("\nEnter your selection below: ");

            try {
                //get the name from the keyboard and trim off the branks
                selection = this.keyboard.readLine();
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
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
