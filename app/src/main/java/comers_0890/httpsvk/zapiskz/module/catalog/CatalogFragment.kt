package comers_0890.httpsvk.zapiskz.module.catalog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.arellomobile.mvp.presenter.InjectPresenter
import comers_0890.httpsvk.zapiskz.R
import comers_0890.httpsvk.zapiskz.common.BaseFragment
import comers_0890.httpsvk.zapiskz.model.Salon
import comers_0890.httpsvk.zapiskz.module.salondetails.SalonDetailsActivity

class CatalogFragment : BaseFragment<CatalogView, CatalogPresenter>(), CatalogView {
    @InjectPresenter
    lateinit var catalogPresenter: CatalogPresenter

    @BindView(R.id.recommended_list)
    lateinit var recommendationList: RecyclerView
    @BindView(R.id.popular_list)
    lateinit var popularList: RecyclerView
    @BindView(R.id.loading)
    lateinit var loadingPlane: View


    private val adapter = SalonAdapter(mutableListOf())
    private val adapterPopular = SalonAdapter(mutableListOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_catalog, container, false)

        ButterKnife.bind(this, view)

        createDialog()

        if (savedInstanceState == null) {
            loadingPlane.visibility = View.VISIBLE
            loading(true)
            catalogPresenter.getRecommended()
            catalogPresenter.getPopular()
        }

        adapter.onItemClick = {
            val intent = Intent(context, SalonDetailsActivity::class.java).apply {
                putExtra("id", it.id)
            }
            startActivity(intent)
        }

        adapterPopular.onItemClick = {
            val intent = Intent(context, SalonDetailsActivity::class.java).apply {
                putExtra("id", it.id)
            }
            startActivity(intent)
        }

        popularList.adapter = adapterPopular
        popularList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recommendationList.adapter = adapter
        recommendationList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        return view
    }

    private fun checkLoad() {
        if (adapter.items.size > 0 && adapterPopular.items.size > 0) {
            loadingPlane.visibility = View.GONE
            loading(false)
        }
    }

    override fun showRecommended(list: MutableList<Salon>) {
        val prevSize = adapter.items.size
        adapter.items.addAll(list)
        adapter.notifyItemRangeInserted(prevSize, list.size)
        checkLoad()
    }

    override fun showPopular(list: MutableList<Salon>) {
        val prevSize = adapterPopular.items.size
        adapterPopular.items.addAll(list)
        adapterPopular.notifyItemRangeInserted(prevSize, list.size)
        checkLoad()
    }

    override fun getPresenter(): CatalogPresenter {
        return catalogPresenter
    }

    override fun getTitle(): Int {
        return R.string.catalog_fragment
    }

    companion object {
        @JvmStatic
        fun newInstance() = CatalogFragment()
    }
}