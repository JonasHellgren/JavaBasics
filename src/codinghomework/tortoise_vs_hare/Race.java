package codinghomework.tortoise_vs_hare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Race {
    private Track track;
    public static List<RunnerAbstract> runners;
    private boolean isRaceOver;

    public Race() {
        track=new Track();
        runners =new ArrayList<>();
        runners.add(new Turtle("Turtle",0,0));
        runners.add(new Hare("Hare",0,1));
        isRaceOver=false;
    }

    public void run() {

        Scanner scanner=new Scanner(System.in);
        for (RunnerAbstract runnerAbstract : runners)
            track.setPresentPositionInTrack(runnerAbstract);
        track.displayTracks();

        do {
            scanner.nextLine();

            for (RunnerAbstract runnerAbstract : runners) {
                runnerAbstract.move();
                track.deletePreviousPositionInTrack(runnerAbstract);
                track.setPresentPositionInTrack(runnerAbstract);

                if (runnerAbstract.isWinner(runnerAbstract))
                    isRaceOver=true;
            }
            track.displayTracks();

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
