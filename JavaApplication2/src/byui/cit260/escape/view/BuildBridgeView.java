/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.MapControl;
import byui.cit260.escape.exceptions.MapControlException;

/**
 *
 * @author ryanjoos
 */
public class BuildBridgeView extends View {

    public BuildBridgeView(String promptMessage) {
        super("We need to build a bridge to cross the river.");
    }

    @Override
    public void display() {
        // while not done
        // display the prompt message
        // display the bridge

        // display How long will it take you to get to the safe field (minutes): "
        // call BridgeInput to get the value from the Array
        // display Please enter the various dimensions
        String length;
        String width;
        String height;
        boolean result;

        do {

            this.console.println(this.getPromptMessage()); // display main menu

            this.console.println("\nWhat is the length of the bridge? ");
            length = this.getInput();

            this.console.println("\nWhat is the width of the bridge? ");
            width = this.getInput();

            this.console.println("\nWhat is the height of the bridge? ");
            height = this.getInput();

            String[] values = new String[3];
            values[0] = length;
            values[1] = width;
            values[2] = height;

            result = this.doAction(values);

        } while (!result);
    }

    @Override
    public boolean doAction(Object obj) {
        String[] bridgeValues = (String[]) obj;
        double length = 0;
        double width = 0;
        double height = 0;
        try {
            length = Double.parseDouble(bridgeValues[0]);
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(),
                    "\nYou must enter a valid number." + "Try again or enter Q to quit");
        }
        try {
            width = Double.parseDouble(bridgeValues[1]);
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(),
                    "\nYou must enter a valid number." + "Try again or enter Q to quit");
        }
        try {
            height = Double.parseDouble(bridgeValues[2]);
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(),
                    "\nYou must enter a valid number." + "Try again or enter Q to quit");
        }

        if (length
                < 1) {
            this.console.println("Please enter the time it will take you to get to the field in minutes: ");
            return false;
        }

        if (width
                < 1) {
            this.console.println("Please enter the distance to the field in miles: ");
            return false;
        }
        if (height
                < 1) {
            this.console.println("Please enter the distance to the field in miles: ");
            return false;
        }

        // call control function
        double result = 0;

        try {            
            result = MapControl.calcBridgeSize(length, width, height);
        } catch (MapControlException me) {
            ErrorView.display(this.getClass().getName(),
                    "\nYou must enter a valid number." + "Try again or enter Q to quit" + me.getMessage());
        }
//display output output result

        this.console.println(
                "You can now access the locations on the other side of the river.");

        // call main menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();

        return true;
    }
}
