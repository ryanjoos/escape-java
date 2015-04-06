/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.GameControl;
import byui.cit260.escape.control.ItemControl;
import byui.cit260.escape.control.MapControl;
import byui.cit260.escape.control.RaftControl;
import byui.cit260.escape.exceptions.MapControlException;
import byui.cit260.escape.model.Actor;
import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.Location;
import byui.cit260.escape.model.Player;
import byui.cit260.escape.model.Raft;
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
                + "\nC - Construct tools"
                + "\nR - Harvest resource"
                + "\nD - Deliver resource"
                + "\nW - Work on raft"
                + "\nP - Pack raft"
                + "\nJ - Launch raft"
                + "\nH - Help"
                + "\nQ - Quit - Go to Main Menu"
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
                sbMap.append(i).append(1).append(" ");
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
                } else if ("  ~~  ".equals(mapSymbol) || "  ST  ".equals(mapSymbol) || "  FN  ".equals(mapSymbol)) {
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
                + "\tRequired" + "\t"
                + "In Stock");

        //For each inventory resource
        for (Resource inventoryResource : inventory) {
            this.console.print(inventoryResource.getType());
            this.console.printf("\t%12s", inventoryResource.getNeededAmount());
            this.console.printf("\t%12s%n", inventoryResource.getTotalAmount());
        }
        this.console.println();
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewActors() {

        Actor[] list = GameControl.getActorList();

        this.console.println("\n*** These are the Actors ***");
        this.console.println("\nList of Actors");
        this.console.println("\nName" + "\t" + "Description\t");
        this.console.println("\nLocation");

        for (Actor actorList : list) {
            this.console.println(actorList.getDescription());
            this.console.println(actorList.getStartingPoint());
        }

        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewRaftStatus() {
        Raft raft = Escape.getCurrentGame().getRaft();
        double amount = raft.getRaftStatus();
        double raftStatus = RaftControl.calcRaftStatus(amount);
        if (raftStatus < 100) {
            this.console.println("You have completed " + raftStatus + "% of the raft");
        } else {
            this.console.println("You have completed " + raftStatus + "% of the raft. "
                    + "Congratulations! It is complete. You are on your way to leaving the island.");
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewLocationContents() {

        // add actor info to location
        //Actor[] list = GameControl.getActorList();
        Actor actor = Escape.getCurrentGame().getMap().getActor();

        Point coordinates;
        Location[][] locations = Escape.getCurrentGame().getMap().getLocations();
        coordinates = Escape.getCurrentGame().getMap().getPlayer().getCoordinates();
        int row = coordinates.x;
        int column = coordinates.y;
        int amount = locations[row][column].getResource().getLocationAmount();
        Resource resource = locations[row][column].getResource();
        String resourceType = locations[row][column].getResource().getType();
        int totalAmount = resource.getTotalAmount();

//            if (locations[row][column].getPlayer().getCoordinates() == actor.getStartingPoint())
//            this.console.println(actor.getDescription());
        System.out.println("You current total amount for " + resourceType + " is " + totalAmount + ".");
        totalAmount += amount;
        locations[row][column].getResource().setTotalAmount(totalAmount);
        resource.setTotalAmount(totalAmount);

        System.out.println(resourceType + " amount at the location(" + row + ", " + column + ") is " + amount + ".");

        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    public void movePlayer() {
        Player player = null;
        Point coordinates = null;

        this.console.println("Which direction would you like to move(up,down,left,right): ");
        String movement = this.getInput().toUpperCase();

        if (null != movement) {
            switch (movement) {
                case "UP":
                    try {
                        MapControl.moveUp(player, coordinates);
                    } catch (MapControlException me) {
                        this.console.println(me.getMessage());
                    }
                    break;
                case "DOWN":
                    try {
                        MapControl.moveDown(player, coordinates);
                    } catch (MapControlException me) {
                        this.console.println(me.getMessage());
                    }
                    break;
                case "LEFT":
                    try {
                        MapControl.moveLeft(player, coordinates);
                    } catch (MapControlException me) {
                        this.console.println(me.getMessage());
                    }
                    break;
                case "RIGHT":
                    try {
                        MapControl.moveRight(player, coordinates);
                    } catch (MapControlException me) {
                        this.console.println(me.getMessage());
                    }
                    break;
                default:
                    this.console.println("Error - incorrect input. Try again!");
                    this.movePlayer();
                    break;
            }
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
        Resource[] inventory = GameControl.getSortedResourceList();
        Item[] itemInventory = GameControl.getSortedInventoryList();

        int totalAmountResource;
        int neededAmountResource;
        int totalAmountItem;
        int neededAmountItem;
        int estResource;
        int estItem;
        String itemDescription;
        String resourceDescription;

        //For each inventory resource
        for (Resource inventoryResource : inventory) {

            totalAmountResource = inventoryResource.getTotalAmount();
            neededAmountResource = inventoryResource.getNeededAmount();
            resourceDescription = inventoryResource.getType();
            estResource = neededAmountResource - totalAmountResource;
            if (estResource < 0) {
                estResource *= -1;
                this.console.println("You have over the amount you need by: " + estResource + " for the " + resourceDescription);
            } else if (estResource == 0) {
                this.console.println("You have exactly the amount you need for the " + resourceDescription);
            } else {
                this.console.println("You still need " + estResource + " for the " + resourceDescription);
            }
        }
        this.console.println();
        for (Item inventoryItem : itemInventory) {

            totalAmountItem = (int) inventoryItem.getQuantityInStock();
            neededAmountItem = (int) inventoryItem.getRequiredAmount();
            itemDescription = inventoryItem.getDescription();
            estItem = neededAmountItem - totalAmountItem;
            if (estItem < 0) {
                estItem *= -1;
                this.console.println("You have over the amount you need by: " + estItem + " for the " + itemDescription);
            } else if (estItem == 0) {
                this.console.println("You have exactly the amount you need for the " + itemDescription);
            } else {
                this.console.println("You still need " + estItem + " for the " + itemDescription);
            }
        }

        this.console.println();
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void constructTools() {
        this.console.println("\n*** construct tools ***");
        this.console.println("Wish tool do you wish to build:\n ");
        this.console.println("hammer\n");
        this.console.println("hatchet\n");
        this.console.println("spear\n");
        this.console.println("rope\n");
        this.console.println("barrell\n");
        String choice = this.getInput().toLowerCase();
        if ("hammer".equals(choice)) {
            ItemControl.makeHammer();
        } else if ("hatchet".equals(choice)) {
            ItemControl.makeHatchet();
        } else if ("spear".equals(choice)) {
            ItemControl.makeSpear();
        } else if ("rope".equals(choice)) {
            ItemControl.makeRope();
        } else if ("barrell".equals(choice)) {
            ItemControl.makeBarrell();
        }
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
        this.console.println("To deliver the resource, go to the finish location on the map (3, 8) then "
                + "choose option 'P' to pack the raft. ");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void workOnRaft() {
        Raft raft = Escape.getCurrentGame().getRaft();
        Point coordinates = Escape.getCurrentGame().getMap().getPlayer().getCoordinates();
        int row = coordinates.x;
        int column = coordinates.y;
        double volume = raft.getVolume();
        double raftStatus = raft.getRaftStatus();

        if (row == 3 && column == 8) {
            if (raftStatus == 0) {
                String promptMessage = null;
                RaftView theRaft = new RaftView(promptMessage);
                theRaft.display();
            } else {
                if (volume <= 150) {
                    RaftControl.buildRaftOne();
                    this.console.println(
                            "The volume of your specified raft will be " + volume + " cubic feet, "
                            + "and it will only fit one person.");
                }
                if (volume < 180 && volume >= 150) {
                    this.console.println(
                            "The volume of your specified raft will be " + volume + " cubic feet and can"
                            + " fit two people.");
                    RaftControl.buildRaftTwo();

                }
                if (volume == 180) {
                    this.console.println(
                            "The volume of your specified raft will be " + volume + " cubic feet and can"
                            + " fit three people.");
                    RaftControl.buildRaftThree();
                }
            }
        } else {
            this.console.println("You are not in the finish location to build the raft. View the map to find the 'FN' symbol and go there.");
        }

        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void packRaft() {
        this.console.println("\n*** pack raft ***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void launchRaft() {
        //get the sorted list of inventory items
        Resource[] inventory = GameControl.getSortedResourceList();
        Item[] itemInventory = GameControl.getSortedInventoryList();
        Raft raft = Escape.getCurrentGame().getRaft();
        double amount = raft.getRaftStatus();
        int totalAmountResource = 0;
        int neededAmountResource = 0;
        int totalAmountItem = 0;
        int neededAmountItem = 0;
        //For each inventory resource
        for (Resource inventoryResource : inventory) {

            totalAmountResource = inventoryResource.getTotalAmount();
            neededAmountResource = inventoryResource.getNeededAmount();
        }
        for (Item inventoryItem : itemInventory) {

            totalAmountItem = (int) inventoryItem.getQuantityInStock();
            neededAmountItem = (int) inventoryItem.getRequiredAmount();
        }
        if (totalAmountResource >= neededAmountResource && totalAmountItem >= neededAmountItem && amount >= 10) {
            this.console.println("Congratulations! You have won the game!! ");
            this.console.println("                                ,.        ,.      ,.\n"
                    + "                                ||        ||      ||  ()\n"
                    + " ,--. ,-. ,.,-.  ,--.,.,-. ,-.  ||-.,.  ,.|| ,-.  ||-.,. ,-. ,.,-.  ,--.\n"
                    + "//`-'//-\\\\||/|| //-||||/`'//-\\\\ ||-'||  ||||//-\\\\ ||-'||//-\\\\||/|| ((`-'\n"
                    + "||   || |||| ||||  ||||   || || ||  || /|||||| || ||  |||| |||| ||  ``.\n"
                    + "\\\\,-.\\\\-//|| || \\\\-||||   \\\\-|| ||  ||//||||\\\\-|| ||  ||\\\\-//|| || ,-.))\n"
                    + " `--' `-' `' `'  `-,|`'    `-^-``'  `-' `'`' `-^-``'  `' `-' `' `' `--'\n"
                    + "                  //          \n"
                    + "              ,-.//          \n"
                    + "              `--'    ");
        } else {
            this.console.println("Sorry, your raft is not complete. Please keep working.");
        }

        this.console.println();
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
