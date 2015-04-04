/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.ItemType;
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
        Item[] item = Escape.getCurrentGame().getItem(); 
        
            //
        //System.out.println(inventoryResource.getTotalAmount());
            if (resource[ResourceType.ore.ordinal()].getTotalAmount() >= 5 && resource[ResourceType.timber.ordinal()].getTotalAmount() >= 5) {
                double total = item[ItemType.hammer.ordinal()].getQuantityInStock();
                total++;
                item[ItemType.hammer.ordinal()].setQuantityInStock((int) total);
                System.out.println(item[ItemType.hammer.ordinal()].getQuantityInStock());
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
