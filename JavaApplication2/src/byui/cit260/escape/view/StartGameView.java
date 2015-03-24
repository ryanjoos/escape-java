/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import byui.cit260.escape.control.ProgramControl;
import byui.cit260.escape.model.Player;
import java.io.IOException;

/**
 *
 * @author ryanjoos
 */
public class StartGameView extends View {
    
    public StartGameView() {
        super("Starting the game: ");
    }

    
    public void startGame() throws IOException{
        
        //display banner screen
        this.displayBanner();
        //Get the players name
        String playersName = this.getPlayersName();
        //Create a New player
        Player player = ProgramControl.createPlayer(playersName);
        //Display Customized Welcome Message
        this.displayWelcomeMessage(player);
       
        //Display main menu
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
    }

    private void displayBanner() {
        
        System.out.println("         ^^                    @@@@@@@@@                                ");
        System.out.println("    ^^       ^^             @@@@@@@@@@@@@@@                             ");
        System.out.println("                          @@@@@@@@@@@@@@@@@@@    ^^                     ");
        System.out.println("                         @@@@@@@@@@@@@@@@@@@@@                          ");
        System.out.println("~~~~ ~~ ~~~~ ~~~~~~~ ~~~ &&&&&&&&&&&&&&&&&&&&& ~~~~~~~ ~~~~~~~~ ~~ ~~~~ ");
        System.out.println("~         ~~  ~   ~      ~~~~~~~~~~~~~~~~~~~~~ ~       ~~     ~~~    ~  ");
        System.out.println("  ~      ~~    ~~ ~~ ~~   ~~~~~~~~~~~~~ ~~~~~  ~     ~~~     ~ ~~~ ~ ~~ ");
        System.out.println("  ~ ~~       ~       ~      ~~~~~  ~~ ~~~~        ~~ ~ ~~   ~~ ~        ");
        System.out.println("~  ~       ~ ~      ~         ~~ ~~~~~~~   ~     ~~~ ~             ~~~  ");
        System.out.println("    ~         ~       ~     ~      ~       ~~    ~            ~     ~   ");
        
        
        System.out.println("\n**********************************************************************");
        System.out.println("*                                                                    *");
        System.out.println("*                                ESCAPE                              *");
        System.out.println("*                                                                    *");
        System.out.println("* This is a game to test you skill in the art of survival            *"
                + "\n* Your main goal in this game to escape from an island               *"
                + "\n*by finding the necessary resources needed to build and raft.        *"  
                + "\n*Good Luck!                                                          *"
                );
        System.out.println("*                                                                    *"
                + "\n* You are a captain of your own ship and have a crew under your      *"
                + "\n* command. While sailing the seven seas you and your crew were       *"
                + "\n* caught in a massive storm. Your ship was thrown on the rocks       *"  
                + "\n* and destroyed. You are able to swim to the island but your crew    *"
                + "\n* is lost. The shipwreck scattered all of your provisions across     *"
                + "\n* an island. You have been stranded on Jaba Island. You are alone    *"
                + "\n* and have nothing. On the island you notice an active volcano,      *"
                + "\n* Mt. Wannahockaloogie that is going to erupt at any moment.         *"
                + "\n* The island is small enough that the volcano will destroy           *"
                + "\n* everything. It is imperative that you escape from the island.      *"
                + "\n* The island has many resources that are available to gather.        *"
                + "\n* The resources will be used to create a way for you to escape       *"
                + "\n* the island.                                                        *"
                );
        System.out.println("*                                                                    *");
        System.out.println("**********************************************************************");
        
    }    

    private String getPlayersName() throws IOException {
        boolean valid = false; //Indicates if the name has be retrieved 
        String playersName = null;
        
        while(!valid) { //While a valid name has not been retrieved
            
            //Prompt for User name
            System.out.println("\nEnter ye Name, Matey: ");
            
            //get the name from the keyboard and trim off the branks
            playersName = this.keyboard.readLine();
            playersName = playersName.trim();
            
            //If the name is invalid
            if (playersName.length() < 1) {
                System.out.println("Your name is less than 1 character? That's silly. Try again please!");
                continue; // and repeat again
            }
            break; // stop the do while thingy
        }
        return playersName; //Takes that value and puts it back up yonder
    }

    private void displayWelcomeMessage(Player player) {
            System.out.println("======================================================================"
                + "\n Ye've be warned!!! " + player.getName() + "!!!         "
                + "\n This game is not for the faint of heart!               "
                + "\n Have Fun! :)                                           "
                + "\n======================================================================"
                );    
    }

    @Override
    public boolean doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
