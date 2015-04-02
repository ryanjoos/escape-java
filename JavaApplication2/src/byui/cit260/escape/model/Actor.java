/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author owner
 */
public class Actor implements Serializable {
    
    // class instance variable
    private Actor actor;
    
    //add variables
    private String description;
    private Point coordinates;
    
    // default constructor
    public Actor() {
    this.coordinates = new Point(1,1);
    this.description = "\n This is an item.";
    }
    //getters
    public Actor getActor() {
    return actor;
    }
    // setter function
    public void setActor(Actor actor) {
    this.actor = actor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setActor(ActorEnum actorEnum) {
        
    }

    public void setStartingPoint(int i, int i0) {
        this.coordinates = new Point(1,1);
    }

    public Point getCoordinates() {
        return coordinates;
    }
    //hashcode and equals and tostring and a bunch of other stuff I do not understand
    @Override
    public String toString() {
        return "Actor{" + "actor=" + actor + ", description=" + description + ", coordinates=" + coordinates + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.actor);
        hash = 61 * hash + Objects.hashCode(this.description);
        hash = 61 * hash + Objects.hashCode(this.coordinates);
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
        final Actor other = (Actor) obj;
        if (!Objects.equals(this.actor, other.actor)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.coordinates, other.coordinates)) {
            return false;
        }
        return true;
    }
}
