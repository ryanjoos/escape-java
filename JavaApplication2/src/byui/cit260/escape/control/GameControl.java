/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.model.Game;
import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.Map;
import byui.cit260.escape.model.Player;
import byui.cit260.escape.model.Raft;
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
        Item[] invetory = new Item[11];

        Item timber = new Item();
        timber.setDescription("Timber");
        timber.setQuantityInStock(0);
        timber.setRequiredAmount(0);
        invetory[0] = timber;

        Item ore = new Item();
        ore.setDescription("Ore");
        ore.setQuantityInStock(0);
        ore.setRequiredAmount(0);
        invetory[1] = ore;

        Item grain = new Item();
        grain.setDescription("Grain");
        grain.setQuantityInStock(0);
        grain.setRequiredAmount(0);
        invetory[2] = grain;

        Item food = new Item();
        food.setDescription("Food");
        food.setQuantityInStock(0);
        food.setRequiredAmount(0);
        invetory[3] = food;
        
        Item drinkingWater = new Item();
        drinkingWater.setDescription("Drinking Water");
        drinkingWater.setQuantityInStock(0);
        drinkingWater.setRequiredAmount(0);
        invetory[4] = drinkingWater;

        Item fiberousPlants = new Item();
        fiberousPlants.setDescription("Fiberous Plants");
        fiberousPlants.setQuantityInStock(0);
        fiberousPlants.setRequiredAmount(0);
        invetory[5] = fiberousPlants;
        
        Item hammer = new Item();
        hammer.setDescription("Hammer");
        hammer.setQuantityInStock(0);
        hammer.setRequiredAmount(0);
        invetory[6] = hammer;
        
        Item hatchet = new Item();
        hatchet.setDescription("Hatchet");
        hatchet.setQuantityInStock(0);
        hatchet.setRequiredAmount(0);
        invetory[7] = hatchet;
        
        Item spear = new Item();
        spear.setDescription("Spear");
        spear.setQuantityInStock(0);
        spear.setRequiredAmount(0);
        invetory[8] = spear;
        
        Item rope = new Item();
        rope.setDescription("Rope");
        rope.setQuantityInStock(0);
        rope.setRequiredAmount(0);
        invetory[9] = rope;
        
        Item barrell = new Item();
        barrell.setDescription("Barrell");
        barrell.setQuantityInStock(0);
        barrell.setRequiredAmount(0);
        invetory[10] = barrell;
        
        
        return invetory;
        
    }
}
