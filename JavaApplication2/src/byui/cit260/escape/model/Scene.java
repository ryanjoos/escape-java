/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.model;

import byui.cit260.escape.control.MapControl;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ryanjoos
 */
public class Scene implements Serializable{
    
    //class instance variables
    private String description;
    private boolean blocked;
    private String mapSymbol;
    private double travelTime;
    
    private String icon;
    
     private SceneType sceneType;

    public Scene() {
        this.description = "\nThis is a scene in the island of escape.";
        this.blocked = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public SceneType getSceneType() {
        return sceneType;
    }

    public void setSceneType(SceneType sceneType) {
        this.sceneType = sceneType;
    }
   
    
    @Override
    public String toString() {
        return "Scene{" + "description=" + description + ", blocked=" + blocked + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.description);
        hash = 11 * hash + (this.blocked ? 1 : 0);
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
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (this.blocked != other.blocked) {
            return false;
        }
        return true;
    }
}
