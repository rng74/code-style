package comers_0890.httpsvk.zapiskz.model.response

import com.google.gson.annotations.SerializedName
import comers_0890.httpsvk.zapiskz.model.Salon

data class SalonResponse (
    @SerializedName("salons")
    val salons: MutableList<Salon>
)