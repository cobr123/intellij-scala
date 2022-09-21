package org.jetbrains.plugins.scala.codeInspection.collections

import org.jetbrains.plugins.scala.codeInspection.ScalaInspectionBundle

class OptionToStringInspectionTest extends OperationsOnCollectionInspectionTest {

  override protected val classOfInspection: Class[_ <: OperationOnCollectionInspection] =
    classOf[OptionToStringInspection]

  override protected val hint: String = ScalaInspectionBundle.message("option.mkString.hint")

  def testNone(): Unit = {
    doTest(
      s"""None.${START}toString$END""",
      """None.toString""",
      """None.mkString"""
    )
  }

  def testOptionVal(): Unit = {
    doTest(
      s"""val i = Option("hello"); i.${START}toString$END""",
      """val i = Option("hello"); i.toString""",
      """val i = Option("hello"); i.mkString"""
    )
  }

  def testOptionValInObject(): Unit = {
    doTest(
      s"""object Test { val i = Option("hello"); i.${START}toString$END }""",
      """object Test { val i = Option("hello"); i.toString }""",
      """object Test { val i = Option("hello"); i.mkString }"""
    )
  }

  def testFunctionExpression(): Unit = {
    doTest(
      s"""sys.env.get("VARIABLE").${START}toString$END""",
      """sys.env.get("VARIABLE").toString""",
      """sys.env.get("VARIABLE").mkString"""
    )
  }

  def testSomeConstant(): Unit = {
    doTest(
      s"""Some("constant").${START}toString$END""",
      """Some("constant").toString""",
      """Some("constant").mkString"""
    )
  }

  def testOptionConstant(): Unit = {
    doTest(
      s"""Option("constant").${START}toString$END""",
      """Option("constant").toString""",
      """Option("constant").mkString"""
    )
  }

  def testOptionValNotString(): Unit = {
    doTest(
      s"""val i = Option(1); i.${START}toString$END""",
      """val i = Option(1); i.toString""",
      """val i = Option(1); i.mkString"""
    )
  }

  def testFunctionExpressionNotString(): Unit = {
    doTest(
      s"""def getSomeOne():Option[Int] = Some(1); getSomeOne().${START}toString$END""",
      """def getSomeOne():Option[Int] = Some(1); getSomeOne().toString""",
      """def getSomeOne():Option[Int] = Some(1); getSomeOne().mkString"""
    )
  }

  def testSomeConstantNotString(): Unit = {
    doTest(
      s"""Some(1).${START}toString$END""",
      """Some(1).toString""",
      """Some(1).mkString"""
    )
  }

  def testOptionConstantNotString(): Unit = {
    doTest(
      s"""Option(1).${START}toString$END""",
      """Option(1).toString""",
      """Option(1).mkString"""
    )
  }

  def testPrint(): Unit = {
    doTest(
      s"""
         |println(${START}Option(3)$END)
       """.stripMargin,
      """
        |println(Option(3))
      """.stripMargin,
      """
        |println(Option(3).mkString)
      """.stripMargin)
  }

  def testSystemPrint(): Unit = {
    doTest(
      s"""
         |System.out.println(${START}Option(3)$END)
       """.stripMargin,
      """
        |System.out.println(Option(3))
      """.stripMargin,
      """
        |System.out.println(Option(3).mkString)
      """.stripMargin)
  }

  def testInterpolatedString(): Unit = {
    doTest(
      s"""
         |val a = Option(3)
         |s"before $$${START}a$END after"
       """.stripMargin,
      """
        |val a = Option(3)
        |s"before $a after"
      """.stripMargin,
      """
        |val a = Option(3)
        |s"before ${a.mkString} after"
      """.stripMargin)
  }

  def testBlockInInterpolatedString(): Unit = {
    doTest(
      s"""
         |val a = Option(3)
         |s"before $${${START}a$END} after"
       """.stripMargin,
      """
        |val a = Option(3)
        |s"before ${a} after"
      """.stripMargin,
      """
        |val a = Option(3)
        |s"before ${a.mkString} after"
      """.stripMargin)
  }

  def testAny2String(): Unit = {
    doTest(
      s"""
         |val a = Option(3)
         |${START}a$END + "test"
       """.stripMargin,
      """
        |val a = Option(3)
        |a + "test"
      """.stripMargin,
      """
        |val a = Option(3)
        |a.mkString + "test"
      """.stripMargin)
  }

  def testAddToString(): Unit = {
    doTest(
      s"""
         |val a = Option(3)
         |"test" + ${START}a$END
       """.stripMargin,
      """
        |val a = Option(3)
        |"test" + a
      """.stripMargin,
      """
        |val a = Option(3)
        |"test" + a.mkString
      """.stripMargin)
  }

  def testStringFormat(): Unit = {
    doTest(
      s"""
         |String.format("formatted: %s", ${START}Option(1)$END)
       """.stripMargin,
      """
        |String.format("formatted: %s", Option(1))
      """.stripMargin,
      """
        |String.format("formatted: %s", Option(1).mkString)
      """.stripMargin)
  }

  def testFormatOnString(): Unit = {
    doTest(
      s"""
         |"formatted: %s".format(${START}Option(1)$END)
       """.stripMargin,
      """
        |"formatted: %s".format(Option(1))
      """.stripMargin,
      """
        |"formatted: %s".format(Option(1).mkString)
      """.stripMargin)
  }

  def testFormattedOnString(): Unit = {
    doTest(
      s"""
         |"formatted: %s".formatted(${START}Option(1)$END)
       """.stripMargin,
      """
        |"formatted: %s".formatted(Option(1))
      """.stripMargin,
      """
        |"formatted: %s".formatted(Option(1).mkString)
      """.stripMargin)
  }

  def testFormatted(): Unit = {
    doTest(
      s"""
         |${START}Option(1)$END.formatted("formatted: %s")
       """.stripMargin,
      """
        |Option(1).formatted("formatted: %s")
      """.stripMargin,
      """
        |Option(1).mkString.formatted("formatted: %s")
      """.stripMargin)
  }

  def testAppendOnJavaStringBuilder(): Unit = {
    doTest(
      s"""
         |val b = new java.lang.StringBuilder
         |b.append(${START}Option(1)$END)
       """.stripMargin,
      """
        |val b = new java.lang.StringBuilder
        |b.append(Option(1))
      """.stripMargin,
      """
        |val b = new java.lang.StringBuilder
        |b.append(Option(1).mkString)
      """.stripMargin)
  }

  def testAppendOnScalaStringBuilder(): Unit = {
    doTest(
      s"""
         |val b = new scala.collection.mutable.StringBuilder
         |b.append(${START}Option(1)$END)
       """.stripMargin,
      """
        |val b = new scala.collection.mutable.StringBuilder
        |b.append(Option(1))
      """.stripMargin,
      """
        |val b = new scala.collection.mutable.StringBuilder
        |b.append(Option(1).mkString)
      """.stripMargin)
  }
}
