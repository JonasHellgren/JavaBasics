package java_design_patterns.K_abstract_factory.kingdom.elf;

import java_design_patterns.K_abstract_factory.kingdom.Army;
import java_design_patterns.K_abstract_factory.kingdom.Castle;
import java_design_patterns.K_abstract_factory.kingdom.King;
import java_design_patterns.K_abstract_factory.kingdom.KingdomFactory;

public class ElfKingdomFactory implements KingdomFactory {
    @Override
    public Castle createCastle() {
        return new ElfCastle();
    }

    @Override
    public King createKing() {
        return new ElfKing();
    }

    @Override
    public Army createArmy() {
        return new ElfArmy();
    }
}
