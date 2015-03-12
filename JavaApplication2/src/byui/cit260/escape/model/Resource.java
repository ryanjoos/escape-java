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
public class Resource implements Serializable{
    
    //class instance variables
    private String type;
    private int amount;

    public Resource() {
        this.type = null;
        this.amount = 0;
    }
    
    
    //getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Resource{" + "type=" + type + ", amount=" + amount + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + this.amount;
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
        final Resource other = (Resource) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        return true;
    }    
    
    
    
}
