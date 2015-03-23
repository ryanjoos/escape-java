/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.exceptions.RaftControlException;

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
                
        if (MIN_RAFT_LENGTH < 9 || MAX_RAFT_LENGTH > 12) { //If length is between 9 and 12, you're good to go.
            throw new RaftControlException("Can't sail the raft your length is not between 9 and 12");
        }

        if (MIN_RAFT_WIDTH < 9 || MAX_RAFT_WIDTH > 15) { //If width is between 9 & 15 it works.
            throw new RaftControlException("Can't use the raft your width is not between 9 and 15");
        }

        if (MIN_RAFT_HEIGHT < 0.75 || MAX_RAFT_HEIGHT > 1) { //If height is between 0.75 and 1 then it works.
            throw new RaftControlException("Can't use the raft your height is not between 0.75 and 1");
        }

        double volume = length * width * height; //The calculations for this function

        return volume;
    }

    public double calcRaftStatus(double amount) {
        double raftStatus = 0.0;

        if (amount < 1) {
            return raftStatus;
        } 
        else if (amount <= 10 && amount > 0) {
            raftStatus = .20; 
        }
        else if (amount <= 20 && amount > 10) {
            raftStatus = .40; 
        }
        else if (amount <= 30 && amount > 20) {
            raftStatus = .60; 
        }
        else if (amount <= 40 && amount > 30) {
            raftStatus = .80; 
        }
         else if (amount <= 50 && amount >40) {
            raftStatus = 1.0; 
        }
        raftStatus *= 100;
        return raftStatus;
    }
}
