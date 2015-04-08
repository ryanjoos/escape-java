/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.ItemType;
import byui.cit260.escape.model.Resource;
import byui.cit260.escape.model.ResourceType;
import escapePackage.Escape;

/**
 *
 * @author ryanjoos
 */
public class CrossRiverView extends View {

    public CrossRiverView() {
        super("                                           ^^\n"
                + "      ^^      ..                                       ..\n"
                + "              []                                       []\n"
                + "            .:[]:_          ^^                       ,:[]:.\n"
                + "          .: :[]: :-.                             ,-: :[]: :.\n"
                + "        .: : :[]: : :`._                       ,.': : :[]: : :.\n"
                + "      .: : : :[]: : : : :-._               _,-: : : : :[]: : : :.\n"
                + "  _..: : : : :[]: : : : : : :-._________.-: : : : : : :[]: : : : :-._\n"
                + "  _:_:_:_:_:_:[]:_:_:_:_:_:_:_:_:_:_:_:_:_:_:_:_:_:_:_:[]:_:_:_:_:_:_\n"
                + "  !!!!!!!!!!!![]!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!![]!!!!!!!!!!!!!\n"
                + "  ^^^^^^^^^^^^[]^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^[]^^^^^^^^^^^^^\n"
                + "              []                                       []\n"
                + "              []                                       []\n"
                + "              []                                       []\n"
                + "   ~~^-~^_~^~/  \\~^-~^~_~^-~_^~-^~_^~~-^~_~^~-~_~-^~_^/  \\~^-~_~^-~~- \n"
                + "  ~ _~~- ~^-^~-^~~- ^~_^-^~~_ -~^_ -~_-~~^- _~~_~-^_ ~^-^~~-_^-~ ~^\n"
                + "     ~ ^- _~~_-  ~~ _ ~  ^~  - ~~^ _ -  ^~-  ~ _  ~~^  - ~_   - ~^_~\n"
                + "       ~-  ^_  ~^ -  ^~ _ - ~^~ _   _~^~-  _ ~~^ - _ ~ - _ ~~^ -\n"
                + "          ~^ -_ ~^^ -_ ~ _ - _ ~^~-  _~ -_   ~- _ ~^ _ -  ~ ^-\n"
                + "              ~^~ - _ ^ - ~~~ _ - _ ~-^ ~ __- ~_ - ~  ~^_-\n"
                + "                  ~ ~- ^~ -  ~^ -  ~ ^~ - ~~  ^~ - ~"
                + "\n"
                + "\n========================================================="
                + "\n======================  What next?  ====================="
                + "\n_________________________________________________________"
                + "\nYou've come to a river. The current is far too strong.   "
                + "\nIn order to be able to cross you must construct a bridge."
                + "\nWhat is your next move to safety? Quick!                 "
                + "\nL - Leave and come back later                            "
                + "\nC - Check my resources to see if I can build             "
                + "\nB - Build the Bridge                                     "
                + "\n=========================================================");
    }

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);

        switch (choice) {

            case 'C':
                this.checkResources();
                break;
            case 'B':
                this.buildBridge();
                break;
            case 'L':
                this.leave();
                return true;
            default:
                ErrorView.display(this.getClass().getName(),
                        "\nYou must enter a valid Selection.");
                this.display();
                break;
        }
        return true;
    }

    private void checkResources() {
        Resource[] resource = Escape.getCurrentGame().getResource();
        Item[] item = Escape.getCurrentGame().getItem();

        if (resource[ResourceType.timber.ordinal()].getTotalAmount() >= 40 && item[ItemType.hatchet.ordinal()].getQuantityInStock() >= 1) {
            this.console.println("You have enough resources to build a bridge.");
        } else {
            this.console.println("Sorry, you don't have enough resource. Keep collecting timber and/or make a hatchet.");
        }
    }

    private void buildBridge() {
        Resource[] resource = Escape.getCurrentGame().getResource();
        Item[] item = Escape.getCurrentGame().getItem();

        if (resource[ResourceType.timber.ordinal()].getTotalAmount() >= 40 && item[ItemType.hatchet.ordinal()].getQuantityInStock() >= 1) {
            int numTimber = resource[ResourceType.timber.ordinal()].getTotalAmount();
            numTimber -= 40;
            resource[ResourceType.timber.ordinal()].setTotalAmount(numTimber);
            String promptMessage = null;
            BuildBridgeView start = new BuildBridgeView(promptMessage);
            start.display();
        } else {
            this.console.println("Sorry, you don't have enough resource. Keep collecting timber and/or make a hatchet.");
        }
    }

    private void leave() {
        GameMenuView gameMenu = new GameMenuView();

        gameMenu.display();
    }
}
