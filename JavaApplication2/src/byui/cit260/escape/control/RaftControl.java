/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.exceptions.RaftControlException;
import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.ItemType;
import byui.cit260.escape.model.Raft;
import byui.cit260.escape.model.Resource;
import byui.cit260.escape.model.ResourceType;
import escapePackage.Escape;

/**
 *
 * @author ryanjoos
 */
public class RaftControl {

    private static final double MAX_RAFT_LENGTH = 12;
    private static final double MIN_RAFT_LENGTH = 9;
    private static final double MAX_RAFT_WIDTH = 15;
    private static final double MIN_RAFT_WIDTH = 9;
    private static final double MAX_RAFT_HEIGHT = 1;
    private static final double MIN_RAFT_HEIGHT = 0.75;

    public static double calcRaftSize(double length, double width, double height) throws RaftControlException {
        Raft raft = Escape.getCurrentGame().getRaft();

        if (MIN_RAFT_LENGTH < 9 || MAX_RAFT_LENGTH > 12) { //If length is between 9 and 12, you're good to go.
            throw new RaftControlException("Can't sail the raft your length is not between 9 and 12");
        }

        if (MIN_RAFT_WIDTH < 9 || MAX_RAFT_WIDTH > 15) { //If width is between 9 & 15 it works.
            throw new RaftControlException("Can't use the raft your width is not between 9 and 15");
        }

        if (MIN_RAFT_HEIGHT < 0.75 || MAX_RAFT_HEIGHT > 1) { //If height is between 0.75 and 1 then it works.
            throw new RaftControlException("Can't use the raft your height is not between 0.75 and 1");
        }
        raft.setLength(length);
        raft.setWidth(width);
        raft.setHeight(height);

        double volume = length * width * height; //The calculations for this function

        return volume;
    }

    public static void buildRaftOne() {
        Raft raft = Escape.getCurrentGame().getRaft();
        Resource[] resource = Escape.getCurrentGame().getResource();
        Item[] item = Escape.getCurrentGame().getItem();
        double status = raft.getRaftStatus();

        if (resource[ResourceType.timber.ordinal()].getTotalAmount() >= 5 && item[ItemType.rope.ordinal()].getQuantityInStock() >= 1
                && item[ItemType.hatchet.ordinal()].getQuantityInStock() >= 1 && item[ItemType.hammer.ordinal()].getQuantityInStock() >= 1) {
            int numTimber = resource[ResourceType.timber.ordinal()].getTotalAmount();
            status++;
            raft.setRaftStatus(status);
            numTimber -= 5;

            // set and get number of items in stock 
            resource[ResourceType.timber.ordinal()].setTotalAmount(numTimber);
            System.out.println(resource[ResourceType.timber.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.timber.ordinal()].getTotalAmount()
                    + " in stock.");

        } else {
            System.out.println("Sorry, you don't have enough resources. Keep collecting timber and/or make a hatchet, rope, and hammer.");
        }
    }

    public static void buildRaftTwo() {
        Raft raft = Escape.getCurrentGame().getRaft();
        Resource[] resource = Escape.getCurrentGame().getResource();
        Item[] item = Escape.getCurrentGame().getItem();
        double status = raft.getRaftStatus();

        if (resource[ResourceType.timber.ordinal()].getTotalAmount() >= 10 && item[ItemType.rope.ordinal()].getQuantityInStock() >= 2
                && item[ItemType.hatchet.ordinal()].getQuantityInStock() >= 1 && item[ItemType.hammer.ordinal()].getQuantityInStock() >= 1) {
            int numTimber = resource[ResourceType.timber.ordinal()].getTotalAmount();
            status++;
            raft.setRaftStatus(status);
            numTimber -= 10;

            // set and get number of items in stock 
            resource[ResourceType.timber.ordinal()].setTotalAmount(numTimber);
            System.out.println(resource[ResourceType.timber.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.timber.ordinal()].getTotalAmount()
                    + " in stock.");

        } else {
            System.out.println("Sorry, you don't have enough resources. Keep collecting timber and/or make a hatchet, rope, and hammer.");
        }
    }

    public static void buildRaftThree() {
        Raft raft = Escape.getCurrentGame().getRaft();
        Resource[] resource = Escape.getCurrentGame().getResource();
        Item[] item = Escape.getCurrentGame().getItem();
        double status = raft.getRaftStatus();

        if (resource[ResourceType.timber.ordinal()].getTotalAmount() >= 15 && item[ItemType.rope.ordinal()].getQuantityInStock() >= 2
                && item[ItemType.hatchet.ordinal()].getQuantityInStock() >= 1 && item[ItemType.hammer.ordinal()].getQuantityInStock() >= 1) {
            int numTimber = resource[ResourceType.timber.ordinal()].getTotalAmount();
            status++;
            raft.setRaftStatus(status);
            numTimber -= 15;

            // set and get number of items in stock 
            resource[ResourceType.timber.ordinal()].setTotalAmount(numTimber);
            System.out.println(resource[ResourceType.timber.ordinal()].getType() + " now  has a total amount of " + resource[ResourceType.timber.ordinal()].getTotalAmount()
                    + " in stock.");

        } else {
            System.out.println("Sorry, you don't have enough resources. Keep collecting timber and/or make a hatchet, rope, and hammer.");
        }
    }

    public static double calcRaftStatus(double amount) {
        double raftStatus = 0.0;

        if (amount < 1) {
            return raftStatus;
        } else if (amount == 1) {
            raftStatus = .10;
        } else if (amount == 2) {
            raftStatus = .20;
        } else if (amount == 3) {
            raftStatus = .30;
        } else if (amount == 4) {
            raftStatus = .40;
        } else if (amount == 5) {
            raftStatus = .50;
        } else if (amount == 6) {
            raftStatus = .60;
        } else if (amount == 7) {
            raftStatus = .70;
        } else if (amount == 8) {
            raftStatus = .80;
        } else if (amount == 9) {
            raftStatus = .90;
        } else if (amount == 10) {
            raftStatus = 1.0;
        }
        raftStatus *= 100;
        return raftStatus;
    }
}
