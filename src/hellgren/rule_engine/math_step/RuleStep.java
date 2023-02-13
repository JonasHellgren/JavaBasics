package hellgren.rule_engine.math_step;

import tec.units.ri.internal.MathUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RuleStep {

    private static final double DEFAULT = 0d;
    Map<Predicate<Double>, Function<Double,Double>> decisionTable;

    public RuleStep() {
        decisionTable=new HashMap<>();
        decisionTable.put(d -> d <0,d -> 0d);
        decisionTable.put(d -> d >= 0 && d <= 1, d -> d);
        decisionTable.put(d -> d > 1 ,d -> 1d);
    }

    public  Double process(Double num) {

        List<Function<Double,Double>> fcnList=decisionTable.entrySet().stream()
                .filter(e -> e.getKey().test(num))
                .map(e -> e.getValue())
                .collect(Collectors.toList());

        if (fcnList.size()>1) {
            throw new RuntimeException("Multiple matching rules, nof ="+fcnList.size());
        }

        if (fcnList.size()==0) {
            return DEFAULT;
        }

        return fcnList.get(0).apply(num);
    }
    
}
