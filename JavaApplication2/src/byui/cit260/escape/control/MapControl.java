/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

/**
 *
 * @author owner
 */
public class MapControl {

    public double calculateRunningSpeed(double time, double distance) {
        if (time < 15 || time > 45) {
            return -1;
        }

        if (distance < 0.5 || distance > 2) {
            return -1;
        }

        double speedMPH = (distance/(time / 60));

        return speedMPH;
    }
}
