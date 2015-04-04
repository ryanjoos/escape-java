/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.exceptions.MapControlException;
import byui.cit260.escape.model.Actor;
import byui.cit260.escape.model.Game;
import byui.cit260.escape.model.Location;
import byui.cit260.escape.model.Map;
import byui.cit260.escape.model.Player;
import byui.cit260.escape.model.Resource;
import byui.cit260.escape.model.Scene;
import byui.cit260.escape.model.SceneType;
import escapePackage.Escape;
import java.awt.Point;

/**
 *
 * @author owner
 */
public class MapControl {

    private static final int MAP_SIZE = 20;
    private static final double MIN_TIME = 15;
    private static final double MAX_TIME = 45;
    private static final double MAX_BRIDGE_LENGTH = 15;
    private static final double MIN_BRIDGE_LENGTH = 10;
    private static final double MAX_BRIDGE_WIDTH = 15;
    private static final double MIN_BRIDGE_WIDTH = 4;
    private static final double MAX_BRIDGE_HEIGHT = 0.75;
    private static final double MIN_BRIDGE_HEIGHT = 1;

    public static double calculateRunningSpeed(double time, double distance) throws MapControlException {

        if (time < MIN_TIME || time > MAX_TIME) {
            throw new MapControlException("Please enter a realistic amount "
                    + "of the time between 15 to 45 minutes: ");
//            System.out.println("Please enter a realistic amount of the time between 15 to 45 minutes: ");
//            time = in.nextDouble();
            // error message
            // try again
        }

        if (distance < 0.5 || distance > 2) {
            throw new MapControlException("Please enter a realistic distance between "
                    + "0.5 miles to 2 miles: ");
//            System.out.println("Please enter a realistic distance between 0.5 miles to 2 miles: ");
//            distance = in.nextDouble();
            // error message
            // try again
        }

        double speedMPH = (distance / (time / 60));

        return speedMPH;
    }

    public static double calcBridgeSize(double length, double width, double height) throws MapControlException {

        if (MIN_BRIDGE_LENGTH < 10 || MAX_BRIDGE_LENGTH > 15) { //If length is between 10 and 15, you're good to go.
            throw new MapControlException("Please enter a realistic length between 10 to 15 ft");
        }

        if (MIN_BRIDGE_WIDTH < 4 || MAX_BRIDGE_WIDTH > 15) { //If width is between 9 & 15 it works.
            throw new MapControlException("Please enter a realistic width between 4 to 15 ft");
        }

        if (MIN_BRIDGE_HEIGHT < 0.75 || MAX_BRIDGE_HEIGHT > 1) { //If height is between 0.75 and 1 then it works.
            throw new MapControlException("Please enter a realistic height between o.75 to 1 ft");
        }

        double bridgevolume = length * width * height; //The calculations for this function

        return bridgevolume;
    }

    // pg 16.
    public static Map createMap() {
        // create and initilalize new map
        Map map = new Map(MAP_SIZE, MAP_SIZE);

        //create the scenes for the game
        Scene[] scenes = createScenes();
        Resource[] resources = Escape.getCurrentGame().getResource();

        // assign scenes to locations
        GameControl.assignScenesToLocations(map, scenes);
        GameControl.assignResourcesToLocation(map, resources);

        return map;
    }

    public static void moveUp(Player player, Point coordinates)
            throws MapControlException {

        Map map = Escape.getCurrentGame().getMap();
        Location[][] locations = Escape.getCurrentGame().getMap().getLocations();
        Point newCoordinates = Escape.getCurrentGame().getMap().getPlayer().getCoordinates();
        int newRow = newCoordinates.x - 1;
        int newColumn = newCoordinates.y;
        newCoordinates = new Point(newRow, newColumn);

        Location location = locations[newRow][newColumn];
        String scene = location.getScene().getDescription();
        System.out.println("You are at location (" + newRow + ", " + newColumn + "). " + scene);
        if (location.getScene().isBlocked() == false) {
            locations[newRow][newColumn].getPlayer().setCoorinates(newCoordinates);
            locations[newRow][newColumn].setVisited(true);
            System.out.println("The resources are: " + locations[newRow][newColumn].getResource().getType());
        } else if (newColumn < 0 || newColumn >= map.getColumnCount()) {
            throw new MapControlException("Can not move actor to location "
                    + coordinates.x + ", " + coordinates.y
                    + " because that location is outside "
                    + "the bounds of the map.");
        } else {
            System.out.println("This location is blocked. Please pick a new location to move to matey or choose another option from the Game Menu! ");
            System.out.println();
        }
    }

