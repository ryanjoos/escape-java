/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.model.Constants;
import byui.cit260.escape.model.Game;
import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.ItemType;
import byui.cit260.escape.model.Location;
import byui.cit260.escape.model.Map;
import byui.cit260.escape.model.Player;
import byui.cit260.escape.model.Raft;
import byui.cit260.escape.model.Scene;
import byui.cit260.escape.model.SceneType;
import escapePackage.Escape;

/**
 *
 * @author Carissa
 */
public class GameControl {

    public static void createNewGame(Player player) {

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

        // create raft
        Raft raft = new Raft();

        // save raft
        game.setRaft(raft);

        // create map
        Map map = MapControl.createMap();

        // save map 
        game.setMap(map);

        // move actors
        MapControl.moveActorsToStartingLocation(map);
    }

    private static Item[] createItemList() {

        // create array (list of items)
        Item[] invetory = new Item[Constants.NUMBER_OF_INVENTORY_ITEMS];

        Item timber = new Item();
        timber.setItemType(ItemType.timber);
        timber.setDescription("Timber");
        timber.setQuantityInStock(0);
        timber.setRequiredAmount(0);
        invetory[ItemType.timber.ordinal()] = timber;

        Item ore = new Item();
        ore.setDescription("Ore");
        ore.setQuantityInStock(0);
        ore.setRequiredAmount(0);
        invetory[ItemType.ore.ordinal()] = ore;

        Item grain = new Item();
        grain.setDescription("Grain");
        grain.setQuantityInStock(0);
        grain.setRequiredAmount(0);
        invetory[ItemType.grain.ordinal()] = grain;

        Item food = new Item();
        food.setDescription("Food");
        food.setQuantityInStock(0);
        food.setRequiredAmount(0);
        invetory[ItemType.food.ordinal()] = food;

        Item drinkingWater = new Item();
        drinkingWater.setDescription("Drinking Water");
        drinkingWater.setQuantityInStock(0);
        drinkingWater.setRequiredAmount(0);
        invetory[ItemType.drinkingWater.ordinal()] = drinkingWater;

        Item fiberousPlants = new Item();
        fiberousPlants.setDescription("Fiberous Plants");
        fiberousPlants.setQuantityInStock(0);
        fiberousPlants.setRequiredAmount(0);
        invetory[ItemType.fiberousPlants.ordinal()] = fiberousPlants;

        Item hammer = new Item();
        hammer.setDescription("Hammer");
        hammer.setQuantityInStock(0);
        hammer.setRequiredAmount(0);
        invetory[ItemType.hammer.ordinal()] = hammer;

        Item hatchet = new Item();
        hatchet.setDescription("Hatchet");
        hatchet.setQuantityInStock(0);
        hatchet.setRequiredAmount(0);
        invetory[ItemType.hatchet.ordinal()] = hatchet;

        Item spear = new Item();
        spear.setDescription("Spear");
        spear.setQuantityInStock(0);
        spear.setRequiredAmount(0);
        invetory[ItemType.spear.ordinal()] = spear;

        Item rope = new Item();
        rope.setDescription("Rope");
        rope.setQuantityInStock(0);
        rope.setRequiredAmount(0);
        invetory[ItemType.rope.ordinal()] = rope;

        Item barrell = new Item();
        barrell.setDescription("Barrell");
        barrell.setQuantityInStock(0);
        barrell.setRequiredAmount(0);
        invetory[ItemType.barrell.ordinal()] = barrell;

        return invetory;

    }

