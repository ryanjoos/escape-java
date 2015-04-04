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
        Resource[] resource = Escape.getCurrentGame().getResource();
        Item[] item = Escape.getCurrentGame().getItem();

        if (resource[ResourceType.ore.ordinal()].getTotalAmount() >= 5 && resource[ResourceType.timber.ordinal()].getTotalAmount() >= 5) {
            double total = item[ItemType.hammer.ordinal()].getQuantityInStock();
            int numOre = resource[ResourceType.ore.ordinal()].getTotalAmount();
            int numTimber = resource[ResourceType.timber.ordinal()].getTotalAmount();

            total++;
            numOre -= 5;
            numTimber -= 5;

            // set and get number of items in stock 
            item[ItemType.hammer.ordinal()].setQuantityInStock((int) total);
            System.out.println("You now have " + item[ItemType.hammer.ordinal()].getQuantityInStock() + " hammer(s) in you Item Inventory,");

            // set and get resources in stock
            resource[ResourceType.ore.ordinal()].setTotalAmount(numOre);
            System.out.println(resource[ResourceType.ore.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.ore.ordinal()].getTotalAmount()
                    + " in stock.");
            resource[ResourceType.timber.ordinal()].setTotalAmount(numTimber);
            System.out.println(resource[ResourceType.timber.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.timber.ordinal()].getTotalAmount()
                    + " in stock.");
            System.out.println("Choose option 'I' in the Game Menu view to see the item and resource inventory lists.");
        } else {
            System.out.println("You do not have enough resources to make a hammer.");
        }
    }

    public static void makeHatchet() {
        Resource[] resource = Escape.getCurrentGame().getResource();
        Item[] item = Escape.getCurrentGame().getItem();

        if (resource[ResourceType.ore.ordinal()].getTotalAmount() >= 10 && resource[ResourceType.timber.ordinal()].getTotalAmount() >= 5) {
            double total = item[ItemType.hatchet.ordinal()].getQuantityInStock();
            int numOre = resource[ResourceType.ore.ordinal()].getTotalAmount();
            int numTimber = resource[ResourceType.timber.ordinal()].getTotalAmount();

            total++;
            numOre -= 10;
            numTimber -= 5;

            // set and get number of items in stock 
            item[ItemType.hatchet.ordinal()].setQuantityInStock((int) total);
            System.out.println("You now have " + item[ItemType.hatchet.ordinal()].getQuantityInStock() + " hatchet(s) in you Item Inventory,");

            // set and get resources in stock
            resource[ResourceType.ore.ordinal()].setTotalAmount(numOre);
            System.out.println(resource[ResourceType.ore.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.ore.ordinal()].getTotalAmount()
                    + " in stock.");
            resource[ResourceType.timber.ordinal()].setTotalAmount(numTimber);
            System.out.println(resource[ResourceType.timber.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.timber.ordinal()].getTotalAmount()
                    + " in stock.");
            System.out.println("Choose option 'I' in the Game Menu view to see the item and resource inventory lists.");
        } else {
            System.out.println("You do not have enough resources to make a hatchet.");
        }
    }

    public static void makeSpear() {
        Resource[] resource = Escape.getCurrentGame().getResource();
        Item[] item = Escape.getCurrentGame().getItem();

        if (resource[ResourceType.ore.ordinal()].getTotalAmount() >= 5 && resource[ResourceType.timber.ordinal()].getTotalAmount() >= 10) {
            double total = item[ItemType.spear.ordinal()].getQuantityInStock();
            int numOre = resource[ResourceType.ore.ordinal()].getTotalAmount();
            int numTimber = resource[ResourceType.timber.ordinal()].getTotalAmount();

            total++;
            numOre -= 5;
            numTimber -= 10;

            // set and get number of items in stock 
            item[ItemType.spear.ordinal()].setQuantityInStock((int) total);
            System.out.println("You now have " + item[ItemType.spear.ordinal()].getQuantityInStock() + " spear(s) in you Item Inventory,");

            // set and get resources in stock
            resource[ResourceType.ore.ordinal()].setTotalAmount(numOre);
            System.out.println(resource[ResourceType.ore.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.ore.ordinal()].getTotalAmount()
                    + " in stock.");
            resource[ResourceType.timber.ordinal()].setTotalAmount(numTimber);
            System.out.println(resource[ResourceType.timber.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.timber.ordinal()].getTotalAmount()
                    + " in stock.");
            System.out.println("Choose option 'I' in the Game Menu view to see the item and resource inventory lists.");
        } else {
            System.out.println("You do not have enough resources to make a spear.");
        }
    }

    public static void makeRope() {
        Resource[] resource = Escape.getCurrentGame().getResource();
        Item[] item = Escape.getCurrentGame().getItem();

        if (resource[ResourceType.fiberousPlants.ordinal()].getTotalAmount() >= 20) {
            double total = item[ItemType.rope.ordinal()].getQuantityInStock();
            int numFiberousPlants = resource[ResourceType.fiberousPlants.ordinal()].getTotalAmount();

            total++;
            numFiberousPlants -= 20;

            // set and get number of items in stock 
            item[ItemType.rope.ordinal()].setQuantityInStock((int) total);
            System.out.println("You now have " + item[ItemType.rope.ordinal()].getQuantityInStock() + " rope(s) in you Item Inventory,");

            // set and get resources in stock
            resource[ResourceType.fiberousPlants.ordinal()].setTotalAmount(numFiberousPlants);
            System.out.println(resource[ResourceType.fiberousPlants.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.fiberousPlants.ordinal()].getTotalAmount()
                    + " in stock.");
            System.out.println("Choose option 'I' in the Game Menu view to see the item and resource inventory lists.");
        } else {
            System.out.println("You do not have enough resources to make a rope.");
        }
    }

    public static void makeBarrell() {
        Resource[] resource = Escape.getCurrentGame().getResource();
        Item[] item = Escape.getCurrentGame().getItem();

        if (resource[ResourceType.ore.ordinal()].getTotalAmount() >= 20 && resource[ResourceType.timber.ordinal()].getTotalAmount() >= 40) {
            double total = item[ItemType.barrell.ordinal()].getQuantityInStock();
            int numOre = resource[ResourceType.ore.ordinal()].getTotalAmount();
            int numTimber = resource[ResourceType.timber.ordinal()].getTotalAmount();

            total++;
            numOre -= 20;
            numTimber -= 40;

            // set and get number of items in stock 
            item[ItemType.barrell.ordinal()].setQuantityInStock((int) total);
            System.out.println("You now have " + item[ItemType.barrell.ordinal()].getQuantityInStock() + " barrell(s) in you Item Inventory,");

            // set and get resources in stock
            resource[ResourceType.ore.ordinal()].setTotalAmount(numOre);
            System.out.println(resource[ResourceType.ore.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.ore.ordinal()].getTotalAmount()
                    + " in stock.");
            resource[ResourceType.timber.ordinal()].setTotalAmount(numTimber);
            System.out.println(resource[ResourceType.timber.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.timber.ordinal()].getTotalAmount()
                    + " in stock.");
            System.out.println("Choose option 'I' in the Game Menu view to see the item and resource inventory lists.");
        } else {
            System.out.println("You do not have enough resources to make a barrell.");
        }
    }
}
