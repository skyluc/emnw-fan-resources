package org.skyluc.emnw_site.html

import org.skyluc.fan_resources.Common
import org.skyluc.fan_resources.data.Path
import org.skyluc.fan_resources.html.LocalImageCopyCompiledData
import org.skyluc.fan_resources.html.Url

object Site {

  val MISSING_URL = Url("/")
  val MISSING_IMAGE_URL = Url(
    Path("asset", "image", "site", "logo-ph.png")
  )
  val MISSING_IMAGE = LocalImageCopyCompiledData(MISSING_IMAGE_URL, Common.MISSING)

}