    public static void moveDown(Player player, Point coordinates)
            throws MapControlException {

        Map map = Escape.getCurrentGame().getMap();
        Location[][] locations = Escape.getCurrentGame().getMap().getLocations();
        Point newCoordinates = Escape.getCurrentGame().getMap().getPlayer().getCoordinates();
        int newRow = newCoordinates.x + 1;
        int newColumn = newCoordinates.y;
        newCoordinates = new Point(newRow, newColumn);

        Location location = locations[newRow][newColumn];
        String scene = location.getScene().getDescription();
        System.out.println("You are at location (" + newRow + ", " + newColumn + "). " + scene);
        if (location.getScene().isBlocked() == false) {
            locations[newRow][newColumn].getPlayer().setCoorinates(newCoordinates);
            locations[newRow][newColumn].setVisited(true);
            System.out.println("The resources are: " + locations[newRow][newColumn].getResource().getType());
        } else if (newColumn < 0 || newColumn >= map.getColumnCount()) {
            throw new MapControlException("Can not move actor to location "
                    + coordinates.x + ", " + coordinates.y
                    + " because that location is outside "
                    + "the bounds of the map.");
        } else {
            System.out.println("This location is blocked. Please pick a new location to move to matey or choose another option from the Game Menu! ");
            System.out.println();
        }
    }

    public static void moveRight(Player player, Point coordinates)
            throws MapControlException {

        Map map = Escape.getCurrentGame().getMap();
        Location[][] locations = Escape.getCurrentGame().getMap().getLocations();
        Point newCoordinates = Escape.getCurrentGame().getMap().getPlayer().getCoordinates();
        int newRow = newCoordinates.x;
        int newColumn = newCoordinates.y + 1;
        newCoordinates = new Point(newRow, newColumn);

        Location location = locations[newRow][newColumn];
        String scene = location.getScene().getDescription();
        System.out.println("You are at location (" + newRow + ", " + newColumn + "). " + scene);
        if (location.getScene().isBlocked() == false) {
            locations[newRow][newColumn].getPlayer().setCoorinates(newCoordinates);
            locations[newRow][newColumn].setVisited(true);
            System.out.println("The resources are: " + locations[newRow][newColumn].getResource().getType());
        } else if (newColumn < 0 || newColumn >= map.getColumnCount()) {
            throw new MapControlException("Can not move actor to location "
                    + coordinates.x + ", " + coordinates.y
                    + " because that location is outside "
                    + "the bounds of the map.");
        } else {
            System.out.println("This location is blocked. Please pick a new location to move to matey or choose another option from the Game Menu! ");
            System.out.println();
        }
    }

    public static void moveLeft(Player player, Point coordinates)
            throws MapControlException {

        Map map = Escape.getCurrentGame().getMap();
        Location[][] locations = Escape.getCurrentGame().getMap().getLocations();
        Point newCoordinates = Escape.getCurrentGame().getMap().getPlayer().getCoordinates();
        int newRow = newCoordinates.x;
        int newColumn = newCoordinates.y - 1;
        newCoordinates = new Point(newRow, newColumn);

        Location location = locations[newRow][newColumn];
        String scene = location.getScene().getDescription();
        System.out.println("You are at location (" + newRow + ", " + newColumn + "). " + scene);
        if (location.getScene().isBlocked() == false) {
            locations[newRow][newColumn].getPlayer().setCoorinates(newCoordinates);
            locations[newRow][newColumn].setVisited(true);
            System.out.println("The resources are: " + locations[newRow][newColumn].getResource().getType());
        } else if (newColumn < 0 || newColumn >= map.getColumnCount()) {
            throw new MapControlException("Can not move actor to location "
                    + coordinates.x + ", " + coordinates.y
                    + " because that location is outside "
                    + "the bounds of the map.");
        } else {
            System.out.println("This location is blocked. Please pick a new location to move to matey or choose another option from the Game Menu! ");
            System.out.println();
        }
    }

    public static void moveActorToLocation(Actor actor, Point coordinates)
            throws MapControlException {

        Map map = Escape.getCurrentGame().getMap();
        int newRow = coordinates.x - 1;
        int newColumn = coordinates.y - 1;

        if (newRow < 0 || newRow >= map.getRowCount()
                || newColumn < 0 || newColumn >= map.getColumnCount()) {
            throw new MapControlException("Can not move actor to location "
                    + coordinates.x + ", " + coordinates.y
                    + " because that location is outside "
                    + "the bounds of the map.");
        }
    }

    public static void moveActorsToStartingLocation(Map map)
            throws MapControlException {
        
        Actor[] actors = Escape.getCurrentGame().getActor();
        
        
        
        
        //Go through the Actor Array and get the information about the various actors in it
        
        
        for (Actor actor : actors) {
            Point coordinates = actor.getCoordinates();
            MapControl.moveActorToLocation(actor, coordinates);
            System.out.println(actor);
        }  
    }

