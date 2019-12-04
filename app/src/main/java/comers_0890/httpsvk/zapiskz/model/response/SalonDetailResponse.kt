package comers_0890.httpsvk.zapiskz.model.response

import com.google.gson.annotations.SerializedName
import comers_0890.httpsvk.zapiskz.model.*

data class SalonDetailResponse(
    @SerializedName("salon")
    val salon: Salon,
    @SerializedName("masters")
    val masters: MutableList<Master>,
    @SerializedName("services")
    val services: MutableList<Service>,
    @SerializedName("categories")
    val categories: MutableList<Category>,
    @SerializedName("location")
    val location: Location,
    @SerializedName("instagram")
    val instagram: String?
)