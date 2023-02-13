
package hellgren.rule_engine.predicate_function_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ErrorCodeUtilIfElse {

    private static final String NOT_KNOWN_ERROR = "Not known error";

    public static String handleError(String errorCode) {
        if (errorCode.equals("1")) {
            return "Very bad error";
        } else if (errorCode.equals("2")) {
            return "Very very bad error";
        } else {
            return "Not known error";
        }
    }

    Map<Predicate<String>, Function<String,String>> decisionTable;

    public ErrorCodeUtilIfElse() {
        decisionTable = new HashMap<>();
        decisionTable.put(s -> s.equals("1"), s -> "Very bad error");
        decisionTable.put(s -> s.equals("2"), s -> "Very very bad error");
    }

    public  String handleErrorDecTable(String errorCode) {

        List<String> stringList=new ArrayList<>();
        for (Map.Entry<Predicate<String>, Function<String,String>> entry: decisionTable.entrySet()){
            Predicate<String> condition = entry.getKey();
            Function<String,String> action = entry.getValue();
            if (condition.test(errorCode)) {
                stringList.add(action.apply(errorCode));
            }
        }

        if (stringList.size()>1) {
            throw new RuntimeException("Multiple matching rules, nof ="+stringList.size());
        }

        if (stringList.size()==0) {
            return NOT_KNOWN_ERROR;
        }

        return stringList.get(0);
    }

    public  String handleErrorDecTableStreams(String errorCode) {

        List<Function<String,String>> fcnList=decisionTable.entrySet().stream()
                .filter(e -> e.getKey().test(errorCode))
                .map(e -> e.getValue())
                .collect(Collectors.toList());

        if (fcnList.size()>1) {
            throw new RuntimeException("Multiple matching rules, nof ="+fcnList.size());
        }

        if (fcnList.size()==0) {
            return NOT_KNOWN_ERROR;
        }

        return  fcnList.get(0).apply(errorCode);


    }

}
