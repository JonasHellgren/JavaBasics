package java_design_patterns.G_mediator.random_walk.mediator;

import common.MathUtils;
import java_design_patterns.G_mediator.random_walk.abstract_classes.MediatorI;
import java_design_patterns.G_mediator.random_walk.walker.RandomWalkerForMediator;

public class Mediator implements MediatorI {
    RandomWalkerForMediator walker;

    public Mediator(RandomWalkerForMediator walker) {
        this.walker = walker;
    }

    @Override
    public void add() {
        walker.setNumber(walker.getNumber()+1);
    }

    @Override
    public void sub() {
        walker.setNumber(walker.getNumber()-1);
    }

    @Override
    public void record() {
        walker.getHistory().add(walker.getNumber());
    }

    @Override
    public void clip() {
        int numPres=walker.getNumber();
        var minMax=walker.getMinMax();
        walker.setNumber(MathUtils.clip(numPres,minMax.getFirst(),minMax.hashCode()));
    }


}
