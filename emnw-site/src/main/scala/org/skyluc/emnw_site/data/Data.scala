package org.skyluc.emnw_site.data

import org.skyluc.emnw_site.data.checks.LocalAssetExistsChecker
import org.skyluc.fan_resources.data as fr
import org.skyluc.reference.html.edit.EditSupportContext

import fr.Path
import fr.checks.DataCheck
import fr.checks.ReferencesChecker
import fr.checks.ReferencesCheckProcessorBuilder
import fr.op.ImplicitDatumExpanderProcessor

object Data {

  val dispatcherBuilder = new fr.op.DataDispatcherBuilder {

    override def build(dataBuilder: fr.op.DataProcessor): fr.op.DataDispatcher =
      fr.op.DataDispatcher(dataBuilder)

  }

  val implicitDataExpander = new fr.op.ImplicitDataExpander {

    override val expanderProcessor: ImplicitDatumExpanderProcessor = fr.op.ImplicitDatumExpanderProcessor()

  }

  val defaultExpanders = fr.op.DataLoader.defaultExpanders(implicitDataExpander)

  val defaultPopulaters =
    fr.op.DataLoader.defaultPopulaters(fr.op.MultimediaExtraPopulater(fr.op.MultimediaExtraProcessBuilder()))

  def defaultCheckers(staticFolderPath: Path) = DataCheck.defaultCheckers(
    ReferencesChecker(ReferencesCheckProcessorBuilder()),
    LocalAssetExistsChecker(staticFolderPath),
  )

  val editSupportContext = new EditSupportContext {}

}
