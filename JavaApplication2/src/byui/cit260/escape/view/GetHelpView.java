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
public class GetHelpView extends View {

    public GetHelpView() {
        super("                                  _\n"
                + "                              ,--.\\`-. __\n"
                + "                            _,.`. \\:/,\"  `-._\n"
                + "                        ,-*\" _,.-;-*`-.+\"*._ )\n"
                + "                       ( ,.\"* ,-\" / `.  \\.  `.\n"
                + "                      ,\"   ,;\"  ,\"\\../\\  \\:   \\\n"
                + "                     (   ,\"/   / \\.,' :   ))  /\n"
                + "                      \\  |/   / \\.,'  /  // ,'\n"
                + "                       \\_)\\ ,' \\.,'  (  / )/\n"
                + "                           `  \\._,'   `\"\n"
                + "                            O \\../\n"
                + "                           ,~.\\../\n"
                + "                    ~     <'_/\\../           ~~\n"
                + "             ~~         ~~ /.|\\../   ~~   ~      ~~\n"
                + "        ~~    ~   ~~  __.__\\||\\../-...__ ~~~     ~~\n"
                + "          ~~~~  ~_,--\"  `'--*'\\../      `--.__ ~~    ~~\n"
                + "      ~~~  __,--\"    .  . .-- . `\".--. .      `--.__   ~~~\n"
                + "   ~~  ,--\"          |--| |-- |   |__| |            `--.\n"
                + "      '------......__'__' '-- '-- '   _.____......------` ~~\n"
                + "    ~~~   ~    ~~      ~ `````---\"\"\"\"\"  ~~   ~     ~~\n"
                + "           ~~~~    ~~  ~~~~       ~~~~~~  ~ ~~   ~~ ~~~  ~\n"
                + "        ~~   ~   ~~~     ~~~ ~         ~~       ~~   \n"
                + "                 ~        ~~       ~~~       ~asdf"
                + ""
                + "\n"
                + "\n========================================================="
                + "\n======================  Help Menu  ======================"
                + "\n_________________________________________________________"
                + "\nG - What is the goal of the game?                        "
                + "\nM - How to move                                          "
                + "\nB - View Bag/View Status of Raft/Resources needed        "
                + "\nA - Interact (Harvest certain resources, use items, etc.)"
                + "\nL - View your location.                                  "
                + "\nO - Observe surroundings                                 "
                + "\nQ - Quit or Go Back to Main Menu                         "
                + "\n=========================================================");

    }

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);

        switch (choice) {
            case 'G':
                this.gameGoal();
                break;
            case 'M':
                this.howToMove();
                break;
            case 'B':
                this.viewResourceBag();
                break;
            case 'A':
                this.howToInteract();
                break;
            case 'L':
                this.viewLocation();
                break;
            case 'O':
                this.observeSurroundings();
                break;
            case 'Q':    // Quit the help menu go to Main Menu
                this.displayMainMenu();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return true;
    }

    private void gameGoal() {
        this.console.println("The goal of Escape is to test your skill in escaping Jaba Island. "
                + "You will have to use strategy to gather all the nessecary resources to build a raft and"
                + "make it safely off the island. ");
        GetHelpView getHelpMenu = new GetHelpView();
        // display the game menu
        getHelpMenu.display();

    }

    private void howToMove() {
        this.console.println("*** howToMove function called ***");
        GetHelpView getHelpMenu = new GetHelpView();
        // display the game menu
        getHelpMenu.display();
    }

    private void viewResourceBag() {
        this.console.println("*** viewResourceBag function called ***");
        GetHelpView getHelpMenu = new GetHelpView();
        // display the game menu
        getHelpMenu.display();
    }

    private void howToInteract() {
        this.console.println("*** howToInteract function called ***");
        GetHelpView getHelpMenu = new GetHelpView();
        // display the game menu
        getHelpMenu.display();
    }

    private void viewLocation() {
        this.console.println("*** viewLocation function called ***");
        GetHelpView getHelpMenu = new GetHelpView();
        // display the game menu
        getHelpMenu.display();
    }

    private void observeSurroundings() {
        this.console.println("*** observeSurroundings function called ***");
        GetHelpView getHelpMenu = new GetHelpView();
        // display the game menu
        getHelpMenu.display();
    }

    private void displayMainMenu() {
        //Create a new Game Menu View
        MainMenuView mainMenu = new MainMenuView();
        // display the game menu
        mainMenu.display();
    }
}
