package org.skyluc.emnw_site.data.checks

import org.skyluc.emnw_site.Main
import org.skyluc.fan_resources.data.Path
import org.skyluc.fan_resources.data.checks as fr

class LocalAssetExistsChecker(staticFolderPath: Path)
    extends fr.LocalAssetExistsChecker(
      fr.LocalAssetExistsProcessor(staticFolderPath.resolve(Main.BASE_IMAGE_ASSET_PATH))
    )
