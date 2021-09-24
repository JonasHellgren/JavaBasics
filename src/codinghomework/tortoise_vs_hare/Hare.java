package codinghomework.tortoise_vs_hare;

public class Hare extends RunnerAbstract {

    public static final int PROB_SLEEP_LOW = 1;
    public static final int PROB_SLEEP_HIGH = 50;
    public static final int PROB_SLIP_LOW = 51;
    public static final int PROB_SLIP_HIGH = 70;
    public static final int PROB_SMALL_HOP_LOW = 71;
    public static final int PROB_SMALL_HOP_HIGH = 90;

    public Hare(String name, int posPres, int laneNumber) {
        super(name,posPres,laneNumber);
        this.getProps().symbol="H";
    }

    @Override
    public void move() {
        int intForMoveType= getNumberForMoveType();

        if (intForMoveType >= PROB_SLEEP_LOW && intForMoveType <= PROB_SLEEP_HIGH)
            RaceEnvironment.updateStates(this,MoveType.SLEEP);
        else if (intForMoveType >= PROB_SLIP_LOW && intForMoveType <= PROB_SLIP_HIGH)
            RaceEnvironment.updateStates(this,MoveType.SLIP);
        else if (intForMoveType >= PROB_SMALL_HOP_LOW && intForMoveType <= PROB_SMALL_HOP_HIGH)
            RaceEnvironment.updateStates(this,MoveType.SMALL_HOP);
        else
            RaceEnvironment.updateStates(this,MoveType.BIG_HOP);
    }

}