    // throws MapControlException had to take out because it wasn't working
    private static Scene[] createScenes() {

        Game game = Escape.getCurrentGame();

        Scene[] scenes = new Scene[SceneType.values().length];

        Scene startingScene = new Scene();
        startingScene.setDescription("\nYou awake and are washed up on the shore"
                + "of an unknown island.");
        startingScene.setMapSymbol("  ST  ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        scenes[SceneType.start.ordinal()] = startingScene;

        Scene finishScene = new Scene();

        finishScene.setDescription(
                "\nYay, you did it. go outside");
        finishScene.setMapSymbol("  FN  ");
        finishScene.setBlocked(false);
        finishScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.finish.ordinal()] = finishScene;

//        beach("Beach scene", "***"),
        Scene beachScene = new Scene();

        beachScene.setDescription(
                "\nThis is a beach scene");
        beachScene.setMapSymbol("  **  ");
        beachScene.setBlocked(false);
        beachScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.beach.ordinal()] = beachScene;

//    river("River scene", ">>>"),
        Scene riverScene = new Scene();

        riverScene.setDescription(
                "\nThis is a river scene");
        riverScene.setMapSymbol("  >>  ");
        riverScene.setBlocked(true);
        riverScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.river.ordinal()] = riverScene;

//    cliff("Cliff scene", "^^^"),
        Scene cliffScene = new Scene();

        cliffScene.setDescription(
                "\nThis is a cliff scene");
        cliffScene.setMapSymbol("  ^^  ");
        cliffScene.setBlocked(false);
        cliffScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.cliff.ordinal()] = cliffScene;

//    volcano("Volcano Scene", "/^\\"),
        Scene volcanoScene = new Scene();

        volcanoScene.setDescription(
                "\nThis is a volcano scene");
        volcanoScene.setMapSymbol("  /\\  ");
        volcanoScene.setBlocked(true);
        volcanoScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.volcano.ordinal()] = volcanoScene;

//    jungle("Jungle scene", "###"),
        Scene jungleScene = new Scene();

        jungleScene.setDescription(
                "\nThis is a jungle scene");
        jungleScene.setMapSymbol("  ##  ");
        jungleScene.setBlocked(false);
        jungleScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.jungle.ordinal()] = jungleScene;

//    timber("Timber resource scene", "$$$"),
        Scene timberScene = new Scene();

        timberScene.setDescription(
                "\nThis is a timber scene");
        timberScene.setMapSymbol("  $$  ");
        timberScene.setBlocked(false);
        timberScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.timber.ordinal()] = timberScene;

//    grain("Grain resource scene", "%%%"),
        Scene grainScene = new Scene();

        grainScene.setDescription(
                "\nThis is a grain scene");
        grainScene.setMapSymbol("  %%  ");
        grainScene.setBlocked(false);
        grainScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.grain.ordinal()] = grainScene;

        //    ocean("Ocean scene", "~~~"),
        Scene oceanScene = new Scene();

        oceanScene.setDescription(
                "\nThis is a ocean scene");
        oceanScene.setMapSymbol("  ~~  ");
        oceanScene.setBlocked(true);
        oceanScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.ocean.ordinal()] = oceanScene;

        //    bridge("desert scene", " :: "),
        Scene bridgeScene = new Scene();

        bridgeScene.setDescription(
                "\nThis is a bridge scene");
        bridgeScene.setMapSymbol("  ==  ");
        bridgeScene.setBlocked(false);
        bridgeScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.bridge.ordinal()] = bridgeScene;

        //    running("running scene", "!!!"),
        Scene runningScene = new Scene();

        runningScene.setDescription(
                "\nThis is a running scene");
        runningScene.setMapSymbol("  !!  ");
        runningScene.setBlocked(false);
        runningScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.running.ordinal()] = runningScene;

        //    grass("Grass scene", "===");
        Scene grassScene = new Scene();

        grassScene.setDescription(
                "\nThis is a grass scene");
        grassScene.setMapSymbol("  ::  ");
        grassScene.setBlocked(false);
        grassScene.setTravelTime(Double.POSITIVE_INFINITY);
        scenes[SceneType.grass.ordinal()] = grassScene;

        return scenes;
    }

    public static void harvestResources(Point coordinates) {
        Location[][] locations = Escape.getCurrentGame().getMap().getLocations();
        coordinates = Escape.getCurrentGame().getMap().getPlayer().getCoordinates();
        int row = coordinates.x;
        int column = coordinates.y;
        int amount = locations[row][column].getResource().getLocationAmount();
        Resource resource = locations[row][column].getResource();
        System.out.println(resource);
        String resourceType = locations[row][column].getResource().getType();
        int totalAmount = resource.getTotalAmount();
        
        System.out.println("You current total amount for " + resourceType + " is " + totalAmount + ".");
        totalAmount += amount;
        locations[row][column].getResource().setTotalAmount(totalAmount);
        resource.setTotalAmount(totalAmount);

        System.out.println(resourceType + " amount at the location(" + row + ", " + column + ") is " + amount + ".");
        System.out.println("After harvesting the " + resourceType + " you now have a total of " + totalAmount + ".");
    }
}
