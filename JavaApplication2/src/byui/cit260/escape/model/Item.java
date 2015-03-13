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
 * @author owner
 */
// change this to enum
public class Item implements Serializable {

    // class instance variables
    private ItemType itemType;

    // add variables
    private int quantityInStock;     // amount collected
    private int requiredAmount;      // amount needed
    private String description;      // decription

    // default constructor
    public Item() {
        this.quantityInStock = 0;
        this.requiredAmount = 0;
        this.description = "\n This is an item.";
    }

    // getter function
    public ItemType getItemType() {
        return itemType;
    }

    // setter function
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" + "itemType=" + itemType + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.itemType);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.itemType, other.itemType)) {
            return false;
        }
        return true;
    }

}
