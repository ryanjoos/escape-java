/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.GameControl;
import byui.cit260.escape.control.MapControl;
import byui.cit260.escape.exceptions.MapControlException;
import byui.cit260.escape.model.Actor;
import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.Location;
import byui.cit260.escape.model.Player;
import byui.cit260.escape.model.Resource;
import escapePackage.Escape;
import java.awt.Point;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Carissa
 */
public class GameMenuView extends View {

    private char[][] map = null;

    public GameMenuView() {
        // f,g,k,u,x,y,z
        super("   ,(   ,(   ,(   ,(   ,(   ,(   ,(   ,(\n"
                + "`-'  `-'  `-'  `-'  `-'  `-'  `-'  `-'  `\n"
                + "   ,(   ,(   ,(   ,(   ,(   ,(   ,(   ,(\n"
                + "`-'  `-'  `-'  `-'  `-'  `-'  `-'  `-'  `"
                + "\n"
                + "\n========================================="
                + "\n=============  Game Menu  ==============="
                + "\n_________________________________________"
                + "\nV - View Map"
                + "\nT - Print map report"
                + "\nI - View list of items and resources in inventory"
                + "\nA - View list of actors"
                + "\nS - View raft status"
                + "\nL - View contents of location"
                + "\nM - Move to new location"
                + "\nN - Move character to new location"
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
                this.displayMap(this.console);
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.display();
                break;
            case 'T':
                this.printMap();
                break;
            case 'I':
                this.viewInventory();
                this.viewResourceInventory();
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
                this.movePlayer();
            case 'N':
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

    public void displayMap(PrintWriter out) {
        String map = buildDisplayMap();
        out.println(map);
        //END
    }

    private String buildDisplayMap() {
        // get the map locations from the current game
        Location[][] locations = Escape.getCurrentGame().getMap().getLocations();

        StringBuilder sbMap = new StringBuilder();

        // display title
        sbMap.append("                                                                    Jaba Island Map                                                         \n");
        sbMap.append("\n");

        // display row of column numbers
        sbMap.append("      1      2      3      4      5      6     7      8      9      10     11     12     13     14     15     16     17     18     19     20");
        sbMap.append("\n");
        // DISPLAY row divider
        sbMap.append("   -------------------------------------------------------------------------------------------------------------------------------------------");
        sbMap.append("\n");
// DISPLAY row number
        // FOR every column in row
        // DISPLAY column divider
        for (int i = 0; i < 20; i++) {
            if (i < 9) {
                sbMap.append(i + 1 + " ");
            } else {
                sbMap.append(i + 1);
            }
            sbMap.append("|");
            for (int j = 0; j < 20; j++) {
                // location = location[row][column]
                Location location = locations[i][j];
                // IF location has been visited
                // DISPLAY the map symbol for location
                Point playerCoordinates = locations[i][j].getPlayer().getCoordinates();
                String symbol = location.getScene().getMapSymbol();
                String mapSymbol = locations[i][j].getScene().getMapSymbol();

                if (playerCoordinates.x == i && playerCoordinates.y == j) {
                    // could get player's name
                    locations[i][j].setVisited(true);
                    sbMap.append("  X   ");
                } else if (locations[i][j].isVisited() == true) {
                    sbMap.append(symbol);
                } else if (mapSymbol == "  ~~  " || mapSymbol == "  ST  " || mapSymbol == "  FN  ") {
                    sbMap.append(locations[i][j].getScene().getMapSymbol());
                } // ELSE DISPLAY " ?? "
                else {
                    sbMap.append("  ??  ");
                }

                // ENDIF
                // DISPLAY ending column divider
                sbMap.append("|");
                //ENDFOR
            }
            sbMap.append("\n");
            sbMap.append("   -------------------------------------------------------------------------------------------------------------------------------------------");
            sbMap.append("\n");
        }
        //DISPLAY ending row divider

        return sbMap.toString();
    }

    private void printMap() {
        try {
            // prompt for and get the name of the file to print a report of the current map
            this.console.println("\n\nEnter the file path of the file where the map report"
                    + "is to be saved.");

            String filePath = this.getInput();
            PrintWriter out = new PrintWriter(filePath);
            this.displayMap(out);
            out.flush();
//            this.displayMap(out);
        } catch (IOException exc) {
            ErrorView.display("GameMenuView ", "error printing map to file " + exc.getMessage());
        } catch (Exception ex) {
            ErrorView.display("GameMenuView", ex.getMessage());
        }
    }

    private void viewInventory() {
        //get the sorted list of inventory items
        Item[] inventory = GameControl.getSortedInventoryList();

        this.console.println("\nList of Items");
        this.console.println("\nDescription" + "\t   "
                + "Required" + "     "
                + ""
                + " \t "
                + "In Stock");

        //For each inventory item
        for (Item inventoryItem : inventory) {
            this.console.println(inventoryItem.getDescription() + "\t\t     "
                    + inventoryItem.getRequiredAmount() + "\t           "
                    + inventoryItem.getQuantityInStock());
        }
    }

    private void viewResourceInventory() {
        //get the sorted list of inventory items
        Resource[] inventory = GameControl.getSortedResourceList();

        this.console.println("\nList of resources");
        this.console.println("\nType" + "   \t  \t"
                + "Required" + "\t"
                + "In Stock");

        //For each inventory resource
        for (Resource inventoryResource : inventory) {
            this.console.print(inventoryResource.getType());
            this.console.printf("\t%12s", inventoryResource.getNeededAmount());
            this.console.printf("\t%12s%n", inventoryResource.getTotalAmount());
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewActors() {

        Actor[] list = GameControl.getActorList();

        this.console.println("\n*** These are the Actors ***");
        this.console.println("\nList of Actors");
        this.console.println("\nName" + "\t" + "Description");

        for (Actor actorList : list) {
            this.console.println(actorList.getDescription());
        }

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

    public void movePlayer() {
        Player player = null;
        Point coordinates = null;

        this.console.println("Which direction would you like to move(up,down,left,right): ");
        String movement = this.getInput().toUpperCase();
        this.console.println(movement);

        if ("UP".equals(movement)) {
            try {
                MapControl.moveUp(player, coordinates);
            } catch (MapControlException me) {
                this.console.println(me.getMessage());
            }
        } else if ("DOWN".equals(movement)) {
            try {
                MapControl.moveDown(player, coordinates);
            } catch (MapControlException me) {
                this.console.println(me.getMessage());
            }
        } else if ("LEFT".equals(movement)) {
            try {
                MapControl.moveLeft(player, coordinates);
            } catch (MapControlException me) {
                this.console.println(me.getMessage());
            }
        } else if ("RIGHT".equals(movement)) {
            try {
                MapControl.moveRight(player, coordinates);
            } catch (MapControlException me) {
                this.console.println(me.getMessage());
            }
        } else {
            this.console.println("Error - incorrect input. Try again!");
            this.movePlayer();
        }
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
//        int days = 16;
//        int totalAmount = 0;
//        try {
//            totalAmount = GameControl.getTotalResources(days);
//        } catch (GameControlException gc) {
//            ErrorView.display(this.getClass().getName(),
//                    "\nError: " + gc.getMessage());
//        }
//        this.console.println("You will need a total of " + totalAmount + " resources to complete the game");
//        double estimate =  GameControl.getRequiredAmount(resource, days);
//        GameMenuView gameMenu = new GameMenuView();
//        gameMenu.display();
    }

    private void viewResourceStatus() {
//        GameControl.getResourceList();
//        MainMenuView mainMenu = new MainMenuView();
//        // display the game menu
//        mainMenu.display();
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
        Point coordinates = null;
        this.console.println("\nDo you want to gether the resource? (yes/no)\n");
        String choice = this.getInput().toLowerCase();
        if ("yes".equals(choice)) {
            MapControl.harvestResources(coordinates);
        } 
        
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
