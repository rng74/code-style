package comers_0890.httpsvk.zapiskz.common

import android.app.AlertDialog
import com.arellomobile.mvp.MvpAppCompatFragment
import comers_0890.httpsvk.zapiskz.R

abstract class BaseFragment<V : BaseView, P : AbstractPresenter<V>> : MvpAppCompatFragment(), BaseView {
    lateinit var ringProgressDialog: AlertDialog

    fun createDialog() {
        ringProgressDialog = AlertDialog.Builder(this.context)
            .setView(R.layout.loading_dialog)
            .setCancelable(false)
            .create()
        ringProgressDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
    }

    fun loading(load: Boolean) {
        if (load) {
            ringProgressDialog.show()
        } else {
            ringProgressDialog.dismiss()
        }
    }

    abstract fun getPresenter(): P

    abstract fun getTitle(): Int
}