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
            case 'V':
                this.displayMap();
                break;
            case 'I':
                this.viewInventory();
                break;
            case 'A':
                this.viewActors();
                break;
            case 'R':
                this.ViewRaftStatus();
                break;
            case 'E':    // Exit the program
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return true; 
    }

    private void displayMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void viewInventory() {
        //get the sorted list of inventory items
        Item[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\nList of Items");
        System.out.println("\nDescription" + "\t" +
                "Required" + "\t" + 
                "In Stock");
        
        //For each inventory item
        for (Item inventoryItem : inventory){
            System.out.println(inventoryItem.getDescription() + "\t" +
                    inventoryItem.getRequiredAmount() + "\t" +
                    inventoryItem.getQuantityInStock());
        }
    }

    private void viewActors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ViewRaftStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
