package comers_0890.httpsvk.zapiskz.common

import com.arellomobile.mvp.MvpPresenter
import comers_0890.httpsvk.zapiskz.App
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class AbstractPresenter<T : BaseView> : MvpPresenter<T>() {
    protected var api: Api = App.API_COMPONENT.getApi()
    private var subscriptions = CompositeDisposable()

    fun addSubscription(disposable: Disposable) {
        subscriptions.add(disposable)
    }

    fun disposeAll() {
        subscriptions.clear()
        subscriptions = CompositeDisposable()
    }
}