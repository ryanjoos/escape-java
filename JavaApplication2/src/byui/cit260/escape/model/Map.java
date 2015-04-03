/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.model;

import escapePackage.Escape;
import java.io.Serializable;

/**
 *
 * @author owner
 */
public class Map implements Serializable {

    // class instance variables
    private int rowCount;
    private int columnCount;
    private Location[][] locations;
    private boolean visited; 
    private Scene scene;
    private Player player; 
    private Resource resource;
    

    // default constructor
    public Map() {

    }

    public Map(int rowCount, int columnCount) {
        player = Escape.getPlayer();
        
        if (rowCount < 1 || columnCount < 1) {
            System.out.println("The number of rows and columns must be > zero");
            return;
        }

        this.rowCount = rowCount;
        this.columnCount = columnCount;

        //create a 2-D array for Location objects
        this.locations = new Location[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                //create and initialize new Location object instance
                Location location = new Location(row, column, visited, scene, player, resource);
//                location.setColumn(column);
//                location.setRow(row);
//                location.setVisited(false);

                //assign the Location object to the current position in array
                locations[row][column] = location;
            }
        }
    }

    // rowCount getter function
    public int getRowCount() {
        return rowCount;
    }

    // rowCount setter function
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    // columnCount getter function
    public int getColumnCount() {
        return columnCount;
    }

    // rowCount setter function
    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
    
    

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.rowCount;
        hash = 29 * hash + this.columnCount;
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
        final Map other = (Map) obj;
        if (this.rowCount != other.rowCount) {
            return false;
        }
        if (this.columnCount != other.columnCount) {
            return false;
        }
        return true;
    }
}
