package codinghomework.tortoise_vs_hare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Race {
    private RaceEnvironment raceEnvironment;
    public static List<RunnerAbstract> runners;
    private boolean isRaceOver;

    public Race() {
        raceEnvironment = new RaceEnvironment();
        runners = new ArrayList<>();
        runners.add(new Turtle("Turtle", 0, 0));
        runners.add(new Hare("Hare", 0, 1));
        isRaceOver = false;
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        for (RunnerAbstract runnerAbstract : runners)
            raceEnvironment.tracks.setPresentPositionInTrack(runnerAbstract);
        raceEnvironment.tracks.displayTracks();
        scanner.nextLine();

        do {
            for (RunnerAbstract runnerAbstract : runners) {
                runnerAbstract.move();
                raceEnvironment.tracks.deletePreviousPositionInTrack(runnerAbstract);
                raceEnvironment.tracks.setPresentPositionInTrack(runnerAbstract);

                if (runnerAbstract.isWinner(runnerAbstract))
                    isRaceOver = true;
            }
            raceEnvironment.tracks.displayTracks();

        } while (!isRaceOver);

        printWinner();

    }

    public void printWinner() {

        for (RunnerAbstract runnerAbstract : runners) {
            if (runnerAbstract.isWinner(runnerAbstract))
                System.out.println("The winner is " + runnerAbstract.getProps().name);
        }
    }

}
