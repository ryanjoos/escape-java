/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.GameControl;
import byui.cit260.escape.exceptions.MapControlException;
import escapePackage.Escape;
import java.io.IOException;

/**
 *
 * @author ryanjoos
 */
public class MainMenuView extends View {

    public MainMenuView() {
        super("\n"
                + "\n============================="
                + "\n=======  Main Menu  ========="
                + "\n_____________________________"
                + "\nN - Start New Game"
                + "\nG - Open Saved Game"
                + "\nH - Get Help"
                + "\nS - Save Game"
                + "\nE - Exit"
                + "\n=============================");
    }

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);

        switch (choice) {
            case 'N':

                this.startNewGame();
                break;
            case 'G':
                this.openGame();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'E':    // Exit the program
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return true;
    }

    private void startNewGame() {

        // create new game
        try {
        GameControl.createNewGame(Escape.getPlayer());
        } catch (MapControlException me) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + me.getMessage());
        } catch (Throwable te) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + te.getMessage());
            te.printStackTrace();
            return;
        }
        //Create a new Game Menu View
        GameMenuView gameMenu = new GameMenuView();

        // display the game menu
        gameMenu.display();

    }

    private void openGame() {
        this.console.println("*** openGame function called ***");
        OpenGameView openGameView = new OpenGameView();
        try {
        openGameView.openGame();
        } catch (IOException exc) {
            ErrorView.display(this.getClass().getName(), "I/O Error: " + exc);
        }
    }

    private void displayHelpMenu() {

        //Create a new Game Menu View
        GetHelpView helpMenu = new GetHelpView();
        // display the game menu
        helpMenu.display();
    }

    private void saveGame() {
        //Create a new Game Menu View
        SaveGameView save = new SaveGameView();
        // display the game menu
        try {
        save.getSaveInput();
        }catch (IOException exc) {
            ErrorView.display(this.getClass().getName(), "I/O Error: " + exc);
        }
    }
}
