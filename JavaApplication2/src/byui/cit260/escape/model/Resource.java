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
public enum Resource implements Serializable{
    
    grain(5),
    timber(10),
    fiberousPlants(8),
    ore(3),
    water(5),
    food(4);
    
    //class instance variables
    private String type;
    private final int amount;

    Resource(int amount) {
        this.amount = amount;
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
  
    
    
    
}
