package java_design_patterns.K_abstract_factory.kingdom.elf;

import java_design_patterns.K_abstract_factory.kingdom.King;

public class ElfKing implements King {
    static final String DESCRIPTION = "This is the elven king!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
