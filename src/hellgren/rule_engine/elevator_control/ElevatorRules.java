package hellgren.rule_engine.elevator_control;

import lombok.extern.java.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Log
public class ElevatorRules {
    private static final int BACKUP = 0;
    private static final int POS_BETWEEN = 10;
    private static final int TOP_POS = 30;
    private static final int BOTTOM_POS = 0;

    Map<BiPredicate<Integer,Integer>, BiFunction<Integer,Integer,Integer>> decisionTable;
    Random random = new Random();

    public ElevatorRules() {
        decisionTable=new HashMap<>();
        decisionTable.put( (s,p) -> isMovingUp(s) && !isAtFloor(p) ,(s, p) -> 1);  //moving up, not at floor
        decisionTable.put( (s,p) -> isMovingUp(s) && isAtFloor(p),(s, p) -> 0);  //moving up, at floor
        decisionTable.put( (s,p) -> isStill(s) && isAtFloor(p) && !isAtTop(p),(s, p) -> 1);  //still, at floor, not at top floor
        decisionTable.put( (s,p) -> isStill(s) && isAtFloor(p) && isAtTop(p),(s, p) -> -1);  //still, at floor, at top floor
        decisionTable.put( (s,p) -> isMovingDown(s) && !isAtFloor(p) ,(s, p) -> -1);  //moving down, not at floor
        decisionTable.put( (s,p) -> isMovingDown(s) && isAtFloor(p),(s, p) -> 0);  //moving down, at floor
        decisionTable.put( (s,p) -> isStill(s) && isAtFloor(p) && !isAtBottom(p),(s, p) -> -1);  //still, at floor, not at bottom floor
        decisionTable.put( (s,p) -> isStill(s) && isAtFloor(p) && isAtBottom(p),(s, p) -> 1);  //still, at floor, at bottom floor

    }

    private boolean isAtTop(Integer p) {
        return p == TOP_POS;
    }

    private boolean isAtBottom(Integer p) {
        return p == BOTTOM_POS;
    }

    private boolean isStill(Integer s) {
        return s == 0;
    }

    private boolean isMovingUp(Integer s) {
        return s == 1;
    }

    private boolean isMovingDown(Integer s) {
        return s == -1;
    }

    private boolean isAtFloor(Integer p) {
        return p % POS_BETWEEN == 0;
    }

    public  Integer process(Integer speed, Integer pos) {

        List<BiFunction<Integer,Integer,Integer>> fcnList=decisionTable.entrySet().stream()
                .filter(e -> e.getKey().test(speed,pos))
                .map(e -> e.getValue())
                .collect(Collectors.toList());

        if (fcnList.size()>1) {
            log.warning("Multiple matching rules, nof ="+fcnList.size());

            return fcnList.get(getRandom(0, fcnList.size())+1).apply(speed,pos);
        }

        if (fcnList.size()==0) {
            log.warning("No matching rule, using backup");
            return BACKUP;
        }

        return fcnList.get(0).apply(speed,pos);
    }

    //The min parameter (the origin) is inclusive, whereas the upper bound max is exclusive.
    private int getRandom(int min, int max) {
        return random.nextInt(max - min) + min;
    }


}
