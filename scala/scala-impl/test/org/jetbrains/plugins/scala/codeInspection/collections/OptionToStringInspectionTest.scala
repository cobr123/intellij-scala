package org.jetbrains.plugins.scala.codeInspection.collections

import org.jetbrains.plugins.scala.codeInspection.ScalaInspectionBundle
import org.junit.Assert.assertEquals

class OptionToStringInspectionTest extends OperationsOnCollectionInspectionTest {

  override protected val classOfInspection: Class[_ <: OperationOnCollectionInspection] =
    classOf[OptionToStringInspection]

  override protected val hint: String = ScalaInspectionBundle.message("option.getOrElse.hint")

  def testNone(): Unit = {
    try {
      doTest(
        s"""${START}None.toString$END""",
        """None.toString""",
        """None.toString"""
      )
    } catch {
      case e: AssertionError => assertEquals(e.getMessage, "Highlights not found: Replace with getOrElse(defaultValue)")
    }
  }

  def testOptionVal(): Unit = {
    doTest(
      s"""val i = Option("hello"); ${START}i.toString$END""",
      """val i = Option("hello"); i.toString""",
      """val i = Option("hello"); i.getOrElse(throw new NoSuchElementException())"""
    )
  }

  def testFunctionExpression(): Unit = {
    doTest(
      s"""${START}sys.env.get("VARIABLE").toString$END""",
      """sys.env.get("VARIABLE").toString""",
      """sys.env.get("VARIABLE").getOrElse(throw new NoSuchElementException())"""
    )
  }

  def testSomeConstant(): Unit = {
    doTest(
      s"""${START}Some("constant").toString$END""",
      """Some("constant").toString""",
      """Some("constant").getOrElse(throw new NoSuchElementException())"""
    )
  }

  def testOptionConstant(): Unit = {
    doTest(
      s"""${START}Option("constant").toString$END""",
      """Option("constant").toString""",
      """Option("constant").getOrElse(throw new NoSuchElementException())"""
    )
  }

  def testOptionValNotString(): Unit = {
    doTest(
      s"""val i = Option(1); ${START}i.toString$END""",
      """val i = Option(1); i.toString""",
      """val i = Option(1); i.map(_.toString).getOrElse(throw new NoSuchElementException())"""
    )
  }

  def testFunctionExpressionNotString(): Unit = {
    doTest(
      s"""def getSomeOne():Option[Int] = Some(1); ${START}getSomeOne().toString$END""",
      """def getSomeOne():Option[Int] = Some(1); getSomeOne().toString""",
      """def getSomeOne():Option[Int] = Some(1); getSomeOne().map(_.toString).getOrElse(throw new NoSuchElementException())"""
    )
  }

  def testSomeConstantNotString(): Unit = {
    doTest(
      s"""${START}Some(1).toString$END""",
      """Some(1).toString""",
      """Some(1).map(_.toString).getOrElse(throw new NoSuchElementException())"""
    )
  }

  def testOptionConstantNotString(): Unit = {
    doTest(
      s"""${START}Option(1).toString$END""",
      """Option(1).toString""",
      """Option(1).map(_.toString).getOrElse(throw new NoSuchElementException())"""
    )
  }

}
