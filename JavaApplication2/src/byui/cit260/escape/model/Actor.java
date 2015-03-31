/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.model;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author owner
 */
public class Actor implements Serializable {

    public static Actor[] values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // class instance variable
    private final String description;
    private final Point coordinates;
    private Actor actor;
    
    
    Actor(String description, Point coordinates) {
        this.description = description;
        this.coordinates = coordinates;
    }

    public Actor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setDescription(String description) {
    }
    //This might not supposed to be here....
    public void setActor(ActorEnum actorEnum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // I don't know if this will mess stuff up... I hope it doesn't
    public void setPoint(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setStartingPoint(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
