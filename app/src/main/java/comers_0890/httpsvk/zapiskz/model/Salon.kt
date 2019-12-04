package comers_0890.httpsvk.zapiskz.model

import com.google.gson.annotations.SerializedName

data class Salon(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("checkRating")
    val checkRating: Float,
    @SerializedName("pictureUrl")
    val pictureUrl: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("workStartTime")
    val workStartTime: String,
    @SerializedName("workEndTime")
    val workEndTime: String,
    @SerializedName("instagramProfile")
    val instagramProfile: String,
    @SerializedName("isMastersHidden")
    val isMastersHidden: Boolean,
    @SerializedName("avatarUrl")
    val avatarUrl: String,
    @SerializedName("reviewCount")
    val reviewCount: Int,
    @SerializedName("averageRating")
    val averageRating: Float,
    @SerializedName("phoneNumbers")
    val phoneNumbers: MutableList<String>,
    @SerializedName("todayReservationsCount")
    val todayReservationsCount: String?,
    @SerializedName("pictures")
    val pictures: MutableList<String>
)