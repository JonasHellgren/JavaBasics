package java_design_patterns.K_abstract_factory.kingdom.orc;

import java_design_patterns.K_abstract_factory.kingdom.King;

public class OrcKing implements King {
    static final String DESCRIPTION = "This is the orc king!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
