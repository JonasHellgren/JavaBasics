package codinghomework.tortoise_vs_hare;


import java.util.Random;

public abstract class RunnerAbstract {

    public class State {
        public int posPrev;
        public int posPres; //is in range [0,POS_MAX]
    }

    public class Properties {
        public String name;
        public String symbol;
        public int laneNumber;
    }

    private static final int NOF_INTS_FOR_MOVE_TYPE = 100;
    private static Random rand;
    private State state;
    private Properties props;

    public RunnerAbstract(String name, int posPres, int laneNumber) {
        rand=new Random();
        state=new State();
        props =new Properties();
        this.state.posPres=posPres;
        this.props.name=name;
        this.props.laneNumber=laneNumber;
    }

    public State getState() {
        return state;
    }

    public Properties getProps() {
        return props;
    }

    public abstract void move();

    public int getNumberForMoveType() {
        return rand.nextInt(NOF_INTS_FOR_MOVE_TYPE)+1;
    }

    public boolean isWinner(RunnerAbstract runner) {
        return runner.state.posPres == Track.POS_MAX;
    }

    private int clip(int variable, int minValue, int maxValue) {
        int lowerThanMax= Math.min(variable, maxValue);
        return Math.max(lowerThanMax, minValue);
    }

    @Override
    public String toString() {
        return "Runner{" +
                "posPrev=" + state.posPrev +
                ", posPres=" + state.posPres +
                ", symbol='" + props.symbol + '\'' +
                ", laneNumber=" + props.laneNumber +
                ", name='" + props.name + '\'' +
                '}';
    }
}
