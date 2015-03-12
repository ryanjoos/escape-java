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
public class Item implements Serializable{
    // class instance variables
    private ItemType itemType;
    
    // add variables
    // amount collecged
    // Quant of stock
    // decrip
    
    
    
    // default constructor
    public Item() {
    }

    // getter function
    public ItemType getItemType() {
        return itemType;
    }
    // setter function
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
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

    public void setDescription(String timber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setQuantityInStock(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRequiredAmount(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
