package comers_0890.httpsvk.zapiskz.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("type")
    val type: String,
    @SerializedName("markerX")
    val markerX: Float,
    @SerializedName("markerY")
    val markerY: Float,
    @SerializedName("centerX")
    val centerX: Float,
    @SerializedName("centerY")
    val centerY: Float,
    @SerializedName("zoom")
    val zoom: Int
)