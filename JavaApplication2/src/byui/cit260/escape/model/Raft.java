/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ryanjoos
 */
public class Raft implements Serializable{
    
    //class instance variables
    private double raftStatus;
    private String description;
    private double width;
    private double length;
    private double height;
    

    public Raft() {
        this.description = "\nThis is the raft of Escape."
                + "\nIf you are lucky you may escape!";
        this.width = 0;
        this.length = 0;
        this.height = 0;
        this.raftStatus = 0;
    }

    
    public double getRaftStatus() {
        return raftStatus;
    }

    public void setRaftStatus(double raftStatus) {
        this.raftStatus = raftStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Raft{" + "raftStatus=" + raftStatus + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.raftStatus) ^ (Double.doubleToLongBits(this.raftStatus) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Raft other = (Raft) obj;
        if (Double.doubleToLongBits(this.raftStatus) != Double.doubleToLongBits(other.raftStatus)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
