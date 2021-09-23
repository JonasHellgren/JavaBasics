package codinghomework.tortoise_vs_hare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Runner {
    public static final int NOF_INTS_FOR_MOVE_TYPE = 100;
    public static final int POS_MAX=Track.TRACK_LENGTH-1;
    private static Random rand;
    public int posPrev;
    public int posPres; //is in range [0,POS_MAX]
    public String symbol;
    public int laneNumber;
    public String name;
    public String moveDescription;
    public static List<Runner> allRunners=new ArrayList<>();

    public Runner() {
        rand=new Random();
        //allRunners=new ArrayList<>();
    }

    public abstract void move();

    public int getIntForMoveType () {
        return rand.nextInt(NOF_INTS_FOR_MOVE_TYPE)+1;
    }

    public  void updateStates(int nofSteps) {
        posPrev=posPres;
        posPres +=posPres+nofSteps;
        posPres=clip(posPres,0,POS_MAX);
    }

    public boolean isWinner(Runner runner) {
        return runner.posPres == POS_MAX;
    }

    private int clip(int variable, int minValue, int maxValue) {
        int lowerThanMax= Math.min(variable, maxValue);
        return Math.max(lowerThanMax, minValue);
    }

    @Override
    public String toString() {
        return "Runner{" +
                "posPrev=" + posPrev +
                ", posPres=" + posPres +
                ", symbol='" + symbol + '\'' +
                ", laneNumber=" + laneNumber +
                ", name='" + name + '\'' +
                ", moveDescription='" + moveDescription + '\'' +
                '}';
    }
}
