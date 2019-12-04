package comers_0890.httpsvk.zapiskz.module.catalog

import comers_0890.httpsvk.zapiskz.common.BaseView
import comers_0890.httpsvk.zapiskz.model.Salon

interface CatalogView : BaseView {
    fun showRecommended(list: MutableList<Salon>)
    fun showPopular(list: MutableList<Salon>)
}