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
public class RunningSpeedView {
    
    
//        public void displayInput() {
//
//        double runningInput = 0.0;
//        runningInput = this.getTimeInput();
//    }
//        
        
    public static double getTimeInput() {
        boolean valid = false; //Indicates if the name has be retrieved 
        double inputTimeValue = 0.0;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream

        while (!valid) { //While a valid number has not been retrieved

            //Prompt for User name
            System.out.println("\nHow long will it take you to get to the safe field (minutes): ");
           
//            inputTimeValue = keyboard.nextLine();
//            inputTimeValue = inputTimeValue.trim();

            //If the name is invalid
            if (inputTimeValue < 1) {
                System.out.println("Please enter the time it will take you to get to the field in minutes: ");
                continue; // and repeat again
            } 
            break; // stop the do while thingy
        }
        return inputTimeValue;
    }
    
        public static double getDistanceInput() {
        boolean valid = false; //Indicates if the name has be retrieved 
        double inputDistanceValue = 0.0;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream

        while (!valid) { //While a valid number has not been retrieved

            //Prompt for User name
            System.out.println("\nWhat is the distance to the field (miles): ");

            //If the name is invalid
            if (inputDistanceValue < 1) {
                System.out.println("Please enter the distance to the field in miles: ");
                continue; // and repeat again
            } 
            break; // stop the do while thingy
        }
        return inputDistanceValue;
    }
        
    public void getRunningSpeed(double inputTimeValue, double inputDistanceValue) {
        MapControl.calculateRunningSpeed(inputTimeValue, inputDistanceValue);
    }
}
