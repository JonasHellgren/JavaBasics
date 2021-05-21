package hellgren.guessnumprocedural;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int correctnr = (int)(Math.random() * 100.0D);
        Scanner input = new Scanner(System.in);
        System.out.println("The number to be guessed shall be between 0 and 100");

        int guessednr;
        do {
            System.out.println("Give your guess:");
            guessednr = input.nextInt();
            if (guessednr == correctnr) {
                System.out.println("Good, correct guess.");
            } else if (guessednr < correctnr) {
                System.out.println("Your guess is too small.");
            } else {
                System.out.println("Your guess is too large.");
            }
        } while(guessednr != correctnr);

    }
}