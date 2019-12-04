package comers_0890.httpsvk.zapiskz.module.search

import com.arellomobile.mvp.presenter.InjectPresenter
import comers_0890.httpsvk.zapiskz.R
import comers_0890.httpsvk.zapiskz.common.BaseFragment

class SearchFragment : BaseFragment<SearchView, SearchPresenter>(), SearchView {
    @InjectPresenter
    lateinit var searchPresenter: SearchPresenter

    override fun getPresenter(): SearchPresenter {
        return searchPresenter
    }

    override fun getTitle(): Int {
        return R.string.search_fragment
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}