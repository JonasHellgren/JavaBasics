package java_design_patterns.G_mediator.random_walk.collegues;

import java_design_patterns.G_mediator.random_walk.abstract_classes.MediatorI;

public class Subber {
    MediatorI mediator;

    public Subber(MediatorI mediator) {
        this.mediator = mediator;
    }

    public void subClipAndRecord() {
        mediator.sub();
        mediator.clip();
        mediator.record();
    }
}
