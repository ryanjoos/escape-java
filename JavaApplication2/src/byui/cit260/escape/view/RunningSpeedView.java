/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.MapControl;
import byui.cit260.escape.exceptions.MapControlException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carissa
 */
public class RunningSpeedView extends View {

    public RunningSpeedView(String promptMessage) {
        super("Determine how fast to run......");
    }

    @Override
    public void display() {
        // while not done
        // display the prompt message

        // display How long will it take you to get to the safe field (minutes): "
        // call getInput to get the value
        // display Please enter the time it will take you to get to the field in minutes:
        // call getINput to get the next value
        // call doAction
        String value1;
        String value2;
        boolean result;

        do {

            System.out.println(this.getPromptMessage()); // display main menu

            System.out.println("\nHow long will it take you to get to the safe field (minutes): ");
            value1 = this.getInput();

            System.out.println("\nWhat is the distance to the field (miles): ");
            value2 = this.getInput();

            String[] values = new String[2];
            values[0] = value1;
            values[1] = value2;

            result = this.doAction(values);

        } while (!result);
    }

    @Override
    public boolean doAction(Object obj) {
        String[] inputValues = (String[]) obj;
        double time = Double.parseDouble(inputValues[0]);
        double distance = Double.parseDouble(inputValues[1]);

        if (time < 1) {
            System.out.println("Please enter the time it will take you to get to the field in minutes: ");
            return false;
        }

        if (distance < 1) {
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
        System.out.println("You are going to run " + result + " mph to get to the next location.");

        // call main menu
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();

        return true;
    }
}
