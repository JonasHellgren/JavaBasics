package java_design_patterns.G_mediator.random_walk.collegues;

import java_design_patterns.G_mediator.random_walk.abstract_classes.MediatorI;

public class Keeper {
    MediatorI mediator;

    public Keeper(MediatorI mediator) {
        this.mediator = mediator;
    }

    public void keepClipAndRecord() {
        mediator.record();
    }
}
