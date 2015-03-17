/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.GameControl;
import byui.cit260.escape.model.Constants;
import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.Location;
import byui.cit260.escape.model.Map;
import byui.cit260.escape.model.Scene;
import byui.cit260.escape.model.SceneType;
import java.util.Arrays;

/**
 *
 * @author Carissa
 */
public class GameMenuView extends View {

    private char[][] map = null;

    public GameMenuView() {
        super("\n"
                + "\n========================================="
                + "\n=============  Game Menu  ==============="
                + "\n_________________________________________"
                + "\nV - View Map"
                + "\nI - View list of items in inventory"
                + "\nA - View list of actors"
                + "\nS - View raft status"
                + "\nL - View contents of location"
                + "\nM - Move person to new location"
                + "\nE - Estimate the resource needed"
                + "\nB - Design barrels"
                + "\nC - Construct tools"
                + "\nR - Harvest resource"
                + "\nD - Deliver resource"
                + "\nW - Work on raft"
                + "\nP - Pack raft"
                + "\nJ - Launch raft"
                + "\nH - Help"
                + "\nQ - Quit"
                + "\n=========================================");
    }

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);

        switch (choice) {
            case 'V':
                map = new char[20][20];
                this.displayMap();
                break;
            case 'I':
                this.viewInventory();
                break;
            case 'A':
                this.viewActors();
                break;
            case 'S':
                this.viewRaftStatus();
                break;
            case 'L':
                this.viewLocationContents();
                break;
            case 'M':
                this.movePerson();
                break;
            case 'E':
                this.estimateResources();
                break;
            case 'B':
                this.designBarrels();
                break;
            case 'C':
                this.constructTools();
                break;
            case 'R':
                this.harvestResource();
                break;
            case 'D':
                this.deliverResource();
                break;
            case 'W':
                this.workOnRaft();
                break;
            case 'P':
                this.packRaft();
                break;
            case 'J':
                this.launchRaft();
                break;
            case 'H':
                this.help();
                break;
            case 'Q':    // Exit the program
                this.displayMainMenu();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return true;
    }

    private void displayMap() {
//        System.out.println("\n*** displayMap ***");
        // get the map locations from the current game
        int rowCount = 0;
        int columnCount = 0;

        Scene[] scenes = new Scene[SceneType.values().length];

        // display title
        System.out.println("Jaba Island Map");
        // display row of column numbers
        System.out.println("       1     2     3     4     5     6    7     8     9    10    11    12    13    14   15    16    17    18    19    20");

        System.out.println("    ----------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < 20; i++) {
            if (i < 9) {
                System.out.print(i + 1 + " ");
            } else {
                System.out.print(i + 1);
            }

            System.out.print("  |    ");
            for (int j = 0; j < 20; j++) {
                System.out.print(map[i][j] + "|    ");

//                if (location[i][j].isVisited() == true) {
//                    System.out.println(" ??? ");

                //}
            }

//            System.out.println(Arrays.toString(sceneSymbol));
            System.out.println();
            System.out.println("    ----------------------------------------------------------------------------------------------------------------------");
        }

        // DISPLAY row divider
        // DISPLAY row number
        // FOR every column in row
        // DISPLAY column divider
        // location = location[row][column]
        // IF location has been visited
        // DISPLAY the map symbol for location
        //ELSE
        // DISPLAY " ?? "
        // ENDIF
        // DISPLAY ending column divider
        //ENDFOR
        //DISPLAY ending row divider
        //END
    }

    private void viewInventory() {
        //get the sorted list of inventory items
        Item[] inventory = GameControl.getSortedInventoryList();

        System.out.println("\nList of Items");
        System.out.println("\nDescription" + "\t"
                + "Required" + "\t"
                + "In Stock");

        //For each inventory item
        for (Item inventoryItem : inventory) {
            System.out.println(inventoryItem.getDescription() + "\t "
                    + inventoryItem.getRequiredAmount() + "\t "
                    + inventoryItem.getQuantityInStock());
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewActors() {
        System.out.println("\n*** viewActors ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewRaftStatus() {
        System.out.println("\n*** view raft status ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewLocationContents() {
        System.out.println("\n*** view location contents ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void movePerson() {
        System.out.println("\n*** move person ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void estimateResources() {
        System.out.println("\n*** estimate resources ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void designBarrels() {
        System.out.println("\n*** design barrels ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void constructTools() {
        System.out.println("\n*** construct tools ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void harvestResource() {
        System.out.println("\n*** harvest resource ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void deliverResource() {
        System.out.println("\n*** deliver resource ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void workOnRaft() {
        System.out.println("\n*** work on raft ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void packRaft() {
        System.out.println("\n*** pack raft ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void launchRaft() {
        System.out.println("\n*** launch raft ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void help() {
        System.out.println("\n*** get help ***");
        GetHelpView getHelpMenu = new GetHelpView();
        // display the game menu
        getHelpMenu.display();
    }

    private void displayMainMenu() {
        //Create a new Game Menu View
        MainMenuView mainMenu = new MainMenuView();
        // display the game menu
        mainMenu.display();
    }

}
