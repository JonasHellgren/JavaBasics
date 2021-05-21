package com.pluralsight.CalcEngine5;

public class PowerOf implements MathProcessing {
    //define methods "requested" by interface MathProcessing
    @Override
    public String getKeyword() {     return "power";   }

    @Override
    public char getSymbol() {  return '^';     }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return Math.pow(leftVal,rightVal);    }
}
