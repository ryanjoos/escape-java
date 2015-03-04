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



    public void doAction(String obj) {
        char choice = obj.toUpperCase().charAt(0);
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
        
        //Test ObstacleVolcanoView
        ObstacleVolcanoView volcanoScenario = new ObstacleVolcanoView();
        // display the volcano scenario
        volcanoScenario.displayMenu();

    }

    private void openGame() {
        System.out.println("*** openGame function called ***");
        OpenGameView openGameView = new OpenGameView();
        openGameView.openGame();
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
