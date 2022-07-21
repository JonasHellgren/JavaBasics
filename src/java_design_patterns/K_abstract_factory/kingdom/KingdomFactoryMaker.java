package java_design_patterns.K_abstract_factory.kingdom;

import java_design_patterns.K_abstract_factory.kingdom.elf.ElfKingdomFactory;
import java_design_patterns.K_abstract_factory.kingdom.orc.OrcKingdomFactory;
import lombok.extern.java.Log;

@Log
public class KingdomFactoryMaker {

    public static KingdomFactory makeFactory(KingdomType type) {

        log.info("Creating kingdom factory of type "+type);
        switch (type) {
            case ELF:
                return new ElfKingdomFactory();
            case ORC:
                return new OrcKingdomFactory();
            default:
                throw new IllegalArgumentException("KingdomType not supported.");
        }
    }
}
