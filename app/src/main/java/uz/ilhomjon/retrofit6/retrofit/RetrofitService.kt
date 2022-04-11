package uz.ilhomjon.retrofit6.retrofit

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import uz.ilhomjon.retrofit6.models.Movie

interface RetrofitService {

    @GET("marvel")
    fun getMarvel():Single<List<Movie>>
}