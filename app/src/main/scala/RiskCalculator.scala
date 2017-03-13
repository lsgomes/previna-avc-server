/**
  * Created by dossluca on 04/03/2017.
  */
import java.text.{DecimalFormat, DecimalFormatSymbols}
import java.util.Locale
import javax.inject.Singleton


import scala.math.{exp, pow}

@Singleton
object RiskCalculator extends App {



  // 1 - (0.99982 ^ exp(score/10))
  private def calculateRiskFormula(score: Double): Double = {
    val division = score / 10
    val exponential = exp(division)
    val power = pow(0.99982, exponential)
    1 - power
  }

  private def formatWithoutScientificNotation(calculatedRisk: Double): String = {
    val decimalFormat = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH))
    decimalFormat.setMaximumFractionDigits(3) // 340 = DecimalFormat.DOUBLE_FRACTION_DIGITS
    decimalFormat.format(calculatedRisk)
  }

  private def calculateRiskPercentage(risk: Double): Double = {
    risk * 100
  }

  private def testRiskCalculator(): Unit = {
    val list = List(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105, 110)

    list.foreach(i => println(i + ": " + formatWithoutScientificNotation(calculateRiskFormula(i))))
    list.foreach(i => println(i + ": " + calculateRiskFormula(i)))
    list.foreach(i => println(i + ": " + calculateRiskPercentage(calculateRiskFormula(i))))
    list.foreach(i => println(i + ": " + formatWithoutScientificNotation(calculateRiskPercentage(calculateRiskFormula(i)))))
  }

  def calculateRiskPercentageRounded(score: Double): String = {
    formatWithoutScientificNotation(calculateRiskPercentage(calculateRiskFormula(score)))
  }

  def calculateAge(age: Integer): Integer = {
    if (age > 20) {
      return age - 20
    }
    0
  }

}