    static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        locations = setDefaultScene (locations, scenes[SceneType.ocean.ordinal()]);
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
        locations[2][17].setScene(scenes[SceneType.beach.ordinal()]);
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
        locations[3][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[3][10].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[3][11].setScene(scenes[SceneType.river.ordinal()]);
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

        locations[5][10].setScene(scenes[SceneType.river.ordinal()]);
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
        locations[11][6].setScene(scenes[SceneType.river.ordinal()]);
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

        locations[14][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[14][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[14][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[14][3].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[14][4].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[14][5].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[14][6].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[14][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[14][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[14][9].setScene(scenes[SceneType.grass.ordinal()]);

        locations[14][10].setScene(scenes[SceneType.river.ordinal()]);
        locations[14][11].setScene(scenes[SceneType.river.ordinal()]);
        locations[14][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][14].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][15].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][16].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[14][17].setScene(scenes[SceneType.beach.ordinal()]);
        locations[14][18].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[14][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[15][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[15][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[15][2].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[15][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[15][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[15][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[15][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[15][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[15][8].setScene(scenes[SceneType.grass.ordinal()]);
        locations[15][9].setScene(scenes[SceneType.grass.ordinal()]);

        locations[15][10].setScene(scenes[SceneType.river.ordinal()]);
        locations[15][11].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[15][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[15][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[15][14].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[15][15].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[15][16].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[15][17].setScene(scenes[SceneType.beach.ordinal()]);
        locations[15][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[15][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[16][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[16][1].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[16][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[16][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[16][4].setScene(scenes[SceneType.grass.ordinal()]);
        locations[16][5].setScene(scenes[SceneType.grass.ordinal()]);
        locations[16][6].setScene(scenes[SceneType.grass.ordinal()]);
        locations[16][7].setScene(scenes[SceneType.grass.ordinal()]);
        locations[16][8].setScene(scenes[SceneType.river.ordinal()]);
        locations[16][9].setScene(scenes[SceneType.river.ordinal()]);

        locations[16][10].setScene(scenes[SceneType.river.ordinal()]);
        locations[16][11].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[16][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[16][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[16][14].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[16][15].setScene(scenes[SceneType.grass.ordinal()]);
        locations[16][16].setScene(scenes[SceneType.grass.ordinal()]);
        locations[16][17].setScene(scenes[SceneType.grass.ordinal()]);
        locations[16][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[16][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[17][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[17][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][4].setScene(scenes[SceneType.grass.ordinal()]);
        locations[17][5].setScene(scenes[SceneType.grass.ordinal()]);
        locations[17][6].setScene(scenes[SceneType.grass.ordinal()]);
        locations[17][7].setScene(scenes[SceneType.grass.ordinal()]);
        locations[17][8].setScene(scenes[SceneType.river.ordinal()]);
        locations[17][9].setScene(scenes[SceneType.jungle.ordinal()]);

        locations[17][10].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[17][11].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[17][12].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[17][13].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[17][14].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[17][15].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[17][16].setScene(scenes[SceneType.grass.ordinal()]);
        locations[17][17].setScene(scenes[SceneType.grass.ordinal()]);
        locations[17][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[17][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[18][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[18][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[18][2].setScene(scenes[SceneType.grass.ordinal()]);
        locations[18][3].setScene(scenes[SceneType.grass.ordinal()]);
        locations[18][4].setScene(scenes[SceneType.grass.ordinal()]);
        locations[18][5].setScene(scenes[SceneType.grass.ordinal()]);
        locations[18][6].setScene(scenes[SceneType.grass.ordinal()]);
        locations[18][7].setScene(scenes[SceneType.grass.ordinal()]);
        locations[18][8].setScene(scenes[SceneType.river.ordinal()]);
        locations[18][9].setScene(scenes[SceneType.cliff.ordinal()]);

        locations[18][10].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[18][11].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[18][12].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[18][13].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[18][14].setScene(scenes[SceneType.running.ordinal()]);
        locations[18][15].setScene(scenes[SceneType.jungle.ordinal()]);
        locations[18][16].setScene(scenes[SceneType.grass.ordinal()]);
        locations[18][17].setScene(scenes[SceneType.grass.ordinal()]);
        locations[18][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[18][19].setScene(scenes[SceneType.ocean.ordinal()]);

        locations[19][0].setScene(scenes[SceneType.ocean.ordinal()]);
        locations[19][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[19][2].setScene(scenes[SceneType.grass.ordinal()]);
        locations[19][3].setScene(scenes[SceneType.grass.ordinal()]);
        locations[19][4].setScene(scenes[SceneType.grass.ordinal()]);
        locations[19][5].setScene(scenes[SceneType.grass.ordinal()]);
        locations[19][6].setScene(scenes[SceneType.river.ordinal()]);
        locations[19][7].setScene(scenes[SceneType.river.ordinal()]);
        locations[19][8].setScene(scenes[SceneType.river.ordinal()]);
        locations[19][9].setScene(scenes[SceneType.cliff.ordinal()]);

        locations[19][10].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[19][11].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[19][12].setScene(scenes[SceneType.volcano.ordinal()]);
        locations[19][13].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[19][14].setScene(scenes[SceneType.grass.ordinal()]);
        locations[19][15].setScene(scenes[SceneType.grass.ordinal()]);
        locations[19][16].setScene(scenes[SceneType.grass.ordinal()]);
        locations[19][17].setScene(scenes[SceneType.grass.ordinal()]);
        locations[19][18].setScene(scenes[SceneType.beach.ordinal()]);
        locations[19][19].setScene(scenes[SceneType.start.ordinal()]);

    }

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
    
    private static Location[][] setDefaultScene (Location[][] locations, Scene defaultScene){
        for (int row = 0; row < locations.length; row++){
            for (int column = 0; column < locations.length; column++){
                locations[row][column].setScene(defaultScene);
            }
        }
        return locations;
        }
}
