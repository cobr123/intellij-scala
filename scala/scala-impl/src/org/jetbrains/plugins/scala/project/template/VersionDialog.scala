package org.jetbrains.plugins.scala
package project
package template

import com.intellij.openapi.ui.Messages
import javax.swing.JComponent

/**
  * @author Pavel Fatin
  */
final class VersionDialog(parent: JComponent) extends VersionDialogBase(parent) {

  {
    init()

    setTitle("Download")
    myVersion.setTextRenderer(Version.abbreviate)

    Versions.loadScalaVersions("available ") match {
      case (Array(), _) =>
        Messages.showErrorDialog(
          createCenterPanel(),
          "No versions available for download",
          s"Error Downloading Scala libraries"
        )
      case (versions, _) => myVersion.setItems(versions)
    }
  }

  def showAndGetSelected(): Option[String] =
    if (showAndGet()) {
      val version = myVersion.getSelectedItem.asInstanceOf[String]

      import Downloader._
      extensions.withProgressSynchronouslyTry(s"Downloading Scala $version") { manager =>
        createTempSbtProject(
          version,
          new DownloadProcessAdapter(manager),
          setScalaSBTCommand(version),
          "updateClassifiers"
        )
      }.recover {
        case exception => Messages.showErrorDialog(
          parent,
          exception.getMessage,
          s"Error downloading Scala $version"
        )
      }.map { _ =>
        version
      }.toOption
    } else None
}
