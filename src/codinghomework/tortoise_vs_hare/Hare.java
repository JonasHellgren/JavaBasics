package codinghomework.tortoise_vs_hare;

public class Hare extends Runner {

    public Hare(String name, int posPres, int laneNumber) {
        super();
        this.posPres=posPres;
        this.name=name;
        this.laneNumber=laneNumber;
        symbol="H";
        this.moveDescription=name+"is ready!";
        allRunners.add(this);
    }

    @Override
    public void move() {
        int intForMoveType=getIntForMoveType();

        if (intForMoveType >= 1 && intForMoveType <= 20)
            updateStates(MoveType.SLEEP);
        else if (intForMoveType >= 51 && intForMoveType <= 70)
            updateStates(MoveType.SLIP);
        else if (intForMoveType >= 71 && intForMoveType <= 90)
            updateStates(MoveType.SMALL_HOP);
        else
            updateStates(MoveType.BIG_HOP);

    }

}
