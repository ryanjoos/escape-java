/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.GameControl;
import byui.cit260.escape.control.MapControl;
import byui.cit260.escape.exceptions.GameControlException;
import byui.cit260.escape.exceptions.MapControlException;
import byui.cit260.escape.model.Actor;
import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.Location;
import escapePackage.Escape;
import java.awt.Point;

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
                + "\nO - View resource status"
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
            case 'O':
                this.viewResourceStatus();
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
                ErrorView.display(this.getClass().getName(),
                        "\n***** invalid selection **** Try Again!");
                break;
        }
        return true;
    }

    private void displayMap() {
        // get the map locations from the current game
        Location[][] locations = Escape.getCurrentGame().getMap().getLocations();

        // display title
        this.console.println("                                                                    Jaba Island Map                                                         ");
        this.console.println();

        // display row of column numbers
        this.console.println("      1      2      3      4      5      6     7      8      9      10     11     12     13     14     15     16     17     18     19     20");

        // DISPLAY row divider
        this.console.println("   -------------------------------------------------------------------------------------------------------------------------------------------");
        // DISPLAY row number
        // FOR every column in row
        // DISPLAY column divider
        for (int i = 0; i < 20; i++) {
            if (i < 9) {
                this.console.print(i + 1 + " ");
            } else {
                this.console.print(i + 1);
            }
            this.console.print("|");
            for (int j = 0; j < 20; j++) {
                // location = location[row][column]
                Location location = locations[i][j];
                // IF location has been visited
                // DISPLAY the map symbol for location
                if (locations[i][j].isVisited() == true) {

                    String symbol = location.getScene().getMapSymbol();
                    this.console.print(symbol);

                } //ELSE
                // DISPLAY " ?? "
                else {
                    this.console.print("  ??  ");
                }
                // ENDIF
                // DISPLAY ending column divider
                this.console.print("|");
                //ENDFOR
            }
            this.console.println();
            this.console.println("   -------------------------------------------------------------------------------------------------------------------------------------------");
        }
        //DISPLAY ending row divider

        //END
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewInventory() {
        //get the sorted list of inventory items
        Item[] inventory = GameControl.getSortedInventoryList();

        this.console.println("\nList of Items");
        this.console.println("\nDescription" + "\t"
                + "Required" + "\t"
                + "In Stock");

        //For each inventory item
        for (Item inventoryItem : inventory) {
            this.console.println(inventoryItem.getDescription() + "\t       "
                    + inventoryItem.getRequiredAmount() + "\t    "
                    + inventoryItem.getQuantityInStock());
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewActors() {
        this.console.println("\n*** viewActors ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewRaftStatus() {
        this.console.println("\n*** view raft status ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewLocationContents() {
        this.console.println("\n*** view location contents ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    public void movePerson() {

        Actor actor = null;
        Point coordinates = null;

        //move actor to location
        try {
            MapControl.moveActorToLocation(actor, coordinates);
        } catch (MapControlException me) {
            this.console.println(me.getMessage());
        }

        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void estimateResources() {
        int days = 16;
        int totalAmount = 0;
        try {
            totalAmount = GameControl.getTotalResources(days);
        } catch (GameControlException gc) {
            ErrorView.display(this.getClass().getName(),
                    "\nError: " + gc.getMessage());
        }
        this.console.println("You will need a total of " + totalAmount + " resources to complete the game");
//        double estimate =  GameControl.getRequiredAmount(resource, days);
//        GameMenuView gameMenu = new GameMenuView();
//        gameMenu.display();
    }

    private void viewResourceStatus() {
        GameControl.getResourceList();
        MainMenuView mainMenu = new MainMenuView();
        // display the game menu
        mainMenu.display();
    }

    private void designBarrels() {
        this.console.println("\n*** design barrels ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void constructTools() {
        this.console.println("\n*** construct tools ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void harvestResource() {
        this.console.println("\n*** harvest resource ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void deliverResource() {
        this.console.println("\n*** deliver resource ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void workOnRaft() {
        String promptMessage = null;
        RaftView volume = new RaftView(promptMessage);
        volume.display();
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void packRaft() {
        this.console.println("\n*** pack raft ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void launchRaft() {
        this.console.println("\n*** launch raft ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void help() {
        this.console.println("\n*** get help ***");
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
