package java_design_patterns.K_abstract_factory.kingdom.orc;

import java_design_patterns.K_abstract_factory.kingdom.Castle;

public class OrcCastle implements Castle {
    static final String DESCRIPTION = "This is the orc castle!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
