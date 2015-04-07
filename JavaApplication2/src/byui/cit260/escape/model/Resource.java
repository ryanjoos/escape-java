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
public class Resource implements Serializable {

    //class instance variables
    private String type;
    private int totalAmount;
    private int neededAmount;
    private int locationAmount;

    private ResourceType resourceType;

    public Resource(String type, int totalAmount, ResourceType resourceType, int locationAmount) {
        this.type = type;
        this.totalAmount = totalAmount;
        this.resourceType = resourceType;
        this.locationAmount = locationAmount;
    }

    public Resource() {
        this.type = "This is a resource";
        this.totalAmount = 0;
        this.neededAmount = 5;
        this.locationAmount = 5;
    }

    //getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
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

    public int getLocationAmount() {
        return locationAmount;
    }

    public void setLocationAmount(int locationAmount) {
        this.locationAmount = locationAmount;
    }

    @Override
    public String toString() {
        return "Resource{" + "type=" + type + ", totalAmount=" + totalAmount + ", neededAmount=" + neededAmount + ", locationAmount=" + locationAmount + ", resourceType=" + resourceType + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + this.totalAmount;
        hash = 53 * hash + this.neededAmount;
        hash = 53 * hash + this.locationAmount;
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
        if (this.totalAmount != other.totalAmount) {
            return false;
        }
        if (this.neededAmount != other.neededAmount) {
            return false;
        }
        if (this.locationAmount != other.locationAmount) {
            return false;
        }
        if (this.resourceType != other.resourceType) {
            return false;
        }
        return true;
    }

}
