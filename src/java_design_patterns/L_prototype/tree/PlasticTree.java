package java_design_patterns.L_prototype.tree;

public class PlasticTree extends Tree {

    public PlasticTree(double mass, double height) {
        super(mass, height);
    }

    @Override
    public Tree copy() {
        PlasticTree plasticTreeClone = new PlasticTree(this.getMass(), this.getHeight());
        plasticTreeClone.setPosition(this.getPosition());
        return plasticTreeClone;
    }
}
