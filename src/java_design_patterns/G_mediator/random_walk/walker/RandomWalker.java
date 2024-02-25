package java_design_patterns.G_mediator.random_walk.walker;

import java.util.ArrayList;
import java.util.List;

import common.RandomUtils;
import java_design_patterns.G_mediator.random_walk.abstract_classes.MediatorI;
import java_design_patterns.G_mediator.random_walk.collegues.Adder;
import java_design_patterns.G_mediator.random_walk.collegues.Keeper;
import java_design_patterns.G_mediator.random_walk.collegues.Subber;
import java_design_patterns.G_mediator.random_walk.mediator.Mediator;
import org.apache.commons.math3.util.Pair;


public class RandomWalker {
    int number;
    Pair<Integer,Integer> minMaxNumber;
    List<Integer> history;
    MediatorI mediator;
    Adder adder;
    Subber subber;
    Keeper keeper;

    public RandomWalker(int initNumber, Pair<Integer, Integer> minMaxNumber) {
        this.number = initNumber;
        this.minMaxNumber = minMaxNumber;
        this.history=new ArrayList<>();
        history.add(initNumber);
        this.mediator=new Mediator(new RandomWalkerForMediator(this));
        this.adder=new Adder(mediator);
        this.subber=new Subber(mediator);
        this.keeper=new Keeper(mediator);
    }

    public List<Integer> getHistory() {
        return history;
    }

    public void step() {
        int randInt= RandomUtils.getRandomIntNumber(0,3);
        switch (randInt) {
            case 0 -> adder.addClipAndRecord();
            case 1 -> subber.subClipAndRecord();
            case 2 -> keeper.keepClipAndRecord();
            default -> throw new RuntimeException("Illegal rand num");
        }
    }




}
