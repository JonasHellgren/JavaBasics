package codinghomework.tortoise_vs_hare;

public class Turtle extends RunnerAbstract {

    public Turtle(String name, int posPres, int laneNumber) {
        super(name,posPres,laneNumber);
        this.getProps().symbol="T";
    }

    @Override
    public void move() {
        int intForMoveType= getNumberForMoveType();

        if (intForMoveType >= 1 && intForMoveType <= 50)
            Track.updateStates(this,MoveType.SLEEP);
        else if (intForMoveType >= 51 && intForMoveType <= 70)
            Track.updateStates(this,MoveType.CREEP);
        else
            Track.updateStates(this,MoveType.SMALL_HOP);
    }
}
