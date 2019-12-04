package comers_0890.httpsvk.zapiskz.common.di

import comers_0890.httpsvk.zapiskz.common.Api
import comers_0890.httpsvk.zapiskz.common.TokenKeeper
import comers_0890.httpsvk.zapiskz.module.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(activity: MainActivity)
    fun getApi(): Api
    fun getTokenKeeper(): TokenKeeper
}