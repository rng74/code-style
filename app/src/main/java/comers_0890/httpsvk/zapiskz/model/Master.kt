package comers_0890.httpsvk.zapiskz.model

import com.google.gson.annotations.SerializedName

data class Master(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("experience")
    val experience: String,
    @SerializedName("capacity")
    val capacity: String?,
    @SerializedName("profession")
    val profession: String,
    @SerializedName("serviceIds")
    val serviceIds: MutableList<Int>,
    @SerializedName("avatarUrl")
    val avatarUrl: String,
    @SerializedName("workingDays")
    val workingDays: MutableList<String>,
    @SerializedName("isRoom")
    val isRoom: Boolean
)