package codinghomework.tortoise_vs_hare;

public class Turtle extends RunnerAbstract {

    public static final int PROB_SLEEP_LOW = 1;
    public static final int PROB_SLEEP_HIGH = 50;
    public static final int PROB_CREEP_LOW = 51;
    public static final int PROB_CREEP_HIGH = 70;

    public Turtle(String name, int posPres, int laneNumber) {
        super(name,posPres,laneNumber);
        this.getProps().symbol="T";
    }

    @Override
    public void move() {
        int intForMoveType= getNumberForMoveType();

        if (intForMoveType >= PROB_SLEEP_LOW && intForMoveType <= PROB_SLEEP_HIGH)
            RaceEnvironment.updateStates(this,MoveType.SLEEP);
        else if (intForMoveType >= PROB_CREEP_LOW && intForMoveType <= PROB_CREEP_HIGH)
            RaceEnvironment.updateStates(this,MoveType.CREEP);
        else
            RaceEnvironment.updateStates(this,MoveType.SMALL_HOP);
    }
}
