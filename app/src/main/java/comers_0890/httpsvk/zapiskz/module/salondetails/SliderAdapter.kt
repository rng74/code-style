package comers_0890.httpsvk.zapiskz.module.salondetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import comers_0890.httpsvk.zapiskz.App
import comers_0890.httpsvk.zapiskz.R

class SliderAdapter(val items: MutableList<String>) : SliderViewAdapter<SliderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ava_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val image = items[position]
        Glide.with(viewHolder.ava.context).load(App.LINK + image).into(viewHolder.ava)
    }

    override fun getCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        @BindView(R.id.ava)
        lateinit var ava: ImageView

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}