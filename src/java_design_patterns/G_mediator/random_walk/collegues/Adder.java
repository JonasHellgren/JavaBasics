package java_design_patterns.G_mediator.random_walk.collegues;

import java_design_patterns.G_mediator.random_walk.abstract_classes.MediatorI;

public class Adder {
    MediatorI mediator;

    public Adder(MediatorI mediator) {
        this.mediator = mediator;
    }

    public void addClipAndRecord() {
        mediator.add();
        mediator.clip();
        mediator.record();
    }
}
