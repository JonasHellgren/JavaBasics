package java_design_patterns.K_abstract_factory.kingdom;

public interface KingdomFactory {
    Castle createCastle();
    King createKing();
    Army createArmy();
}
