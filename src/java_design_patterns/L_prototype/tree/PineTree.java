package java_design_patterns.L_prototype.tree;

public class PineTree extends Tree {

    public PineTree(double mass, double height) {
        super(mass, height);
    }

    @Override
    public Tree copy() {
        PineTree pineTreeClone = new PineTree(this.getMass(), this.getHeight());
        pineTreeClone.setPosition(this.getPosition());
        return pineTreeClone;
    }

}
