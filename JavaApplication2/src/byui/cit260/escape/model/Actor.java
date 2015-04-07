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
    //private Actor actor;
    //add variables
    private String description;
    private Point coordinates;
    private Point startingPoint;

    private ActorEnum actorEnum;

    // default constructor
    public Actor() {
        this.coordinates = new Point(2, 17);
        this.description = "\n This is an Actor.";
    }

    public Actor(String description, ActorEnum actorEnum) {
        this.description = description;
        this.actorEnum = actorEnum;
    }
    //getters
//    public Actor getActor() {
//    return actor;
//    }
//    // setter function
//    public void setActor(Actor actor) {
//    this.actor = actor;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActor(ActorEnum actorEnum) {

    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Point startingPoint) {
        this.startingPoint = startingPoint;
    }

//    public void setStartingPoint(int i, int i0) {
//        this.coordinates = new Point(2, 17);
//    }
    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public ActorEnum getActorEnum() {
        return actorEnum;
    }

    public void setActorEnum(ActorEnum actorEnum) {
        this.actorEnum = actorEnum;
    }

    @Override
    public String toString() {
        return "Actor{" + "description=" + description + ", coordinates=" + coordinates + ", actorEnum=" + actorEnum + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.coordinates);
        hash = 79 * hash + Objects.hashCode(this.actorEnum);
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
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.coordinates, other.coordinates)) {
            return false;
        }
        if (this.actorEnum != other.actorEnum) {
            return false;
        }
        return true;
    }
}
