package hellgren.guessnumberobjectoriented.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HMI {  //This class is the interpretor between player and game
    private Scanner input;
    public HMI() {  input = new Scanner(System.in); }; //constructor

    public String readNumPlayer(Gamestatus status, GameRules rules) {
        Integer playinputnum;  //This function reads number from player, checks number is in intervall.
        do {
            System.out.print("Give the number:"); playinputnum = input.nextInt();  //read number
            if (numnotinintervall(playinputnum,rules))
                System.out.println("Number is not according to gamerules");
        }
        while (numnotinintervall(playinputnum,rules));
        return playinputnum.toString();
    }

    public Ruletype readgametypePlayer() { //This function requests player to give game type, simple or advanced
        String playinputstring;  boolean badinput;
        do {
            System.out.print("Simple[s] or advanced[a] game:");
            playinputstring = input.next();  //read  from player
            badinput=!playinputstring.contains("s") && !playinputstring.contains("a");
            if (badinput)
                System.out.println("Non correct input");
        }
        while (badinput);

        Map<String, Ruletype> rulemap = new HashMap<>();  // Create HashMap
        rulemap.put("s", Ruletype.Simple);     rulemap.put("a", Ruletype.Advanced);  //Insert elements
        return rulemap.get(playinputstring);  //lock up player input

    }

    public boolean readnewgamePlayer() {  //This method returns True if player wants to play new game
        System.out.print("New game [y/n]:");
        String newgamestring = input.next();  //read  from player
        return newgamestring.equals("y");
    }

    public void informPlayer(GuessReplyText replytxt, int nofguesses) { //Informs player about guess and game progress
        System.out.println("Your guess was "+replytxt+". You have used "+Integer.toString(nofguesses)+" guess(es)");    }

    public void informPlayerAboutRules(String infostr) { //Gives player game instructions
        System.out.println(infostr);    }


    Boolean numnotinintervall(Integer playinputnum,GameRules rules) { //Returns True if guessed number not is in intervall
       return playinputnum<rules.getMinnr() || playinputnum > rules.getMaxnr();
    }
}
