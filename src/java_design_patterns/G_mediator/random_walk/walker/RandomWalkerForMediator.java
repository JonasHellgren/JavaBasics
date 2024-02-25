package java_design_patterns.G_mediator.random_walk.walker;

import org.apache.commons.math3.util.Pair;

import java.util.List;

public class RandomWalkerForMediator  {
    RandomWalker walker;

    public RandomWalkerForMediator(RandomWalker walker) {
        this.walker=walker;
    }

    public int getNumber() {
        return walker.number;
    }

    public List<Integer> getHistory() {
        return walker.history;
    }


    public Pair<Integer,Integer> getMinMax() {
        return walker.minMaxNumber;
    }

    public void setNumber(Integer number) {
        walker.number=number;
    }

}
