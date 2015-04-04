/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.GameControl;
import byui.cit260.escape.exceptions.MapControlException;
import escapePackage.Escape;

/**
 *
 * @author ryanjoos
 */
public class MainMenuView extends View {

    public MainMenuView() {
        super("               ,\n"
                + "             .';\n"
                + "         .-'` .'\n"
                + "       ,`.-'-.`\\\n"
                + "      ; /     '-'\n"
                + "      | \\       ,-,\n"
                + "      \\  '-.__   )_`'._\n"
                + "       '.     ```      ``'--._\n"
                + "      .-' ,                   `'-.\n"
                + "       '-'`-._           ((   o   )\n"
                + "              `'--....(`- ,__..--'\n"
                + "                       '-'`"
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

        // prompt for and get the name of the file to save the game in
        this.console.println("\n\nEnter the file path for file where the game "
                + "is to be saved.");

        String filePath = this.getInput();

        try {
            // start a saved game
            GameControl.getSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }

        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void displayHelpMenu() {

        //Create a new Game Menu View
        GetHelpView helpMenu = new GetHelpView();
        // display the game menu
        helpMenu.display();
    }

    private void saveGame() {

        // prompt for and get the name of the file to save the game in 
        this.console.println("\n\nEnter the file path for file where the game "
                + "is to be saved.");
        String filePath = this.getInput();

        try {
            GameControl.saveGame(Escape.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }
}
