package comers_0890.httpsvk.zapiskz

import android.app.Application
import comers_0890.httpsvk.zapiskz.common.di.ApiComponent
import comers_0890.httpsvk.zapiskz.common.di.DaggerApiComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        API_COMPONENT = DaggerApiComponent.create()
        LINK = "http://zp.jgroup.kz"
    }

    companion object {
        lateinit var API_COMPONENT: ApiComponent
        lateinit var LINK: String
    }
}