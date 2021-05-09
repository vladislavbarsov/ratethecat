package android.example.ratethecat.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.thecatapi.com/v1/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CatApiService {
    @GET("images/search?limit=40&page=1&sub_id=User-287")
    suspend fun getProperties(): List<CatProperty>
}

object CatApi {
    val retrofitService : CatApiService by lazy {
        retrofit.create(CatApiService::class.java)
    }
}
