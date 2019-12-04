package comers_0890.httpsvk.zapiskz.module.salondetails

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import comers_0890.httpsvk.zapiskz.R
import comers_0890.httpsvk.zapiskz.model.Salon
import comers_0890.httpsvk.zapiskz.model.response.SalonDetailResponse
import kotlinx.android.synthetic.main.activity_salondetail.*
import kotlinx.android.synthetic.main.content_ava.*
import kotlinx.android.synthetic.main.content_main_info.*
import kotlinx.android.synthetic.main.content_service.*

class SalonDetailsActivity : MvpAppCompatActivity(), SalonDetailsView {
    @InjectPresenter
    lateinit var detailsPresenter: SalonDetailsPresenter

    private val sliderAdapter = SliderAdapter(mutableListOf())
    private val serviceAdapter = ServiceAdapter(mutableListOf())

    lateinit var ringProgressDialog: AlertDialog

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salondetail)

        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        imageSlider.sliderAdapter = sliderAdapter
        service_list.adapter = serviceAdapter
        service_list.layoutManager = LinearLayoutManager(applicationContext)
        service_list.isNestedScrollingEnabled = false

        createDialog()

        if (savedInstanceState == null) {
            val bundle: Bundle? = intent.extras
            val id = bundle!!.getInt("id")
            loading(true)
            detailsPresenter.getDetails(id)
        }
    }

    override fun showDetails(info: SalonDetailResponse) {
        sliderAdapter.items.addAll(info.salon.pictures)
        sliderAdapter.notifyDataSetChanged()

        serviceAdapter.items.addAll(info.services)
        serviceAdapter.notifyDataSetChanged()

        name.text = info.salon.name
        type.text = info.salon.type
        address.text = HtmlCompat.fromHtml(info.salon.address, HtmlCompat.FROM_HTML_MODE_LEGACY)
        average_rating.text = info.salon.averageRating.toString()

        loading(false)
    }

    private fun createDialog() {
        ringProgressDialog = AlertDialog.Builder(this)
            .setView(R.layout.loading_dialog)
            .setCancelable(false)
            .create()
        ringProgressDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
    }

    private fun loading(load: Boolean) {
        if (load) {
            loading.visibility = View.VISIBLE
            ringProgressDialog.show()
        } else {
            loading.visibility = View.GONE
            ringProgressDialog.dismiss()
        }
    }
}