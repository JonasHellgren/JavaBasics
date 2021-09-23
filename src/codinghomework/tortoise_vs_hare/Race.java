package codinghomework.tortoise_vs_hare;

import java.util.Scanner;

public class Race {
    private Track track;
    private boolean isRaceOver;

    public Race() {
        track=new Track();
        new Turtle("Turtle",0,0);
        new Hare("Hare",0,1);
        isRaceOver=false;
    }

    public void run() {

        Scanner scanner=new Scanner(System.in);
        for (Runner runner:Runner.allRunners)
            track.setPresentPositionInTrack(runner);
        track.displayTracks();

        do {
            scanner.nextLine();

            for (Runner runner:Runner.allRunners) {
                runner.move();
                track.deletePreviousPositionInTrack(runner);
                track.setPresentPositionInTrack(runner);

                if (runner.isWinner(runner))
                    isRaceOver=true;
            }
            track.displayTracks();

        } while (!isRaceOver);

        printWinner();

    }

    public void printWinner() {

        for (Runner runner : Runner.allRunners) {
            if (runner.isWinner(runner))
                System.out.println("The winner is " + runner.name);

        }
    }

}
