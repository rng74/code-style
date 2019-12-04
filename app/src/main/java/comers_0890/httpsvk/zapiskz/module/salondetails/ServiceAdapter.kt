package comers_0890.httpsvk.zapiskz.module.salondetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import comers_0890.httpsvk.zapiskz.R
import comers_0890.httpsvk.zapiskz.model.Service

class ServiceAdapter(val items: MutableList<Service>) : RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.service_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val service = items[position]

        holder.title.text = service.name
        holder.cost.text = service.priceStr

        var hour = service.duration / 60
        var minute = service.duration % 60
        var result = ""

        if (hour > 0) {
            result += holder.cost.context.getString(R.string.duration_hour, hour.toString())
        }
        if (minute > 0) {
            result += if (result != "") " " else ""
            result += holder.cost.context.getString(R.string.duration_minute, minute.toString())
        }
        holder.duration.text = result
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        @BindView(R.id.service_name)
        lateinit var title: TextView
        @BindView(R.id.service_duration)
        lateinit var duration: TextView
        @BindView(R.id.service_cost)
        lateinit var cost: TextView

        init {
            ButterKnife.bind(this, view)
        }
    }
}