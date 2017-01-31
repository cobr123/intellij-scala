package org.jetbrains.plugins.scala.failed.resolve

import com.intellij.openapi.module.Module
import org.jetbrains.plugins.scala.PerfCycleTests
import org.jetbrains.plugins.scala.base.libraryLoaders.{ScalaZCoreLoader, ThirdPartyLibraryLoader}
import org.junit.experimental.categories.Category

/**
  * Created by kate on 3/29/16.
  */

@Category(Array(classOf[PerfCycleTests]))
class ScalazTest extends FailedResolveTest("scalaz") {

  override protected def additionalLibraries(module: Module): Array[ThirdPartyLibraryLoader] =
    Array(ScalaZCoreLoader()(module))

  def testSCL7213(): Unit = doTest()

  def testSCL7227(): Unit = doTest()
}
