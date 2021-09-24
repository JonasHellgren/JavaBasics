package codinghomework.tortoise_vs_hare;


import java.util.Random;

public abstract class RunnerAbstract {

    /***
     * A static nested class may be instantiated without instantiating its outer class.
     * Inner classes can access both static and non-static members of the outer class.
     * A static class can access only the static members of the outer class.
     */

    public static class State {
        public int posPrev;
        public int posPres; //is in range [0,POS_MAX]
    }

    public static class Properties {
        public String name;
        public String symbol;
        public int laneNumber;
    }


    private static Random rand;
    private final State state;  //final <=> will always refer to the same object
    private final Properties props;

    public RunnerAbstract(String name, int posPres, int laneNumber) {
        rand=new Random();
        state= new State();
        props = new Properties();
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
        return rand.nextInt(Constants.NOF_INTS_FOR_MOVE_TYPE)+1;
    }

    public boolean isWinner(RunnerAbstract runner) {
        return runner.state.posPres == Tracks.POS_MAX;
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
