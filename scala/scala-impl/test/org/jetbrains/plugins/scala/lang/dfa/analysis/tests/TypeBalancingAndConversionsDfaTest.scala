package org.jetbrains.plugins.scala.lang.dfa.analysis.tests

import org.jetbrains.plugins.scala.lang.dfa.Messages._
import org.jetbrains.plugins.scala.lang.dfa.analysis.ScalaDfaTestBase

class TypeBalancingAndConversionsDfaTest extends ScalaDfaTestBase {

  def testImplicitConversionsInBinaryOperators(): Unit = test(codeFromMethodBody(returnType = "Boolean") {
    """
      |1 + 2L == 3L
      |1L + 2 == 3L
      |val x = 3L
      |x == 3L
      |4L * 4 == 16L
      |3 > 2.7
      |2.2 > 10
      |3 > 2L
      |5L < 3
      |5 == 5L
      |2.5 > 2
      |""".stripMargin
  })(
    "1 + 2L == 3L" -> ConditionAlwaysTrue,
    "1L + 2 == 3L" -> ConditionAlwaysTrue,
    "x == 3L" -> ConditionAlwaysTrue,
    "4L * 4 == 16L" -> ConditionAlwaysTrue,
    "3 > 2.7" -> ConditionAlwaysTrue,
    "2.2 > 10" -> ConditionAlwaysFalse,
    "3 > 2L" -> ConditionAlwaysTrue,
    "5L < 3" -> ConditionAlwaysFalse,
    "5 == 5L" -> ConditionAlwaysTrue,
    "2.5 > 2" -> ConditionAlwaysTrue
  )
}
