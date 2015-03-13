/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.model;

import byui.cit260.escape.control.GameControl;
import java.io.Serializable;

/**
 *
 * @author owner
 */
public class Map implements Serializable{

    private static Scene[] createScenes() throws MapControlException {
        BufferedImage image = null;
        
        Game game = Escape.getCurrentGame();
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene startingScene = newScene();
        startingScene.setDescription("\nYou awake and are washed up on the shore"
                + "of an unknown island.");
        startingScene.setMapSymbol(" ST ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        ImageIcon startingSceneImage = MapControl.getImage(startingScene,
                "/citbyui/cit260/escape/image/startingPoint.jpg");
        startingScene.setIcon(startingSceneImage);
        scenes[SceneType.start.ordinal[]] = startingScene;
        
        Scene finishScene = new Scene();
        
        finishScene.setDescription(
        "\nYay, you did it. go outside");
        finishScene.setMapSymbol(" FN ");
        finishScene.setBlocked(false);
        finishScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon finishSceneImage = MapControl.getImage(finishScene,
                "picture/path/jpg");
                finishScene.SetIcon(finishSceneImage);
        scenes[SceneType.finish.ordinal()] = finishscene;
        
       
        
    }
    // class instance variables
    private int rowCount;
    private int columnCount;
    private Location[][] locations;

    // default constructor
    public Map() {

    }

    public Map(int noOfRows, int noOfColumns) {
       if (noOfRows  <1 || noOfColumns < 1){
           System.out.println("The number of rows and columns must be > zero");
           return;
       }
        this.rowCount = 0;
        this.columnCount = 0;
        
        //create a 2-D array for Location objects
        this.locations = new Location[noOfRows][noOfColumns];
        
        for (int row=0; row < noOfRows; row++) {
            for(int column = 0; column < noOfColumns; column++){
                 //create and initi
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setVisited(false);
                
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

    private static Map createMap(){
        Map map = new Map(20,20);
        
        //create the scenes for the game
        Scene[] scenes = createScenes();
        
        GameControl.assignScenesToLocations(map,scenes);
        
        return map;
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
