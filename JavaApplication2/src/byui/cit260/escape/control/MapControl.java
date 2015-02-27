/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.view.RunningSpeedView;

/**
 *
 * @author owner
 */
public class MapControl {

    public static double calculateRunningSpeed(double time, double distance) {
        if (time < 15 || time > 45) {
            return -1;
        }

        if (distance < 0.5 || distance > 2) {
            return -1;
        }

        double speedMPH = (distance/(time / 60));

        return speedMPH;
    }

    
    public double calcBridgeSize(double length, double width, double height){
        
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
}
