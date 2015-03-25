/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.RaftControl;
import byui.cit260.escape.exceptions.RaftControlException;

/**
 *
 * @author Carissa
 */
public class RaftView extends View{
    
 public RaftView(String promptMessage) {
        super("Determine how big to build the raft......");
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
        String value3;
        
        boolean result;

        do {

            this.console.println(this.getPromptMessage()); // display main menu

            this.console.println("\nWhat length would you like your raft to be: ");
            value1 = this.getInput();

            this.console.println("\nWhat width would you like your raft to be:  ");
            value2 = this.getInput();
            
            this.console.println("\nWhat height would you like your raft to be: ");
            value3 = this.getInput();
            
            String[] values = new String[3];
            values[0] = value1;
            values[1] = value2;
            values[2] = value3;

            result = this.doAction(values);

        } while (!result);
    }

    @Override
    public boolean doAction(Object obj) {
        String[] inputValues = (String[]) obj;
        double length = 0;
        double width = 0;
        double height = 0;
        
        try {
            length = Double.parseDouble(inputValues[0]);
        } catch (NumberFormatException nf) {
            System.out.println("\nYou must enter a valid number."
                    + "Try again or enter Q to quit");
        }
        try {
            width = Double.parseDouble(inputValues[1]);
        } catch (NumberFormatException nf) {
            System.out.println("\nYou must enter a valid number."
                    + "Try again or enter Q to quit");
        }
        
        try {
            height = Double.parseDouble(inputValues[2]);
        } catch (NumberFormatException nf) {
            System.out.println("\nYou must enter a valid number."
                    + "Try again or enter Q to quit");
        }

        if (length < 1) {
            System.out.println("Please enter the length you wish to build your raft: ");
            return false;
        }

        if (width < 1) {
            System.out.println("Please enter the width you wish to build your raft: ");
            return false;
        }

        if (height < 1) {
            System.out.println("Please enter the height you wish to build your raft: ");
            return false;
        }
        
        // call control function
        double result = 0;

        try {
            result = RaftControl.calcRaftSize(length, width, height);
        } catch (RaftControlException re) {
            System.out.println(re.getMessage());
        }
//display output output result

        System.out.println(
                "The volume of your specified raft will be " + result + " cubic feet");

        // call main menu
        MainMenuView mainMenu = new MainMenuView();

        mainMenu.display();

        return true;
    }
}
