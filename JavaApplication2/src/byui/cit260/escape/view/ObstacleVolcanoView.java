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
        super("\n"
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
                MainMenuView mainMenu = new MainMenuView();
                mainMenu.display();
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
    }

    private void retreatOption() {
        this.console.println("As you turn around to retreat, you notice ");
        this.console.println("the earthquake caused the water to rise in the ");
        this.console.println("river and the location is temporarily blocked. ");
        this.console.println("Choose your next move quick!");
    }
}
