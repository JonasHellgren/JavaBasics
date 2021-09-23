package codinghomework.tortoise_vs_hare;

public class Hare extends RunnerAbstract {

    public Hare(String name, int posPres, int laneNumber) {
        super(name,posPres,laneNumber);
        this.getProps().symbol="H";
    }

    @Override
    public void move() {
        int intForMoveType= getNumberForMoveType();

        if (intForMoveType >= 1 && intForMoveType <= 20)
            Track.updateStates(this,MoveType.SLEEP);
        else if (intForMoveType >= 51 && intForMoveType <= 70)
            Track.updateStates(this,MoveType.SLIP);
        else if (intForMoveType >= 71 && intForMoveType <= 90)
            Track.updateStates(this,MoveType.SMALL_HOP);
        else
            Track.updateStates(this,MoveType.BIG_HOP);
    }

}
