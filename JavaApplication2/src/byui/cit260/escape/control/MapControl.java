/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.model.Game;
import byui.cit260.escape.model.Map;
import byui.cit260.escape.model.Scene;
import byui.cit260.escape.model.SceneType;
import escapePackage.Escape;
import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class MapControl {
    
    private static final int MAP_SIZE = 20;
    private static final int MIN_TIME = 15;
    private static final int MAX_TIME = 45;

    public static double calculateRunningSpeed(double time, double distance) {
        Scanner in = new Scanner(System.in);

        if (time < MIN_TIME || time > MAX_TIME) {
            System.out.println("Please enter a realistic amount of the time between 15 to 45 minutes: ");
            time = in.nextDouble();
            // error message
            // try again
        }

        if (distance < 0.5 || distance > 2) {
            System.out.println("Please enter a realistic distance between 0.5 miles to 2 miles: ");
            distance = in.nextDouble();
            // error message
            // try again
        }

        double speedMPH = (distance / (time / 60));

        return speedMPH;
    }

    public static double calcBridgeSize(double length, double width, double height) {

        if (length < 10 || length > 15) { //If length is between 10 and 15, you're good to go.
            return -1;
        }

        if (width < 4 || width > 15) { //If width is between 9 & 15 it works.
            return -1;
        }

        if (height < 0.75 || height > 1) { //If height is between 0.75 and 1 then it works.
            return -1;
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

        // assign scenes to locations
        GameControl.assignScenesToLocations(map, scenes);

        return map;
    }

    static void moveActorsToStartingLocation(Map map) {
        System.out.println("**** called moveActorsToStartingLocation() in GameControl ***");
    }

    // throws MapControlException had to take out because it wasn't working
    private static Scene[] createScenes() {
        BufferedImage image = null;

        Game game = Escape.getCurrentGame();

        Scene[] scenes = new Scene[SceneType.values().length];

        Scene startingScene = new Scene();
        startingScene.setDescription("\nYou awake and are washed up on the shore"
                + "of an unknown island.");
        startingScene.setMapSymbol("  ST  ");
        startingScene.setBlocked(false);
        startingScene.setTravelTime(240);
        ImageIcon startingSceneImage = MapControl.getImage(startingScene,
                "/citbyui/cit260/escape/image/startingPoint.jpg");
//        startingScene.setIcon(startingSceneImage);
        scenes[SceneType.start.ordinal()] = startingScene;

        Scene finishScene = new Scene();

        finishScene.setDescription(
                "\nYay, you did it. go outside");
        finishScene.setMapSymbol("  FN  ");
        finishScene.setBlocked(false);
        finishScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon finishSceneImage = MapControl.getImage(finishScene,
                "picture/path/jpg");
//        oceanScene.SetIcon(finishSceneImage);
        scenes[SceneType.finish.ordinal()] = finishScene;

//        beach("Beach scene", "***"),
        Scene beachScene = new Scene();

        beachScene.setDescription(
                "\nThis is a beach scene");
        beachScene.setMapSymbol("  **  ");
        beachScene.setBlocked(false);
        beachScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon beachSceneImage = MapControl.getImage(beachScene,
                "picture/path/jpg");
//        beachScene.SetIcon(beachSceneImage);
        scenes[SceneType.beach.ordinal()] = beachScene;

//    river("River scene", ">>>"),
        Scene riverScene = new Scene();

        riverScene.setDescription(
                "\nThis is a river scene");
        riverScene.setMapSymbol("  >>  ");
        riverScene.setBlocked(false);
        riverScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon riverSceneImage = MapControl.getImage(riverScene,
                "picture/path/jpg");
//        riverScene.SetIcon(riverSceneImage);
        scenes[SceneType.river.ordinal()] = riverScene;

//    cliff("Cliff scene", "^^^"),
        Scene cliffScene = new Scene();

        cliffScene.setDescription(
                "\nThis is a cliff scene");
        cliffScene.setMapSymbol("  ^^  ");
        cliffScene.setBlocked(false);
        cliffScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon cliffSceneImage = MapControl.getImage(cliffScene,
                "picture/path/jpg");
//        cliffScene.SetIcon(cliffSceneImage);
        scenes[SceneType.cliff.ordinal()] = cliffScene;

//    volcano("Volcano Scene", "/^\\"),
        Scene volcanoScene = new Scene();

        volcanoScene.setDescription(
                "\nThis is a volcano scene");
        volcanoScene.setMapSymbol("  /\\  ");
        volcanoScene.setBlocked(false);
        volcanoScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon volcanoSceneImage = MapControl.getImage(volcanoScene,
                "picture/path/jpg");
//        volcanoScene.SetIcon(volcanoSceneImage);
        scenes[SceneType.volcano.ordinal()] = volcanoScene;

//    jungle("Jungle scene", "###"),
        Scene jungleScene = new Scene();

        jungleScene.setDescription(
                "\nThis is a jungle scene");
        jungleScene.setMapSymbol("  ##  ");
        jungleScene.setBlocked(false);
        jungleScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon jungleSceneImage = MapControl.getImage(jungleScene,
                "picture/path/jpg");
//        jungleScene.SetIcon(jungleSceneImage);
        scenes[SceneType.jungle.ordinal()] = jungleScene;

//    timber("Timber resource scene", "$$$"),
        Scene timberScene = new Scene();

        timberScene.setDescription(
                "\nThis is a timber scene");
        timberScene.setMapSymbol("  $$  ");
        timberScene.setBlocked(false);
        timberScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon timberSceneImage = MapControl.getImage(timberScene,
                "picture/path/jpg");
//        timberScene.SetIcon(timberSceneImage);
        scenes[SceneType.timber.ordinal()] = timberScene;

//    grain("Grain resource scene", "%%%"),
        Scene grainScene = new Scene();

        grainScene.setDescription(
                "\nThis is a grain scene");
        grainScene.setMapSymbol("  %%  ");
        grainScene.setBlocked(false);
        grainScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon grainSceneImage = MapControl.getImage(grainScene,
                "picture/path/jpg");
//        grainScene.SetIcon(grainSceneImage);
        scenes[SceneType.grain.ordinal()] = grainScene;

        //    ocean("Ocean scene", "~~~"),
        Scene oceanScene = new Scene();

        oceanScene.setDescription(
                "\nThis is a ocean scene");
        oceanScene.setMapSymbol("  ~~  ");
        oceanScene.setBlocked(false);
        oceanScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon oceanSceneImage = MapControl.getImage(oceanScene,
                "picture/path/jpg");
//        oceanScene.SetIcon(oceanSceneImage);
        scenes[SceneType.ocean.ordinal()] = oceanScene;

        //    desert("desert scene", " :: "),
        Scene desertScene = new Scene();

        desertScene.setDescription(
                "\nThis is a desert scene");
        desertScene.setMapSymbol("  ::  ");
        desertScene.setBlocked(false);
        desertScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon desertSceneImage = MapControl.getImage(desertScene,
                "picture/path/jpg");
//        desertScene.SetIcon(desertSceneImage);
        scenes[SceneType.desert.ordinal()] = desertScene;

        //    running("running scene", "!!!"),
        Scene runningScene = new Scene();

        runningScene.setDescription(
                "\nThis is a running scene");
        runningScene.setMapSymbol("  !!  ");
        runningScene.setBlocked(false);
        runningScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon runningSceneImage = MapControl.getImage(runningScene,
                "picture/path/jpg");
//        runningScene.SetIcon(runningSceneImage);
        scenes[SceneType.running.ordinal()] = runningScene;

        //    grass("Grass scene", "===");
        Scene grassScene = new Scene();

        grassScene.setDescription(
                "\nThis is a grass scene");
        grassScene.setMapSymbol("  ==  ");
        grassScene.setBlocked(false);
        grassScene.setTravelTime(Double.POSITIVE_INFINITY);
        ImageIcon grassSceneImage = MapControl.getImage(grassScene,
                "picture/path/jpg");
//        grassScene.SetIcon(grassSceneImage);
        scenes[SceneType.grass.ordinal()] = grassScene;
        
        return scenes;
    }

    private static ImageIcon getImage(Scene startingScene, String citbyuicit260escapeimagestartingPointjpg) {
        System.out.println("****getImage ***** ");
        return null;
    }

    private static class MapControlException extends Exception {

        public MapControlException() {
        }
    }

    private static class ImageIcon {

        public ImageIcon() {
        }
    }
}
