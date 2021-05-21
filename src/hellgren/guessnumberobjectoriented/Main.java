package hellgren.guessnumberobjectoriented;

import hellgren.guessnumberobjectoriented.classes.GameManager;
import hellgren.guessnumberobjectoriented.classes.HMI;
import hellgren.guessnumberobjectoriented.classes.Ruletype;

public class Main {

    public static void main(String[] args) {
        HMI hmi = new HMI();  //create HMI object

        String playnuminput;
        do {  //repeat game loop
            Ruletype gametype=hmi.readgametypePlayer();  //ask player for game type, simple or advanced
            GameManager gm = new GameManager(gametype);  //greta game
            hmi.informPlayerAboutRules(gm.rules.GetRuleTypeMessage()); //give game instructions
            //System.out.println(gm.status.getCorrectGuesses());   //correct answer for testing, shall be removed
         do {  //game loop
                playnuminput = hmi.readNumPlayer(gm.status, gm.rules);  //ask player for guess
                gm.updateStatus(playnuminput);  //update game status, i.e. set lastguess variable
                hmi.informPlayer(gm.rules.replyToPlayerLastInput(gm.status),gm.status.getNofguesses());  //guess info to player
            }
            while (gm.status.getLastguess() != gm.status.getCorrectGuesses()); //end game loop
        }
        while (hmi.readnewgamePlayer());  //end repeat game loop

    }
}

