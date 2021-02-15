package remoto

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {

    @GET("list")
    suspend fun fetchDogDataCoroutine() : Response<List<DogEntity>> // nueva forma

    @GET ("breed/{breed}/images")
    suspend fun buscadorImagenes(@Path("breed")breed:String) : Response<List<ImageDogEntity.ImageDogEntity>>
}


