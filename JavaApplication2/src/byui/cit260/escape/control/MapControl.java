/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.model.Map;
import byui.cit260.escape.view.View;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class MapControl {

    public static double calculateRunningSpeed(double time, double distance) {
        Scanner in = new Scanner(System.in);
        
        if (time < 15 || time > 45) {
            System.out.println("Please enter a realistic amount of the time between 15 to 45 minutes: ");
            time = in.nextDouble();
            // error message
            // try again
        }

        if (distance < 0.5 || distance > 2) {
            System.out.println("Please enter a realistic distance between 0.5 miles to 2 miles: ");
            distance = in.nextDouble();
            // error message
            // try again
        }

        double speedMPH = (distance/(time / 60));

        return speedMPH;
    }

    
    public static double calcBridgeSize(double length, double width, double height){
        
        if (length < 10 || length >15){ //If length is between 10 and 15, you're good to go.
        return -1;
        }
        
        if (width < 4 || width > 15){ //If width is between 9 & 15 it works.
        return -1;
        }
        
        if (height < 0.75 || height > 1){ //If height is between 0.75 and 1 then it works.
        return -1;
        }
        
        double bridgevolume = length * width * height; //The calculations for this function

        return bridgevolume;   
    }

    static Map createMap() {
        System.out.println("**** call createMap() in MapControl ***");
        return null;
    }

    static void moveActorsToStartingLocation(Map map) {
        System.out.println("**** called moveActorsToStartingLocation() in GameControl ***");
    }
}
