package comers_0890.httpsvk.zapiskz.module.salondetails

import com.arellomobile.mvp.InjectViewState
import comers_0890.httpsvk.zapiskz.common.AbstractPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class SalonDetailsPresenter : AbstractPresenter<SalonDetailsView>() {
    fun getDetails(id: Int) {
        // TODO: add loading
        val dis = api.getDetails(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                viewState.showDetails(it)
            }, {
                /** showError call **/
            })

        addSubscription(dis)
    }
}