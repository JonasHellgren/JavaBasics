package com.pluralsight.CalcEngine5;

public class DynamicHelper {
    //private variable, array of process handlers
    //a handler refers to a class managing addition, power etc
    private MathProcessing[] handlers;

    //Constructor
    public DynamicHelper(MathProcessing[] handlers)  { this.handlers=handlers;  }

    //The following method do for ex convert  add 1.0 2.0  to 1.0 + 2.0 = 3.0
    public String process(String statement)  {
        String[] parts = statement.split(MathProcessing.SEPERATOR);
        String keyword = parts[0];  //eg add
        MathProcessing theHandler = null;

        //find handler that manage keyword
        for (MathProcessing handler:handlers)    {
         if (keyword.equalsIgnoreCase((handler.getKeyword()))) {
             theHandler = handler;  break;    }
        }

        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
        double result = theHandler.doCalculation(leftVal,rightVal);

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal); sb.append(MathProcessing.SPACE); sb.append(theHandler.getSymbol());
        sb.append(MathProcessing.SPACE);   sb.append(rightVal); sb.append(MathProcessing.SPACE); sb.append('=');
        sb.append(MathProcessing.SPACE);  sb.append(result);
        return sb.toString();

    }

}
