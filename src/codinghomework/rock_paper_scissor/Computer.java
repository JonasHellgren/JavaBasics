package codinghomework.rock_paper_scissor;

import java.util.Random;

public class Computer extends GameItems {

    Random rand;
    public static final int NOFCHOICES = 3;

    public Computer() {
        rand = new Random();
    }


    public CHOICES getChoice() {
        int choice = 1 + rand.nextInt(NOFCHOICES);
        switch (choice) {
            case 1:
                return CHOICES.ROCK;
            case 2:
                return CHOICES.PAPER;
            case 3:
                return CHOICES.SCISSOR;
        }
        System.out.println("Shall not happen but need to return anything");
        return CHOICES.ROCK;
    }

}
