package codinghomework.tortoise_vs_hare;

import javax.swing.*;

public class Track {
    public static final int TRACK_LENGTH = 1+10;
    public static final int NOF_RUNNERS = 2;

    public String[][] tracks;

    public Track() {
        tracks=new String[TRACK_LENGTH][NOF_RUNNERS];
    }

    public void displayTracks() {
        System.out.println("");

        for (int ti = 0; ti < TRACK_LENGTH ; ti++) {
            System.out.print(ti+"   | ");
            for (int ri = 0; ri <NOF_RUNNERS ; ri++) {
                String cellTxt=(tracks[ti][ri]==null)?"   | ":tracks[ti][ri]+"  | ";
                System.out.print(cellTxt);
            }
            System.out.println();
        }
    }

    public void setPresentPositionInTrack(Runner runner)  {

        if (runner.posPres>=TRACK_LENGTH)
          System.out.println("Error runner.posPres=>TRACK_LENGTH");
        else
          tracks[runner.posPres][runner.laneNumber]=runner.symbol;
    }

    public void deletePreviousPositionInTrack(Runner runner) {
        tracks[runner.posPrev][runner.laneNumber]=null;
    }

}
