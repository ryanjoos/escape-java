/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.SaveGameControl;
import java.io.IOException;

/**
 *
 * @author ryanjoos
 */
public class SaveGameView extends View{

    public SaveGameView() {
        super("Saving the game to a file: ");
    }

    String getSaveInput() throws IOException {
        boolean valid = false; //Indicates if the name has be retrieved 
        String inputValue = null;

        while (!valid) { //While a valid name has not been retrieved

            //Prompt for User name
            this.console.println("\n Matey, which file would ye like to save ye game: ");

            //get the name from the keyboard and trim off the branks
            inputValue = this.keyboard.readLine();
            inputValue = inputValue.trim();

            //If the name is invalid
            if (inputValue.length() < 1) {
                ErrorView.display(this.getClass().getName(), "Please enter a file name ");
                continue; // and repeat again
            }
            else 
                SaveGameControl.saveGame();
            break; // stop the do while thingy
        }
        return inputValue;
    }

    @Override
    public boolean doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
