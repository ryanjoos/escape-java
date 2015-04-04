/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.model.Resource;
import byui.cit260.escape.model.ResourceType;
import escapePackage.Escape;

/**
 *
 * @author ryanjoos
 */
public class ItemControl {

    public static void makeHammer() {
        System.out.println("Make hammer");
        Resource[] resource = Escape.getCurrentGame().getResource();

            //
        //System.out.println(inventoryResource.getTotalAmount());
            if (resource[ResourceType.ore.ordinal()].getTotalAmount() >= 5 && resource[ResourceType.timber.ordinal()].getTotalAmount() >= 5) {
                System.out.println("you made a hammer bitch");
            } else {
                System.out.println("You do not have enough resources to make a hammer.");
            }

    }

    public static void makeHatchet() {
        System.out.println("Make hatchet");
    }

    public static void makeSpear() {
        System.out.println("Make spear");
    }

    public static void makeRope() {
        System.out.println("Make rope");
    }

    public static void makeBarrell() {
        System.out.println("Make barrell");
    }
}
