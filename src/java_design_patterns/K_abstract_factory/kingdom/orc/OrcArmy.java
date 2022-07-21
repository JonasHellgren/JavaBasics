package java_design_patterns.K_abstract_factory.kingdom.orc;

import java_design_patterns.K_abstract_factory.kingdom.Army;

public class OrcArmy implements Army {
    static final String DESCRIPTION = "This is the orc army!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
