package java_design_patterns.K_abstract_factory_test;

import java_design_patterns.K_abstract_factory.kingdom.*;
import java_design_patterns.K_abstract_factory.kingdom.elf.ElfArmy;
import java_design_patterns.K_abstract_factory.kingdom.elf.ElfCastle;
import java_design_patterns.K_abstract_factory.kingdom.elf.ElfKing;
import org.junit.Assert;
import org.junit.Test;

public class TestKingdomFactoryMaker {

    @Test
    public void testMakeElfKingdom()  {

        KingdomFactory factory = KingdomFactoryMaker.makeFactory(KingdomType.ELF);
        King king=factory.createKing();
        Castle castle=factory.createCastle();
        Army army=factory.createArmy();

        Assert.assertTrue(king instanceof ElfKing);
        Assert.assertTrue(castle instanceof ElfCastle);
        Assert.assertTrue(army instanceof ElfArmy);

    }
}
