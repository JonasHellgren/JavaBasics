package codinghomework.tortoise_vs_hare;

public class Tracks {

    public static final int TRACK_LENGTH = 1 + 9;
    public static final int POS_MAX = TRACK_LENGTH - 1;
    public static final int NOF_LANES = 2;

    private String[][] tracks;

    public Tracks() {
        tracks = new String[TRACK_LENGTH][NOF_LANES];
    }

    public void setPresentPositionInTrack(RunnerAbstract runner) {

        if (runner.getState().posPres >= TRACK_LENGTH)
            System.out.println("Error runner.posPres=>TRACK_LENGTH");
        else
            tracks[runner.getState().posPres][runner.getProps().laneNumber] = runner.getProps().symbol;
    }

    public void deletePreviousPositionInTrack(RunnerAbstract runner) {
        tracks[runner.getState().posPrev][runner.getProps().laneNumber] = null;
    }

    public void displayTracks() {
        System.out.println("");

        for (int ti = 0; ti < TRACK_LENGTH; ti++) {
            System.out.print(ti + "   | ");
            for (int li = 0; li < NOF_LANES; li++) {
                String cellTxt = (tracks[ti][li] == null) ? "   | " : tracks[ti][li] + "  | ";
                System.out.print(cellTxt);
            }
            System.out.println();
        }
    }

}
