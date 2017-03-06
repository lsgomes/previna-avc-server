/**
  * Created by dossluca on 04/03/2017.
  */
import java.text.{DecimalFormat, DecimalFormatSymbols}
import java.util.Locale
import javax.inject.Singleton

import scala.math.{exp, pow}

@Singleton
object RiskCalculator extends App{

  val decimalFormat = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH))
  decimalFormat.setMaximumFractionDigits(3) // 340 = DecimalFormat.DOUBLE_FRACTION_DIGITS

  // 1 - (0.99982 ^ exp(score/10))
  def calculateRiskFormula(score: Double): Double = {
    val division = score / 10
    val exponential = exp(division)
    val power = pow(0.99982, exponential)
    1 - power
  }

  def formatWithoutScientificNotation(calculatedRisk: Double): String = {
    decimalFormat.format(calculatedRisk)
  }

  def calculateRiskPercentage(risk: Double): Double = {
    risk * 100
  }

  def testRiskCalculator: Unit = {
    val list = List(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105, 110)

    list.foreach(i => println(i + ": " + formatWithoutScientificNotation(calculateRiskFormula(i))))
    list.foreach(i => println(i + ": " + calculateRiskFormula(i)))
    list.foreach(i => println(i + ": " + calculateRiskPercentage(calculateRiskFormula(i))))
    list.foreach(i => println(i + ": " + formatWithoutScientificNotation(calculateRiskPercentage(calculateRiskFormula(i)))))
  }

  def calculateHasAge(age: Int): Int = {
    if (age > 20) {
      return age - 20
    }
    0
  }
}

