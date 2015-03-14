/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.GameControl;
import byui.cit260.escape.model.Item;

/**
 *
 * @author Carissa
 */
public class GameMenuView extends View {

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
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return true;
    }

    private void displayMap() {
//        System.out.println("\n*** displayMap ***");
        // get the map locations from the current game
        
        // display title
        
        // display row of column numbers
        
        // FOR every row in map
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
    }

    private void viewActors() {
        System.out.println("\n*** viewActors ***");
    }

    private void viewRaftStatus() {
        System.out.println("\n*** view raft status ***");
    }

    private void viewLocationContents() {
        System.out.println("\n*** view location contents ***");
    }

    private void movePerson() {
        System.out.println("\n*** move person ***");
    }

    private void estimateResources() {
        System.out.println("\n*** estimate resources ***");
    }

    private void designBarrels() {
        System.out.println("\n*** design barrels ***");
    }

    private void constructTools() {
        System.out.println("\n*** construct tools ***");
    }

    private void harvestResource() {
        System.out.println("\n*** harvest resource ***");
    }

    private void deliverResource() {
        System.out.println("\n*** deliver resource ***");
    }

    private void workOnRaft() {
        System.out.println("\n*** work on raft ***");
    }

    private void packRaft() {
        System.out.println("\n*** pack raft ***");
    }

    private void launchRaft() {
        System.out.println("\n*** launch raft ***");
    }

    private void help() {
        System.out.println("\n*** get help ***");
    }

}
