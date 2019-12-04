package comers_0890.httpsvk.zapiskz.module.catalog

import com.arellomobile.mvp.InjectViewState
import comers_0890.httpsvk.zapiskz.common.AbstractPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class CatalogPresenter : AbstractPresenter<CatalogView>() {
    fun getRecommended() {
        val dis = api.getRecommended()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                viewState.showRecommended(it.salons)
            }, {
                /** showError call **/
            })

        addSubscription(dis)
    }

    fun getPopular() {
        val dis = api.getPopular()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                viewState.showPopular(it.salons)
            }, {
                /** showError call **/
            })

        addSubscription(dis)
    }
}