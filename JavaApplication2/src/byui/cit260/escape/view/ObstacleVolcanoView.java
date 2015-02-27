/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.MapControl;
import java.util.Scanner;

/**
 *
 * @author Carissa
 */
public class ObstacleVolcanoView {

    private final String SCENARIO = "\n"
            + "\n========================================================="
            + "\n======================  What next  ======================"
            + "\n_________________________________________________________"
            + "\nYou just entered your new location when the volcano      "
            + "\nMt. Wannahockaloogie starts to emit smoke causing the    "
            + "\nisland to shake. Although the volcano is not yet ready,  "
            + "\nthis volcano precursor eruption is causing an avalanch   "
            + "\nto occur. You must get to safty immediately. You spot an "
            + "\nfield free of falling rocks and trees, but you may not   "
            + "\nhave enouth time to reach it before the avalanch comes.  "
            + "\nWhat is your next move to safety? Quick!                 "
            + "\nC - Climb a large, strudy tree                           "
            + "\nR - Run quickly to the next location                     "
            + "\nH - Hide behind a boulder                                "
            + "\nP - Find safety at previous location                     "
            + "\nS - Stay where you are and die                           "
            + "\n=========================================================";

    public void displayMenu() {

        char selection = ' ';
        do {

            System.out.println(SCENARIO); // display main menu

            String input = this.getInput();
            selection = input.charAt(0);

            this.doAction(selection);

        } while (selection != 'S');
    }

    private String getInput() {
        boolean valid = false; //Indicates if the name has be retrieved 
        String inputValue = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream

        while (!valid) { //While a valid name has not been retrieved

            //Prompt for User name
            System.out.println("\nPick your next move: ");

            //get the name from the keyboard and trim off the branks
            inputValue = keyboard.nextLine();
            inputValue = inputValue.trim().toUpperCase();

            //If the name is invalid
            if (inputValue.length() < 1) {
                System.out.println("Invalid move. Please try another move: ");
                continue; // and repeat again
            }
            break; // stop the do while thingy
        }
        return inputValue;
    }

    private void doAction(char choice) {

        switch (choice) {
            case 'C':
                this.climbOption();
                break;
            case 'R':
                this.runOption();
                break;
            case 'H':
                this.hideOption();
                break;
            case 'P':
                this.retreatOption();
                break;
            case 'S':    
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
    }

    private void climbOption() {
        System.out.println("As soon as you were about to run to the tree, ");
        System.out.println("it became uprooted and feel to the ground");
        System.out.println("Choose your next move quick!");
    }

    private void runOption() {
        System.out.println("These are just fake values until the runningSpeedView is created");
//        MapControl.calculateRunningSpeed(RunningSpeedView , 1.5);
        
        RunningSpeedView runningInput = new RunningSpeedView();
        double timeInput = RunningSpeedView.getTimeInput();
        double distanceInput = RunningSpeedView.getDistanceInput();
        runningInput.getRunningSpeed(timeInput, distanceInput);
        //runningInput.getTimeInput();
        // runningInput.getDistanceInput();
        //runningInput.getRunningSpeed(time, distance);
    }

    private void hideOption() {
        System.out.println("Unfortunately, the earthquake cause the large ");
        System.out.println("boulder to roll down into the forest. ");
        System.out.println("Your only choice of shleter is now gone ");
        System.out.println("Choose your next move quick!");
    }

    private void retreatOption() {
        System.out.println("As you turn around to retreat, you notice ");
        System.out.println("the earthquake caused the water to rise in the ");
        System.out.println("river and the location is temporarily blocked. ");
        System.out.println("Choose your next move quick!");
    }

//    private void stayOption() {
//        System.out.println("You are dead...");
//    }

}
