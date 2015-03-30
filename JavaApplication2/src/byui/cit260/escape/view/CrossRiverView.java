/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

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
                break;
        }
        return true;
    }

    private void checkResources() {
        this.console.println("Looks Good, Go ahead and Build the Bridge");
    }

    private void buildBridge() {
        String promptMessage = null;
        BuildBridgeView start = new BuildBridgeView(promptMessage);
        start.display();
    }

    private void leave() {
        MainMenuView mainMenu = new MainMenuView();

        mainMenu.display();
    }
}
