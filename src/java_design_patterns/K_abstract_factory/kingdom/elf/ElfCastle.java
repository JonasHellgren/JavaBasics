package java_design_patterns.K_abstract_factory.kingdom.elf;

import java_design_patterns.K_abstract_factory.kingdom.Castle;

public class ElfCastle implements Castle {
    static final String DESCRIPTION = "This is the elven castle!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
