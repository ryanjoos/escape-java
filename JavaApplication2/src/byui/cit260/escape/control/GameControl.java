/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.exceptions.GameControlException;
import byui.cit260.escape.exceptions.MapControlException;
import byui.cit260.escape.model.Actor;
import byui.cit260.escape.model.ActorEnum;
import byui.cit260.escape.model.Constants;
import byui.cit260.escape.model.Game;
import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.ItemType;
import byui.cit260.escape.model.Location;
import byui.cit260.escape.model.Map;
import byui.cit260.escape.model.Player;
import byui.cit260.escape.model.Raft;
import byui.cit260.escape.model.Resource;
import byui.cit260.escape.model.ResourceType;
import byui.cit260.escape.model.Scene;
import byui.cit260.escape.model.SceneType;
import escapePackage.Escape;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Carissa
 */
public class GameControl {

    public static void createNewGame(Player player) throws MapControlException {

        // create new game
        Game game = new Game();
        Escape.setCurrentGame(game);

        // save the game in Escape
        game.setPlayer(player);

        // get player from esacape
        // save player in the game
        // create list of items
        Item[] itemList = GameControl.createItemList();

        // save items list in game
        game.setItem(itemList);

        Resource[] resourceList = GameControl.createResource();

        // save items list in game
        game.setResource(resourceList);

        // create raft
        Raft raft = MapControl.createRaft();

        // save raft
        game.setRaft(raft);

        // create map
        Map map = MapControl.createMap();

        // save map 
        game.setMap(map);
        //create list of actors
        Actor[] actorList = GameControl.createActorList();

        //save actors in a list in the game
        game.setActor(actorList);
        // move actors
        MapControl.moveActorsToStartingLocation(map);
    }

    public static Actor[] createActorList() {

        Actor[] list = new Actor[9];

        Actor native1 = new Actor();
        native1.setActor(ActorEnum.NativeIslander1);
        native1.setDescription("Native Islander #1, one of the natives.");
        native1.setStartingPoint(new Point(5, 9));
        native1.setFriend(true);
        list[ActorEnum.NativeIslander1.ordinal()] = native1;

        Actor native2 = new Actor();
        native2.setActor(ActorEnum.NativeIslander2);
        native2.setDescription("Native Islander #2, seems friendly");
        native2.setStartingPoint(new Point(5, 9));
        native2.setFriend(true);
        list[ActorEnum.NativeIslander2.ordinal()] = native2;

        Actor native3 = new Actor();
        native3.setActor(ActorEnum.NativeIslander3);
        native3.setDescription("Native Islander #3, another native islander");
        native3.setStartingPoint(new Point(5, 8));
        native3.setFriend(true);
        list[ActorEnum.NativeIslander3.ordinal()] = native3;

        Actor native4 = new Actor();
        native4.setActor(ActorEnum.NativeIslander4);
        native4.setDescription("Native Islander #4, a somewhat hostile native islander");
        native4.setStartingPoint(new Point(4, 9));
        native4.setFriend(true);
        list[ActorEnum.NativeIslander4.ordinal()] = native4;

        Actor chief = new Actor();
        chief.setActor(ActorEnum.NativeChief);
        chief.setDescription("The chief, the native leader");
        chief.setStartingPoint(new Point(2, 16));
        chief.setFriend(true);
        list[ActorEnum.NativeChief.ordinal()] = chief;

        Actor kale = new Actor();
        kale.setActor(ActorEnum.Kale);
        kale.setDescription("Kale, is a man");
        kale.setStartingPoint(new Point(3, 17));
        kale.setFriend(true);
        list[ActorEnum.Kale.ordinal()] = kale;

        Actor carissa = new Actor();
        carissa.setActor(ActorEnum.Carissa);
        carissa.setDescription("Carissa, is a woman");
        carissa.setStartingPoint(new Point(3, 17));
        carissa.setFriend(true);
        list[ActorEnum.Carissa.ordinal()] = carissa;

        Actor ryan = new Actor();
        ryan.setActor(ActorEnum.Ryan);
        ryan.setDescription("Ryan, is cool");
        ryan.setStartingPoint(new Point(3, 17));
        ryan.setFriend(true);
        list[ActorEnum.Ryan.ordinal()] = ryan;
       
        Actor none = new Actor();
        none.setActor(ActorEnum.None);
        none.setDescription("There are no actors here");
        none.setStartingPoint(new Point(3, 17));
        none.setFriend(true);
        list[ActorEnum.None.ordinal()] = none;
        
        return list;
    }

