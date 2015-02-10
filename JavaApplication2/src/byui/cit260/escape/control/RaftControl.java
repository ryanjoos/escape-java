/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

/**
 *
 * @author ryanjoos
 */
public class RaftControl {
    
    public double calcRaftSize(double length, double width, double height){
        
        if (length < 9 || length >12){ //If length is between 9 and 12, you're good to go.
        return -1;
        }
        
        if (width < 9 || width > 15){ //If width is between 9 & 15 it works.
        return -1;
        }
        
        if (height < 0.75 || height > 1){ //If height is between 0.75 and 1 then it works.
        return -1;
        }
        
        double volume = length * width * height; //The calculations for this function

        return volume;   
    }
}
