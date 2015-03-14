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
public enum Actor implements Serializable {

    NativeIslander1("A native to the island who builds for the tribe"),
    NativeIslander2("A native to the island who is mated with the builder"),
    NativeIslander3("A native to the island who hunts for the tribe"),
    NativeIslander4("A native to the island who is considered the medicine man"),
    NativeChief    ("Chief of the islanders of Jaba Island"),
    Kale           ("An injured crew member who lays at the beach"),
    Carissa        ("Another injured crew member"),
    Ryan           ("Injured crew member who tries to keep peace between the islander and the crew");
    

    // class instance variable
    private final String description;
    private final Point coordinates;
    
    
    Actor(String description) {
        this.description = description;
        coordinates = new Point(1, 1);
    }

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }

}