    private static Item[] createItemList() {

        // create array (list of items)
        Item[] invetory = new Item[Constants.NUMBER_OF_INVENTORY_ITEMS];

        Item hammer = new Item();
        hammer.setDescription("Hammer");
        hammer.setQuantityInStock(1);
        hammer.setRequiredAmount(1);
        invetory[ItemType.hammer.ordinal()] = hammer;

        Item hatchet = new Item();
        hatchet.setDescription("Hatchet");
        hatchet.setQuantityInStock(1);
        hatchet.setRequiredAmount(1);
        invetory[ItemType.hatchet.ordinal()] = hatchet;

        Item spear = new Item();
        spear.setDescription("Spear");
        spear.setQuantityInStock(1);
        spear.setRequiredAmount(1);
        invetory[ItemType.spear.ordinal()] = spear;

        Item rope = new Item();
        rope.setDescription("Rope");
        rope.setQuantityInStock(5);
        rope.setRequiredAmount(5);
        invetory[ItemType.rope.ordinal()] = rope;

        Item barrell = new Item();
        barrell.setDescription("Barrell");
        barrell.setQuantityInStock(3);
        barrell.setRequiredAmount(3);
        invetory[ItemType.barrell.ordinal()] = barrell;

        return invetory;

    }

    public static void assignResourcesToLocation(Map map, Resource[] resources) {
        Location[][] locations = map.getLocations();

        locations = setDefaultResource(locations, resources[ResourceType.nothing.ordinal()]);

        //grains
        locations[6][4].setResource(resources[ResourceType.grain.ordinal()]);
        locations[7][6].setResource(resources[ResourceType.grain.ordinal()]);
        locations[7][17].setResource(resources[ResourceType.grain.ordinal()]);
        locations[9][3].setResource(resources[ResourceType.grain.ordinal()]);
        locations[9][16].setResource(resources[ResourceType.grain.ordinal()]);
        locations[12][3].setResource(resources[ResourceType.grain.ordinal()]);
        locations[12][14].setResource(resources[ResourceType.grain.ordinal()]);

        //timber
        locations[5][13].setResource(resources[ResourceType.timber.ordinal()]);
        locations[5][15].setResource(resources[ResourceType.timber.ordinal()]);
        locations[6][12].setResource(resources[ResourceType.timber.ordinal()]);
        locations[11][4].setResource(resources[ResourceType.timber.ordinal()]);
        locations[13][8].setResource(resources[ResourceType.timber.ordinal()]);
        locations[13][10].setResource(resources[ResourceType.timber.ordinal()]);
        locations[14][4].setResource(resources[ResourceType.timber.ordinal()]);
        locations[14][12].setResource(resources[ResourceType.timber.ordinal()]);
        locations[16][7].setResource(resources[ResourceType.timber.ordinal()]);
        locations[6][13].setResource(resources[ResourceType.timber.ordinal()]);

        // fiberousPlants
        locations[3][10].setResource(resources[ResourceType.fiberousPlants.ordinal()]);
        locations[4][14].setResource(resources[ResourceType.fiberousPlants.ordinal()]);
        locations[8][5].setResource(resources[ResourceType.fiberousPlants.ordinal()]);
        locations[10][15].setResource(resources[ResourceType.fiberousPlants.ordinal()]);
        locations[11][12].setResource(resources[ResourceType.fiberousPlants.ordinal()]);
        locations[14][9].setResource(resources[ResourceType.fiberousPlants.ordinal()]);
        locations[14][15].setResource(resources[ResourceType.fiberousPlants.ordinal()]);
        locations[15][13].setResource(resources[ResourceType.fiberousPlants.ordinal()]);
        locations[16][8].setResource(resources[ResourceType.fiberousPlants.ordinal()]);

        //ore
        locations[7][9].setResource(resources[ResourceType.ore.ordinal()]);
        locations[7][10].setResource(resources[ResourceType.ore.ordinal()]);
        locations[7][12].setResource(resources[ResourceType.ore.ordinal()]);
        locations[7][13].setResource(resources[ResourceType.ore.ordinal()]);
        locations[10][8].setResource(resources[ResourceType.ore.ordinal()]);
        locations[10][14].setResource(resources[ResourceType.ore.ordinal()]);
        locations[11][14].setResource(resources[ResourceType.ore.ordinal()]);
        locations[12][8].setResource(resources[ResourceType.ore.ordinal()]);
        locations[13][11].setResource(resources[ResourceType.ore.ordinal()]);
        locations[13][13].setResource(resources[ResourceType.ore.ordinal()]);

        // water
        locations[1][10].setResource(resources[ResourceType.water.ordinal()]);
        locations[1][12].setResource(resources[ResourceType.water.ordinal()]);
        locations[2][12].setResource(resources[ResourceType.water.ordinal()]);
        locations[3][12].setResource(resources[ResourceType.water.ordinal()]);
        locations[4][9].setResource(resources[ResourceType.water.ordinal()]);
        locations[4][12].setResource(resources[ResourceType.water.ordinal()]);
        locations[5][9].setResource(resources[ResourceType.water.ordinal()]);
        locations[5][11].setResource(resources[ResourceType.water.ordinal()]);
        locations[6][7].setResource(resources[ResourceType.water.ordinal()]);
        locations[6][11].setResource(resources[ResourceType.water.ordinal()]);
        locations[9][5].setResource(resources[ResourceType.water.ordinal()]);
        locations[10][5].setResource(resources[ResourceType.water.ordinal()]);
        locations[10][7].setResource(resources[ResourceType.water.ordinal()]);
        locations[11][5].setResource(resources[ResourceType.water.ordinal()]);
        locations[11][7].setResource(resources[ResourceType.water.ordinal()]);
        locations[12][4].setResource(resources[ResourceType.water.ordinal()]);
        locations[12][7].setResource(resources[ResourceType.water.ordinal()]);
        locations[13][4].setResource(resources[ResourceType.water.ordinal()]);
        locations[13][6].setResource(resources[ResourceType.water.ordinal()]);
        locations[14][8].setResource(resources[ResourceType.water.ordinal()]);
        locations[15][10].setResource(resources[ResourceType.water.ordinal()]);
        locations[15][11].setResource(resources[ResourceType.water.ordinal()]);
        locations[17][9].setResource(resources[ResourceType.water.ordinal()]);
        locations[17][10].setResource(resources[ResourceType.water.ordinal()]);
        locations[17][12].setResource(resources[ResourceType.water.ordinal()]);
        locations[18][10].setResource(resources[ResourceType.water.ordinal()]);
        locations[18][12].setResource(resources[ResourceType.water.ordinal()]);

        // berries
        locations[2][10].setResource(resources[ResourceType.berries.ordinal()]);
        locations[4][15].setResource(resources[ResourceType.berries.ordinal()]);
        locations[4][16].setResource(resources[ResourceType.berries.ordinal()]);
        locations[6][14].setResource(resources[ResourceType.berries.ordinal()]);
        locations[7][16].setResource(resources[ResourceType.berries.ordinal()]);
        locations[8][2].setResource(resources[ResourceType.berries.ordinal()]);
        locations[8][7].setResource(resources[ResourceType.berries.ordinal()]);
        locations[11][16].setResource(resources[ResourceType.berries.ordinal()]);
        locations[13][3].setResource(resources[ResourceType.berries.ordinal()]);
        locations[16][6].setResource(resources[ResourceType.berries.ordinal()]);
        locations[16][12].setResource(resources[ResourceType.berries.ordinal()]);

        // animal
        locations[3][17].setResource(resources[ResourceType.meat.ordinal()]);
        locations[6][6].setResource(resources[ResourceType.meat.ordinal()]);
        locations[7][5].setResource(resources[ResourceType.meat.ordinal()]);
        locations[7][7].setResource(resources[ResourceType.meat.ordinal()]);
        locations[7][14].setResource(resources[ResourceType.meat.ordinal()]);
        locations[9][2].setResource(resources[ResourceType.meat.ordinal()]);
        locations[9][4].setResource(resources[ResourceType.meat.ordinal()]);
        locations[10][3].setResource(resources[ResourceType.meat.ordinal()]);
        locations[10][4].setResource(resources[ResourceType.meat.ordinal()]);
        locations[13][15].setResource(resources[ResourceType.meat.ordinal()]);
        locations[14][7].setResource(resources[ResourceType.meat.ordinal()]);
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        locations = setDefaultScene(locations, scenes[SceneType.ocean.ordinal()]);

        //start Point
        locations[0][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][5].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][6].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][7].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][8].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][9].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[0][10].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][11].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][12].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][13].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][14].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][15].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][16].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][17].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[0][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[1][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][5].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][6].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][7].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][8].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[1][10].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][11].setScene(scenes[SceneType.river.ordinal()]);
        locations[1][12].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][13].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][14].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][15].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][16].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][17].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[1][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[2][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[2][5].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[2][6].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[2][7].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[2][8].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[2][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[2][10].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[2][11].setScene(scenes[SceneType.river.ordinal()]);
        locations[2][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[2][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[2][14].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][15].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][16].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][17].setScene(scenes[SceneType.start.ordinal()]);
        locations[2][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[2][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[3][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[3][5].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[3][6].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[3][7].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[3][8].setScene(scenes[SceneType.finish.ordinal()]);
        locations[3][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[3][10].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[3][11].setScene(scenes[SceneType.bridge.ordinal()]);
        locations[3][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[3][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[3][14].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][15].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][16].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][17].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[3][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[4][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[4][5].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[4][6].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[4][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][9].setScene(scenes[SceneType.grass.ordinal()]);

        locations[4][10].setScene(scenes[SceneType.river.ordinal()]);
        locations[4][11].setScene(scenes[SceneType.river.ordinal()]);
        locations[4][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[4][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[4][14].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[4][15].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[4][16].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[4][17].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[4][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[5][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[5][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[5][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[5][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][8].setScene(scenes[SceneType.grass.ordinal()]);
        locations[5][9].setScene(scenes[SceneType.grass.ordinal()]);

        locations[5][10].setScene(scenes[SceneType.bridge.ordinal()]);
        locations[5][11].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[5][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[5][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[5][14].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[5][15].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[5][16].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[5][17].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[6][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[6][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[6][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][4].setScene(scenes[SceneType.grass.ordinal()]);
        locations[6][5].setScene(scenes[SceneType.grass.ordinal()]);
        locations[6][6].setScene(scenes[SceneType.grass.ordinal()]);
        locations[6][7].setScene(scenes[SceneType.grass.ordinal()]);
        locations[6][8].setScene(scenes[SceneType.river.ordinal()]);
        locations[6][9].setScene(scenes[SceneType.river.ordinal()]);

        locations[6][10].setScene(scenes[SceneType.river.ordinal()]);
        locations[6][11].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[6][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[6][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[6][14].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[6][15].setScene(scenes[SceneType.grass.ordinal()]);
        locations[6][16].setScene(scenes[SceneType.grass.ordinal()]);
        locations[6][17].setScene(scenes[SceneType.grass.ordinal()]);
        locations[6][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[7][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[7][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][4].setScene(scenes[SceneType.grass.ordinal()]);
        locations[7][5].setScene(scenes[SceneType.grass.ordinal()]);
        locations[7][6].setScene(scenes[SceneType.grass.ordinal()]);
        locations[7][7].setScene(scenes[SceneType.grass.ordinal()]);
        locations[7][8].setScene(scenes[SceneType.river.ordinal()]);
        locations[7][9].setScene(scenes[SceneType.jungle.ordinal()]);

        locations[7][10].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[7][11].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[7][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[7][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[7][14].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[7][15].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[7][16].setScene(scenes[SceneType.grass.ordinal()]);
        locations[7][17].setScene(scenes[SceneType.grass.ordinal()]);
        locations[7][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[8][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[8][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[8][2].setScene(scenes[SceneType.grass.ordinal()]);
        locations[8][3].setScene(scenes[SceneType.grass.ordinal()]);
        locations[8][4].setScene(scenes[SceneType.grass.ordinal()]);
        locations[8][5].setScene(scenes[SceneType.grass.ordinal()]);
        locations[8][6].setScene(scenes[SceneType.grass.ordinal()]);
        locations[8][7].setScene(scenes[SceneType.grass.ordinal()]);
        locations[8][8].setScene(scenes[SceneType.river.ordinal()]);
        locations[8][9].setScene(scenes[SceneType.cliff.ordinal()]);

        locations[8][10].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[8][11].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[8][12].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[8][13].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[8][14].setScene(scenes[SceneType.running.ordinal()]);
        locations[8][15].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[8][16].setScene(scenes[SceneType.grass.ordinal()]);
        locations[8][17].setScene(scenes[SceneType.grass.ordinal()]);
        locations[8][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[8][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[9][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[9][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[9][2].setScene(scenes[SceneType.grass.ordinal()]);
        locations[9][3].setScene(scenes[SceneType.grass.ordinal()]);
        locations[9][4].setScene(scenes[SceneType.grass.ordinal()]);
        locations[9][5].setScene(scenes[SceneType.grass.ordinal()]);
        locations[9][6].setScene(scenes[SceneType.river.ordinal()]);
        locations[9][7].setScene(scenes[SceneType.river.ordinal()]);
        locations[9][8].setScene(scenes[SceneType.river.ordinal()]);
        locations[9][9].setScene(scenes[SceneType.cliff.ordinal()]);

        locations[9][10].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[9][11].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[9][12].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[9][13].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[9][14].setScene(scenes[SceneType.grass.ordinal()]);
        locations[9][15].setScene(scenes[SceneType.grass.ordinal()]);
        locations[9][16].setScene(scenes[SceneType.grass.ordinal()]);
        locations[9][17].setScene(scenes[SceneType.grass.ordinal()]);
        locations[9][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[9][19].setScene(scenes[SceneType.ocean.ordinal()]);

        // second half
        // of the map
        // for jaba island
        locations[10][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[10][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[10][2].setScene(scenes[SceneType.grass.ordinal()]);
        locations[10][3].setScene(scenes[SceneType.grass.ordinal()]);
        locations[10][4].setScene(scenes[SceneType.grass.ordinal()]);
        locations[10][5].setScene(scenes[SceneType.grass.ordinal()]);
        locations[10][6].setScene(scenes[SceneType.river.ordinal()]);
        locations[10][7].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[10][8].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[10][9].setScene(scenes[SceneType.cliff.ordinal()]);

        locations[10][10].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[10][11].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[10][12].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[10][13].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[10][14].setScene(scenes[SceneType.grass.ordinal()]);
        locations[10][15].setScene(scenes[SceneType.grass.ordinal()]);
        locations[10][16].setScene(scenes[SceneType.grass.ordinal()]);
        locations[10][17].setScene(scenes[SceneType.grass.ordinal()]);
        locations[10][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[10][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[11][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[11][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[11][2].setScene(scenes[SceneType.grass.ordinal()]);
        locations[11][3].setScene(scenes[SceneType.grass.ordinal()]);
        locations[11][4].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[11][5].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[11][6].setScene(scenes[SceneType.bridge.ordinal()]);
        locations[11][7].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[11][8].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[11][9].setScene(scenes[SceneType.cliff.ordinal()]);

        locations[11][10].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[11][11].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[11][12].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[11][13].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[11][14].setScene(scenes[SceneType.grass.ordinal()]);
        locations[11][15].setScene(scenes[SceneType.grass.ordinal()]);
        locations[11][16].setScene(scenes[SceneType.grass.ordinal()]);
        locations[11][17].setScene(scenes[SceneType.beach.ordinal()]);
        locations[11][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[11][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[12][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[12][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[12][2].setScene(scenes[SceneType.grass.ordinal()]);
        locations[12][3].setScene(scenes[SceneType.grass.ordinal()]);
        locations[12][4].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[12][5].setScene(scenes[SceneType.river.ordinal()]);
        locations[12][6].setScene(scenes[SceneType.river.ordinal()]);
        locations[12][7].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[12][8].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[12][9].setScene(scenes[SceneType.cliff.ordinal()]);

        locations[12][10].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[12][11].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[12][12].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[12][13].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[12][14].setScene(scenes[SceneType.grass.ordinal()]);
        locations[12][15].setScene(scenes[SceneType.grass.ordinal()]);
        locations[12][16].setScene(scenes[SceneType.beach.ordinal()]);
        locations[12][17].setScene(scenes[SceneType.beach.ordinal()]);
        locations[12][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[12][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[13][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[13][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[13][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[13][3].setScene(scenes[SceneType.grass.ordinal()]);
        locations[13][4].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[13][5].setScene(scenes[SceneType.river.ordinal()]);
        locations[13][6].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[13][7].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[13][8].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[13][9].setScene(scenes[SceneType.jungle.ordinal()]);

        locations[13][10].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[13][11].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[13][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[13][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[13][14].setScene(scenes[SceneType.grass.ordinal()]);
        locations[13][15].setScene(scenes[SceneType.grass.ordinal()]);
        locations[13][16].setScene(scenes[SceneType.beach.ordinal()]);
        locations[13][17].setScene(scenes[SceneType.beach.ordinal()]);
        locations[13][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[13][19].setScene(scenes[SceneType.ocean.ordinal()]);

        // needs fixing
        locations[14][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[14][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[14][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[14][3].setScene(scenes[SceneType.grass.ordinal()]);
        locations[14][4].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][5].setScene(scenes[SceneType.river.ordinal()]);
        locations[14][6].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][7].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][8].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][9].setScene(scenes[SceneType.jungle.ordinal()]);

        locations[14][10].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][11].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][14].setScene(scenes[SceneType.grass.ordinal()]);
        locations[14][15].setScene(scenes[SceneType.grass.ordinal()]);
        locations[14][16].setScene(scenes[SceneType.beach.ordinal()]);
        locations[14][17].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[14][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[14][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[15][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[15][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[15][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[15][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[15][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[15][5].setScene(scenes[SceneType.river.ordinal()]);
        locations[15][6].setScene(scenes[SceneType.bridge.ordinal()]);
        locations[15][7].setScene(scenes[SceneType.river.ordinal()]);
        locations[15][8].setScene(scenes[SceneType.river.ordinal()]);
        locations[15][9].setScene(scenes[SceneType.river.ordinal()]);

        locations[15][10].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[15][11].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[15][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[15][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[15][14].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[15][15].setScene(scenes[SceneType.grass.ordinal()]);
        locations[15][16].setScene(scenes[SceneType.beach.ordinal()]);
        locations[15][17].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[15][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[15][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[16][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[16][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[16][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[16][3].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[16][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[16][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[16][6].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[16][7].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[16][8].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[16][9].setScene(scenes[SceneType.river.ordinal()]);

        locations[16][10].setScene(scenes[SceneType.river.ordinal()]);
        locations[16][11].setScene(scenes[SceneType.river.ordinal()]);
        locations[16][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[16][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[16][14].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[16][15].setScene(scenes[SceneType.beach.ordinal()]);
        locations[16][16].setScene(scenes[SceneType.beach.ordinal()]);
        locations[16][17].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[16][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[16][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[17][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[17][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[17][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[17][3].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[17][4].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[17][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[17][10].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][11].setScene(scenes[SceneType.river.ordinal()]);
        locations[17][12].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][13].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][14].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][15].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][16].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[17][17].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[17][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[17][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[18][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[18][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[18][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[18][3].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[18][4].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[18][5].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[18][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[18][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[18][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[18][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[18][10].setScene(scenes[SceneType.beach.ordinal()]);
        locations[18][11].setScene(scenes[SceneType.river.ordinal()]);
        locations[18][12].setScene(scenes[SceneType.beach.ordinal()]);
        locations[18][13].setScene(scenes[SceneType.beach.ordinal()]);
        locations[18][14].setScene(scenes[SceneType.beach.ordinal()]);
        locations[18][15].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[18][16].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[18][17].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[18][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[18][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[19][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][3].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][4].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][5].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][6].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][7].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][8].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][9].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[19][10].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][11].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][12].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][13].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][14].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][15].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][16].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][17].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][19].setScene(scenes[SceneType.ocean.ordinal()]);

    }
 
    public static void assignActorsToLocations(Map map, Actor[] actor) {
    Location[][] locations = map.getLocations();

    locations = setDefaultActor(locations, actor[ActorEnum.None.ordinal()]);

    locations[3][17].setActors(actor[ActorEnum.Carissa.ordinal()]);
    locations[3][17].setActors(actor[ActorEnum.Kale.ordinal()]);
    locations[3][17].setActors(actor[ActorEnum.Ryan.ordinal()]);
    locations[2][16].setActors(actor[ActorEnum.NativeChief.ordinal()]);

    }

//    public static  void findVisited (Map map, Scene[] scenes) {
//        Location[][] locations = map.getLocations();
//
//        if (scenes == SceneType.ocean.ordinal()) {
//            
//        }
//    }
    public static Item[] getSortedInventoryList() {
        // get inventory list for the current game
        Item[] originalInventoryList
                = Escape.getCurrentGame().getItem();

        // clone {make a copy} originalList
        Item[] inventoryList = originalInventoryList.clone();

        // using BubbleSort to sort the list of inventoryList by name
        Item tempInventoryItem;
        for (int i = 0; i < inventoryList.length - 1; i++) {
            for (int j = 0; j < inventoryList.length - 1 - i; j++) {
                if (inventoryList[j].getDescription().
                        compareToIgnoreCase(inventoryList[j + 1].getDescription()) > 0) {
                    tempInventoryItem = inventoryList[j];
                    inventoryList[j] = inventoryList[j + 1];
                    inventoryList[j + 1] = tempInventoryItem;
                }
            }
        }
        return inventoryList;
    }

    public static Actor[] getActorList() {
        // get actor list for the current game
        Actor[] originalActorList
                = Escape.getCurrentGame().getActor();

        // clone {make a copy} list
        Actor[] list = originalActorList.clone();

        // using BubbleSort to sort the list of list by name
        Actor tempList;
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].getDescription().
                        compareToIgnoreCase(list[j + 1].getDescription()) > 0) {
                    tempList = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tempList;
                }
            }
        }

        return list;
    }

    private static Location[][] setDefaultScene(Location[][] locations, Scene defaultScene) {
        for (int row = 0; row < locations.length; row++) {
            for (int column = 0; column < locations.length; column++) {
                locations[row][column].setScene(defaultScene);
            }
        }
        return locations;
    }
        private static Location[][] setDefaultActor(Location[][] locations, Actor defaultActors) {
        for (int row = 0; row < locations.length; row++) {
            for (int column = 0; column < locations.length; column++) {
                locations[row][column].setActors(defaultActors);
            }
        }
        return locations;
    }

    private static Location[][] setDefaultResource(Location[][] locations, Resource defaultResource) {
        for (int row = 0; row < locations.length; row++) {
            for (int column = 0; column < locations.length; column++) {
                locations[row][column].setResource(defaultResource);
            }
        }
        return locations;
    }

//    public static void getResourceList() {
//        Resource[] neededResources = Resource.values();
//
//        for (Resource neededResource : neededResources) {
//            System.out.println(neededResource + ":     \t" + neededResource.getAmount());
//        }
//    }
//
//    public static int getTotalResources(int days) throws GameControlException {
//        int totalAmount = 0;
//        // convert enum to array
//        Resource[] resources = Resource.values();
//        for (Resource resource : resources) {
//            if (days < 1 || days > 45) {
//                System.out.println("Chicken");
//                throw new GameControlException("The number of days is incorrect.");
//            } else {
//                double requiredAmount = resource.getAmount() * days;
//                totalAmount += requiredAmount;
//            }
//        }
//        return totalAmount;
//    }
    public static void saveGame(Game game, String filepath)
            throws GameControlException {

        try (FileOutputStream fops = new FileOutputStream(filepath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);

            output.writeObject(game);   // write the game object out to file
        } catch (IOException e) {
            throw new GameControlException(e.getMessage());
        }
    }

    public static void getSavedGame(String filepath)
            throws GameControlException {
        Game game = null;

        try (FileInputStream fips = new FileInputStream(filepath)) {
            ObjectInputStream output = new ObjectInputStream(fips);

            game = (Game) output.readObject();  // read the game object from file
        } catch (FileNotFoundException fnfe) {
            throw new GameControlException(fnfe.getMessage());
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }

        // close the output file
        Escape.setCurrentGame(game); // save in Escape
    }

    public static Resource[] getSortedResourceList() {
        // get inventory list for the current game
//            System.out.println("test");
        Resource[] originalResourceList
                = Escape.getCurrentGame().getResource();

        // clone {make a copy} originalList
        Resource[] resourceList = originalResourceList.clone();

        // using BubbleSort to sort the list of inventoryList by name
        Resource tempInventoryResource;
        for (int i = 0; i < resourceList.length - 1; i++) {
            for (int j = 0; j < resourceList.length - 1 - i; j++) {
                if (resourceList[j].getType().
                        compareToIgnoreCase(resourceList[j + 1].getType()) > 0) {
                    tempInventoryResource = resourceList[j];
                    resourceList[j] = resourceList[j + 1];
                    resourceList[j + 1] = tempInventoryResource;
                }
            }
        }
        return resourceList;
    }

    public static Resource[] createResource() {
        Game game = Escape.getCurrentGame();

        Resource[] resources = new Resource[ResourceType.values().length];
        // grain,
        Resource grainResource = new Resource();
        grainResource.setType("grain resource");
        grainResource.setTotalAmount(500);
        grainResource.setLocationAmount(5);
        grainResource.setNeededAmount(100);
        resources[ResourceType.grain.ordinal()] = grainResource;

        // timber,
        Resource timberResource = new Resource();
        timberResource.setType("timber resource");
        timberResource.setTotalAmount(500);
        timberResource.setLocationAmount(10);
        timberResource.setNeededAmount(0);
        resources[ResourceType.timber.ordinal()] = timberResource;

        // fiberousPlants
        Resource fiberousPlantResource = new Resource();
        fiberousPlantResource.setType("fiberous plants");
        fiberousPlantResource.setTotalAmount(500);
        fiberousPlantResource.setLocationAmount(3);
        fiberousPlantResource.setNeededAmount(0);
        resources[ResourceType.fiberousPlants.ordinal()] = fiberousPlantResource;

        // ore,
        Resource oreResource = new Resource();
        oreResource.setType("ore resource");
        oreResource.setTotalAmount(500);
        oreResource.setLocationAmount(5);
        oreResource.setNeededAmount(0);
        resources[ResourceType.ore.ordinal()] = oreResource;

        // water,
        Resource waterResource = new Resource();
        waterResource.setType("water resource");
        waterResource.setTotalAmount(500);
        waterResource.setLocationAmount(5);
        waterResource.setNeededAmount(100);
        resources[ResourceType.water.ordinal()] = waterResource;

        // berries
        Resource berriesResource = new Resource();
        berriesResource.setType("berry resource");
        berriesResource.setTotalAmount(500);
        berriesResource.setLocationAmount(5);
        berriesResource.setNeededAmount(100);
        resources[ResourceType.berries.ordinal()] = berriesResource;

        // meat
        Resource meatResource = new Resource();
        meatResource.setType("meat resource");
        meatResource.setTotalAmount(500);
        meatResource.setLocationAmount(5);
        meatResource.setNeededAmount(100);
        resources[ResourceType.meat.ordinal()] = meatResource;

        // nothing
        Resource nothingResource = new Resource();
        nothingResource.setType("no resource");
        nothingResource.setTotalAmount(100);
        nothingResource.setLocationAmount(0);
        nothingResource.setNeededAmount(0);
        resources[ResourceType.nothing.ordinal()] = nothingResource;
        return resources;
    }

}
