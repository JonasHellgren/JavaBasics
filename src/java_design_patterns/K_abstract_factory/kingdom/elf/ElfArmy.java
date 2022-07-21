package java_design_patterns.K_abstract_factory.kingdom.elf;

import java_design_patterns.K_abstract_factory.kingdom.Army;

public class ElfArmy implements Army {
    static final String DESCRIPTION = "This is the elven army!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
