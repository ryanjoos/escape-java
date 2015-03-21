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
public class BuildBridgeView extends View{

     public BuildBridgeView(String promptMessage) {
        super("Determine how fast to run......");
    }

    @Override
    public void display() {
        // while not done
        // display the prompt message

        // display How long will it take you to get to the safe field (minutes): "
        // call BridgeInput to get the value from the Array
        // display Please enter the various dimensions
        String length;
        String width;
        String height;
        boolean result;

        do {

            System.out.println(this.getPromptMessage()); // display main menu

            System.out.println("\nHWhat is the length of the bridge? ");
            length = this.getInput();

            System.out.println("\nWhat is the width of the bridge? ");
            width = this.getInput();
            
            System.out.println("\nWhat is the height of the bridge? ");
            height = this.getInput();            

            String[] values = new String[2];
            values[0] = length;
            values[1] = width;
            values[2] = height;

            result = this.doAction(values);

        } while (!result);
    }

    @Override
    public boolean doAction(Object obj) {
        String[] bridgeValues = (String[]) obj;
        double time = 0;
        double distance = 0;
        try {
            time = Double.parseDouble(bridgeValues[0]);
        } catch (NumberFormatException nf) {
            System.out.println("\nYou must enter a valid number."
                    + "Try again or enter Q to quit");
        }
        try {
            distance = Double.parseDouble(bridgeValues[1]);
        } catch (NumberFormatException nf) {
            System.out.println("\nYou must enter a valid number."
                    + "Try again or enter Q to quit");
        }

        if (time
                < 1) {
            System.out.println("Please enter the time it will take you to get to the field in minutes: ");
            return false;
        }

        if (distance
                < 1) {
            System.out.println("Please enter the distance to the field in miles: ");
            return false;
        }

        // call control function
        double result = 0;

        try {
            result = MapControl.calculateRunningSpeed(time, distance);
        } catch (MapControlException me) {
            System.out.println(me.getMessage());
        }
//display output output result

        System.out.println(
                "You are going to run " + result + " mph to get to the next location.");

        // call main menu
        MainMenuView mainMenu = new MainMenuView();

        mainMenu.display();

        return true;
    }
}
