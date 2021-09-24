package codinghomework.tortoise_vs_hare;

public class RaceEnvironment {

    Tracks tracks;

    public RaceEnvironment() {
    tracks=new Tracks();
    }


    public static void updateStates(RunnerAbstract runner, int nofSteps) {
        RunnerAbstract.State state=runner.getState();
        state.posPrev= state.posPres;
        state.posPres+= state.posPres+nofSteps;
        state.posPres=clip(state.posPres,0,Tracks.POS_MAX);
    }

    private static int clip(int variable, int minValue, int maxValue) {
        int lowerThanMax= Math.min(variable, maxValue);
        return Math.max(lowerThanMax, minValue);
    }

}
