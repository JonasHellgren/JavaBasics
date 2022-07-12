package effective_java.F_enums_and_annotaitons.item35;

public enum Ensamble {
    SOLO(1),
    DUO(2),
    TRIO(3);

    private final int nofMusicians;

    Ensamble(int nofMusicians) {
        this.nofMusicians = nofMusicians;
    }

    public int getNofMusicians() {
        return nofMusicians;
    }
}
