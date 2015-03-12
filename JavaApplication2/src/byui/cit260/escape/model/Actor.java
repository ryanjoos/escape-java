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

    Kale("The best"),
    Carissa("The second best"),
    Ryan("The last best");

    // class instance variable
    private final String description;
    private final Point coordinates;

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    Actor(String description) {
        this.description = description;
        coordinates = new Point(1, 1);
    }

}
