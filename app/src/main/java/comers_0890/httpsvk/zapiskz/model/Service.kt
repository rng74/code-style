package comers_0890.httpsvk.zapiskz.model

import com.google.gson.annotations.SerializedName

data class Service (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("priceMax")
    val priceMax: Int,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("express")
    val express: String?,
    @SerializedName("prepaymentAmount")
    val prepaymentAmount: String?,
    @SerializedName("priceStr")
    val priceStr: String,
    @SerializedName("categoryId")
    val categoryId: Int
)