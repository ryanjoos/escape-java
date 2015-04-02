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
public enum Actor implements Serializable {

    NativeIslander1("A native to the island who builds for the tribe", new Point(1,1)),
    NativeIslander2("A native to the island who is mated with the builder", new Point(1,1)),
    NativeIslander3("A native to the island who hunts for the tribe", new Point(1,1)),
    NativeIslander4("A native to the island who is considered the medicine man", new Point(1,1)),
    NativeChief    ("Chief of the islanders of Jaba Island", new Point(1,1)),
    Kale           ("An injured crew member who lays at the beach", new Point(1,1)),
    Carissa        ("Another injured crew member", new Point(1,1)),
    Ryan           ("Injured crew member who tries to keep peace between the islander and the crew", new Point(1,1));
    

    // class instance variable
    private final String description;
    private final Point coordinates;
    private Actor actor;
    
    
    Actor(String description, Point coordinates) {
        this.description = description;
        this.coordinates = coordinates;
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
