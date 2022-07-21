package java_design_patterns.K_abstract_factory.kingdom.orc;

import java_design_patterns.K_abstract_factory.kingdom.Army;
import java_design_patterns.K_abstract_factory.kingdom.Castle;
import java_design_patterns.K_abstract_factory.kingdom.King;
import java_design_patterns.K_abstract_factory.kingdom.KingdomFactory;

public class OrcKingdomFactory implements KingdomFactory {
    @Override
    public Castle createCastle() {
        return new OrcCastle();
    }

    @Override
    public King createKing() {
        return new OrcKing();
    }

    @Override
    public Army createArmy() {
        return new OrcArmy();
    }
}
