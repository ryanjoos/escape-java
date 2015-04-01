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
    private int neededAmount; 
    
    private ResourceType resourceType;

    public Resource(String type, int amount, ResourceType resourceType) {
        this.type = type;
        this.amount = amount;
        this.resourceType = resourceType;
    }
    
    public Resource() {
        this.type = null;
        this.amount = 5;
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

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public int getNeededAmount() {
        return neededAmount;
    }

    public void setNeededAmount(int neededAmount) {
        this.neededAmount = neededAmount;
    }

    @Override
    public String toString() {
        return "Resource{" + "type=" + type + ", amount=" + amount + ", neededAmount=" + neededAmount + ", resourceType=" + resourceType + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + this.amount;
        hash = 53 * hash + this.neededAmount;
        hash = 53 * hash + Objects.hashCode(this.resourceType);
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
        if (this.neededAmount != other.neededAmount) {
            return false;
        }
        if (this.resourceType != other.resourceType) {
            return false;
        }
        return true;
    }


    
    
}
