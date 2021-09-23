package codinghomework.rock_paper_scissor;

import java.util.Scanner;

public class Player extends GameItems{

    Scanner scanner;

    public Player() {
        scanner=new Scanner(System.in);
    }

    public CHOICES getChoice() {
        System.out.println("Enter choice: R=Rock, P=Paper, S=scissor");
        char choice=scanner.nextLine().toUpperCase().charAt(0);

        switch (choice) {
            case 'R': return CHOICES.ROCK;
            case 'P': return CHOICES.PAPER;
            case 'S': return CHOICES.SCISSOR;
        }

        System.out.println("Invalid input");
        return getChoice();
    }
}
