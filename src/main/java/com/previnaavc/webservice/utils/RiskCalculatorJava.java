package com.previnaavc.webservice.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.inject.Singleton;

/**
 * Created by Lucas on 15/04/2017.
 */
@Singleton
public class RiskCalculatorJava {

    private static DecimalFormat decimalFormat = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

    static {
        decimalFormat.setMaximumFractionDigits(1); // 340 = DecimalFormat.DOUBLE_FRACTION_DIGITS
    }

    // 1 - (0.99982 ^ exp(score/10))
    private static Double calculateRiskFormula( Double score) {
        Double division = score / 10;
        Double exponential = Math.exp(division);
        Double power = Math.pow(0.99982, exponential);
        return 1 - power;
    }

    public static String calculateRiskPercentageRounded(Double score) {
        return formatWithoutScientificNotation(calculateRiskPercentage(calculateRiskFormula(score)));
    }

    private static Double calculateRiskPercentage(Double risk) {
        return risk * 100;
    }

    private static String formatWithoutScientificNotation(Double calculatedRisk) {
        return decimalFormat.format(calculatedRisk);
    }
}
