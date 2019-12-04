package comers_0890.httpsvk.zapiskz.common

import comers_0890.httpsvk.zapiskz.model.response.SalonDetailResponse
import comers_0890.httpsvk.zapiskz.model.response.SalonResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface Api {
    @Headers("Content-Type: application/json")
    @GET("salon/getRecommended")
    fun getRecommended(): Observable<SalonResponse>

    @Headers("Content-Type: application/json")
    @GET("salon/getPopular")
    fun getPopular(): Observable<SalonResponse>

    @Headers("Content-Type: application/json")
    @GET("salon/page")
    fun getDetails(@Query("id") id: Int): Observable<SalonDetailResponse>
}