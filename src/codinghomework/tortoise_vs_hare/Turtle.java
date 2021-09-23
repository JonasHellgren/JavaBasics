package codinghomework.tortoise_vs_hare;

public class Turtle extends Runner {

    public Turtle(String name, int posPres, int laneNumber) {
        super();
        this.name=name;
        this.posPres=posPres;
        this.laneNumber=laneNumber;
        symbol="T";
        this.moveDescription=name+"is ready!";
        allRunners.add(this);
    }

    @Override
    public void move() {
        int intForMoveType=getIntForMoveType();

        if (intForMoveType >= 1 && intForMoveType <= 50)
            updateStates(MoveType.SLEEP);
        else if (intForMoveType >= 51 && intForMoveType <= 70)
            updateStates(MoveType.CREEP);
        else
            updateStates(MoveType.SMALL_HOP);
    }
}
