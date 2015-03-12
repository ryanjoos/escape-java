/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.model;

import java.io.Serializable;

/**
 *
 * @author owner
 */
public class Map implements Serializable{
    // class instance variables
    private int rowCount;
    private int columnCount;
    private Location[][] locations;

    // default constructor
    public Map() {
        this.rowCount = 0;
        this.columnCount = 0;
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
