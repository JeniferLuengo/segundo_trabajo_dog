package remoto

import android.util.Log
import androidx.lifecycle.LiveData
import viewModel.DogDao

class DogsRepository (private val dogDao: DogDao) {
    val dogInternet = dogDao.getAllDogs()
    val imageDogInternet = dogDao.getAllImages()

        private val retrofitClient = RetroFitClient.getRetrofit()


        // Obtener datos con corutinas

        suspend fun fetchDataFromInternetCoroutines()  {
            try {
                val response = retrofitClient.fetchDogDataCoroutine()
                when(response.code()) {
                    in 200..299 -> response.body()?.let { dogDao.insertAllDog(it)}
                    in 300..399 -> Log.d("REPO","${response.code()} --- ${response.errorBody()}")
                    else -> Log.d("REPO","${response.code()} --- ${response.errorBody().toString()}")
                }
            } catch (t: Throwable) {
                Log.e("REPO", "${t.message}")
            }
        }
        fun getDogById(id:String): LiveData<DogEntity> {
            return dogDao.getDogById(id)
        }

        suspend fun buscadorImagenes()  {
            try {
                val response = retrofitClient.buscadorImagenes("id")
                when(response.code()) {
                    in 200..299 -> response.body()?.let { dogDao.getAllImages()}
                    in 300..399 -> Log.d("REPO","${response.code()} --- ${response.errorBody()}")
                    else -> Log.d("REPO","${response.code()} --- ${response.errorBody().toString()}")
                }
            } catch (t: Throwable) {
                Log.e("REPO", "${t.message}")
            }
        }
        fun getImageById(id:String): LiveData<ImageDogEntity> {
            return dogDao.getImageById(id)
        }

    }
