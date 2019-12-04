package comers_0890.httpsvk.zapiskz.module.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import comers_0890.httpsvk.zapiskz.App
import comers_0890.httpsvk.zapiskz.R
import comers_0890.httpsvk.zapiskz.model.Salon

class SalonAdapter(val items: MutableList<Salon>) : RecyclerView.Adapter<SalonAdapter.ViewHolder>() {

    var onItemClick: ((Salon) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.salon_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val salon = items[position]

        holder.type.text = salon.type
        holder.name.text = salon.name
        Glide.with(holder.image.context).load(App.LINK + salon.pictureUrl).into(holder.image)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        @BindView(R.id.type)
        lateinit var type: TextView
        @BindView(R.id.name)
        lateinit var name: TextView
        @BindView(R.id.image)
        lateinit var image: ImageView

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
            ButterKnife.bind(this, view)
        }
    }
}