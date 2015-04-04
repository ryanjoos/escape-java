/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

/**
 *
 * @author Carissa
 */
public class ObstacleVolcanoView extends View {

    public ObstacleVolcanoView() {
        super("         ____ /\\ ____            _ _   --           - -__     -_\n"
                + "        /v y \\/\\/    \\                   --  --___     _ __--__ -\" _\n"
                + "       ____\\7 \\\\_^_^/ \\                            _ --        -_ \"-_\n"
                + "      /    V/ \\/   \\ ^/\\            __                          _--,_\n"
                + "     / \\^\\|/ \\()^7_ \\ ^|      /\">^/\",,\\                        /\"(\"\\\"\\\n"
                + "    /\\^   / \\^_() 7_\\        </\">LX<\"<,\\                    _/\"/\"|\\ )\\>_\n"
                + "    |^    /\\ ()_|  7|        / >/ >O-,\\\"                 _/\"_.\" _/ / / \\\"\\\n"
                + "          ^   \\_\\            ^\" V\"O^  V               /\"\"_-\" ,/\"  /\\  \\ ) \"-,_\n"
                + "               \\_\\              '  \\>              _-\"/ ( .-/ \\ !   )  \\ _\\\"-_\"\\_\n"
                + " ___ ___ ______ \\_\\ _ _____ ___ ___ \\> _ ___   _-\"/_-\"   / (    |  / \\  | \\  \\_- \"-_  __ _ _\n"
                + "       _  _ _-   \\_\\   --  -   - --  \\\">   -<_\"__\" /  _/|   \\ \\ | /! \\  \\  -_( _\"-<_\">-- -\n"
                + "              --  \\_`>    _--    _ ___\",\">-____ _\"> \"\"_\" \"--\"--\"-\" \"-\"' \"-\"  '\"  _\n"
                + "                   \\__\">      C\"\" -_O   \"O-'           '\">        __ -  -\n"
                + "         _ __()_ ___\"-__\"\\__ __)    - O         __ - - \"      - -\n"
                + "                ()   _\">--\"> _ .-- \"      - \"\"\"\n"
                + "                        \"\"\"\n"
                + "\n"
                + "\n========================================================="
                + "\n======================  What next  ======================"
                + "\n_________________________________________________________"
                + "\nYou just entered your new location when the volcano      "
                + "\nMt. Wannahockaloogie starts to emit smoke causing the    "
                + "\nisland to shake. Although the volcano is not yet ready,  "
                + "\nthis volcano precursor eruption is causing an avalanch   "
                + "\nto occur. You must get to safty immediately. You spot an "
                + "\nfield free of falling rocks and trees, but you may not   "
                + "\nhave enouth time to reach it before the avalanch comes.  "
                + "\nWhat is your next move to safety? Quick!                 "
                + "\nC - Climb a large, strudy tree                           "
                + "\nR - Run quickly to the next location                     "
                + "\nH - Hide behind a boulder                                "
                + "\nP - Find safety at previous location                     "
                + "\nS - Stay where you are and die                           "
                + "\n=========================================================");
    }

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);

        switch (choice) {
            case 'C':
                this.climbOption();
                break;
            case 'R':
                this.runOption();
                break;
            case 'H':
                this.hideOption();
                break;
            case 'P':
                this.retreatOption();
                break;
            case 'S':
                this.dieOption();
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return true;
    }

    private void climbOption() {
        this.console.println("As soon as you were about to run to the tree, ");
        this.console.println("it became uprooted and feel to the ground");
        this.console.println("Choose your next move quick!");

        ObstacleVolcanoView obstacleVolcanoMenu = new ObstacleVolcanoView();
        obstacleVolcanoMenu.display();
    }

    private void runOption() {
        String promptMessage = null;
        RunningSpeedView run = new RunningSpeedView(promptMessage);
        run.display();
    }

    private void hideOption() {
        this.console.println("Unfortunately, the earthquake cause the large ");
        this.console.println("boulder to roll down into the forest. ");
        this.console.println("Your only choice of shleter is now gone ");
        this.console.println("Choose your next move quick!");

        ObstacleVolcanoView obstacleVolcanoMenu = new ObstacleVolcanoView();
        obstacleVolcanoMenu.display();
    }

    private void retreatOption() {
        this.console.println("As you turn around to retreat, you notice ");
        this.console.println("the earthquake caused the water to rise in the ");
        this.console.println("river and the location is temporarily blocked. ");
        this.console.println("Choose your next move quick!");

        ObstacleVolcanoView obstacleVolcanoMenu = new ObstacleVolcanoView();
        obstacleVolcanoMenu.display();
    }

    private void dieOption() {
        this.console.println("Matey, death is not an option of you! Choose another option fast!!!!");

        ObstacleVolcanoView obstacleVolcanoMenu = new ObstacleVolcanoView();
        obstacleVolcanoMenu.display();
    }
}
