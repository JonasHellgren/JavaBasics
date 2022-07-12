package effective_java.F_enums_and_annotaitons.item37;

import java.util.EnumMap;
import java.util.Map;

public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS);

        final Phase src;
        final Phase dst;

        Transition(Phase src, Phase dst) {
            this.src = src;
            this.dst = dst;
        }
    }

    private static final Map<Phase, Map<Phase, Transition>> m;

    //init trans map
    static {
        m = new EnumMap<>(Phase.class);
        for (Phase p : Phase.values())
            m.put(p, new EnumMap<>(Phase.class));
        for (Transition trans : Transition.values()) {
            System.out.println("trans = " + trans+", src = " + trans.src+", dst = " + trans.dst);
            m.get(trans.src).put(trans.dst, trans);
        }
    }

    public static Transition from(Phase src, Phase dst) {
        return m.get(src).get(dst);
    }

}


