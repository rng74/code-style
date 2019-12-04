package comers_0890.httpsvk.zapiskz.module.profile

import com.arellomobile.mvp.presenter.InjectPresenter
import comers_0890.httpsvk.zapiskz.R
import comers_0890.httpsvk.zapiskz.common.BaseFragment

class ProfileFragment : BaseFragment<ProfileView, ProfilePresenter>(), ProfileView {
    @InjectPresenter
    lateinit var profilePresenter: ProfilePresenter

    override fun getPresenter(): ProfilePresenter {
        return profilePresenter
    }

    override fun getTitle(): Int {
        return R.string.profile_fragment
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}