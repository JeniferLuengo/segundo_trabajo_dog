package remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitClient {

    companion object {
        private const val BASE_URL = "https://dog.ceo/api/"

        fun getRetrofit(): DogApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(DogApi::class.java)
        }
    }
}