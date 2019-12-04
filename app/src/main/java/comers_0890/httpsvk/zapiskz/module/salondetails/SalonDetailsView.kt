package comers_0890.httpsvk.zapiskz.module.salondetails

import comers_0890.httpsvk.zapiskz.common.BaseView
import comers_0890.httpsvk.zapiskz.model.response.SalonDetailResponse

interface SalonDetailsView : BaseView {
    fun showDetails(info: SalonDetailResponse)
}