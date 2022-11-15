package be.positive.calculator.positivesplitcalculator.types;

import java.math.MathContext;

public class TypeCurveConstants {
    private final static String LOGARITMITIC = "logaratmitic";
    private final static String EXPONENTIAL = "exponential";
    private final static String SIMPLE_FUNCTION = "function";

    public static String getLogaritmitic() {
        return "log(b)[x]";
    }

    public static String getExponential() {
        return "e[x]";
    }

    public static String getFunction() {
        return "x";
    }
}
