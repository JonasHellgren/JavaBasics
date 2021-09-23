package codinghomework.rock_paper_scissor;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Game game=new Game();
        char quit;

        do {
            game.play();
            System.out.println("Play again? Y=yes");
            quit=scanner.nextLine().toUpperCase().charAt(0);
        } while (quit=='Y');

    }
}
