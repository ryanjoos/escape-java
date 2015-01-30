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
public class Scene implements Serializable{
    
    //class instance variables
    private String description;
    private boolean blocked;

    public Scene() {
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
