package hellgren.memorygame;


import hellgren.memorygame.GameManager.GameManager;
import hellgren.memorygame.HMI.HMIConsole;

public class Main {
    public static void main(String[] args) {

        HMIConsole hmi = new HMIConsole();   //create human machine interface
        do {  //this outer loop continuos as long as player wants to play
            GameManager gm = new GameManager();  //create game manager
            hmi.informPlayerSetup(gm.setup);   //inform player about card types of game
            //game will continue until all card types are found
            while (gm.status.getNofFoundCards() < gm.getNofCardsused()) {
                hmi.setKeysofPlayerchosenPos(gm.status, gm.setup); //player input
                hmi.showPlayfield(gm.status, gm.setup);  //show player field
                gm.updateStatus();  //update game status accordingly
            }  //end of while
            hmi.informPlayerAfterGame(gm.status);
        } while (hmi.readnewgamePlayer());  //play again?
    }
}
