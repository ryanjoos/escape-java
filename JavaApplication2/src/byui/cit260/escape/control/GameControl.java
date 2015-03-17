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
        
        //This line of code will set all of the locations to a default.
        //All others will have to override and change
        locations = setDefaultScene (locations, scenes[SceneType.ocean.ordinal()]);
        //start Point
        
        
        locations[0][0].setScene(scenes[SceneType.beach.ordinal()]);
        
        locations[0][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[0][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[0][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[0][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[0][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[0][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[1][0].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[1][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[2][0].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[2][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[3][0].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[3][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[4][0].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[4][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[5][0].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[5][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[6][0].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[6][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[7][0].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[7][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[8][0].setScene(scenes[SceneType.beach.ordinal()]);
        locations[8][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[8][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[8][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[8][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[8][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[8][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[8][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[8][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[8][9].setScene(scenes[SceneType.beach.ordinal()]);

        locations[9][0].setScene(scenes[SceneType.beach.ordinal()]);
        locations[9][1].setScene(scenes[SceneType.beach.ordinal()]);
        locations[9][2].setScene(scenes[SceneType.beach.ordinal()]);
        locations[9][3].setScene(scenes[SceneType.beach.ordinal()]);
        locations[9][4].setScene(scenes[SceneType.beach.ordinal()]);
        locations[9][5].setScene(scenes[SceneType.beach.ordinal()]);
        locations[9][6].setScene(scenes[SceneType.beach.ordinal()]);
        locations[9][7].setScene(scenes[SceneType.beach.ordinal()]);
        locations[9][8].setScene(scenes[SceneType.beach.ordinal()]);
        locations[9][9].setScene(scenes[SceneType.beach.ordinal()]);
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
