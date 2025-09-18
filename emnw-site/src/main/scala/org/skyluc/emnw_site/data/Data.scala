package org.skyluc.emnw_site.data

import org.skyluc.emnw_site.data.checks.LocalAssetExistsChecker
import org.skyluc.fan_resources.data as fr
import org.skyluc.reference.html.edit.EditSupportContext

import fr.op.ImplicitDatumExpander
import fr.Path
import fr.checks.DataCheck
import fr.checks.ReferencesChecker
import fr.checks.ReferencesCheckProcessorBuilder

object Data {

  val dispatcherBuilder = new fr.op.DataDispatcherBuilder {

    override def build(dataBuilder: fr.op.DataProcessor): fr.op.DataDispatcher =
      fr.op.DataDispatcher(dataBuilder)

  }

  val defaultExpanders = fr.op.DataLoader.defaultExpanders(fr.op.ImplicitDatumExpander())

  val defaultPopulaters =
    fr.op.DataLoader.defaultPopulaters(fr.op.MultimediaExtraPopulater(fr.op.MultimediaExtraProcessBuilder()))

  def defaultCheckers(staticFolderPath: Path) = DataCheck.defaultCheckers(
    ReferencesChecker(ReferencesCheckProcessorBuilder()),
    LocalAssetExistsChecker(staticFolderPath),
  )

  val editSupportContext = new EditSupportContext {}

}
