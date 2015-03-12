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
 * @author ryanjoos
 */
public class CrossRiverView extends View {
    public CrossRiverView(){
    super( "\n"
            + "\n========================================================="
            + "\n======================  What next?  ====================="
            + "\n_________________________________________________________"
            + "\nYou've come to a river. The current is far too strong.   "
            + "\nIn order to be able to cross you must construct a bridge."
            + "\nWhat is your next move to safety? Quick!                 "
            + "\nL - Leave and come back later                            "            
            + "\nC - Check my resources to see if I can build             "
            + "\nB - Build the Bridge                                     "
            + "\n=========================================================");
    }

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);

        switch (choice) {

            case 'C':
                this.checkResources();
                break;
            case 'B':
                this.buildBridge();
                break;
            case 'L': 
                this.leave();
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return true;
    }

    private void checkResources() {
        System.out.println("Looks Good, Go ahead and Build the Bridge");
    }

    private void buildBridge() {
        MapControl.calcBridgeSize(10,10,1);
    }

    private void leave() {
        MapControl.calcBridgeSize(10,10,1); 
    }
}
