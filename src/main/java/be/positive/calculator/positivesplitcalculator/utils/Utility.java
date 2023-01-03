package be.positive.calculator.positivesplitcalculator.utils;

import org.apache.commons.lang3.StringUtils;

public class Utility {

    private Utility() {}

    public static String convertNullEmptyToSomethingOrLowerCaseAndTrim(String stringToConvert) {
        return StringUtils.isEmpty(stringToConvert) ? "" : StringUtils.lowerCase(stringToConvert).trim();
    }
}
