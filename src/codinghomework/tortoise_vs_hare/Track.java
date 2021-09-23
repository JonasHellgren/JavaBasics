package codinghomework.tortoise_vs_hare;

public class Track {
    public static final int TRACK_LENGTH = 1+9;
    public static final int POS_MAX=Track.TRACK_LENGTH-1;
    public static final int NOF_LANES = 2;

    public String[][] tracks;

    public Track() {
        tracks=new String[TRACK_LENGTH][NOF_LANES];
    }

    public void displayTracks() {
        System.out.println("");

        for (int ti = 0; ti < TRACK_LENGTH ; ti++) {
            System.out.print(ti+"   | ");
            for (int li = 0; li < NOF_LANES; li++) {
                String cellTxt=(tracks[ti][li]==null)?"   | ":tracks[ti][li]+"  | ";
                System.out.print(cellTxt);
            }
            System.out.println();
        }
    }

    public void setPresentPositionInTrack(RunnerAbstract runner)  {

        if (runner.getState().posPres>=TRACK_LENGTH)
          System.out.println("Error runner.posPres=>TRACK_LENGTH");
        else
          tracks[runner.getState().posPres][runner.getProps().laneNumber]= runner.getProps().symbol;
    }

    public void deletePreviousPositionInTrack(RunnerAbstract runner) {
        tracks[runner.getState().posPrev][runner.getProps().laneNumber]=null;
    }

    public static void updateStates(RunnerAbstract runner, int nofSteps) {
        RunnerAbstract.State state=runner.getState();
        state.posPrev= state.posPres;
        state.posPres+= state.posPres+nofSteps;
        state.posPres=clip(state.posPres,0,POS_MAX);
    }

    private static int clip(int variable, int minValue, int maxValue) {
        int lowerThanMax= Math.min(variable, maxValue);
        return Math.max(lowerThanMax, minValue);
    }

}
