package viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import remoto.DogEntity
import remoto.DogsRepository
import remoto.ImageDogEntity
import viewModel.DogDataBase

class DogViewModel  (application: Application) :
    AndroidViewModel(application){

        private val repository: DogsRepository
        val allDog: LiveData<List<DogEntity>>
        val allDogImage: LiveData<List<ImageDogEntity>>

        init {
            val DogDao = DogDataBase.getDataBase(application).getDogDao()
            repository = DogsRepository(DogDao)
            allDog = repository.dogInternet
             viewModelScope.launch {
                repository.fetchDataFromInternetCoroutines()
            }
            allDogImage= repository.imageDogInternet
            viewModelScope.launch {
                repository.buscadorImagenes()
            }

        }
        // activar en Dao -Repositorio-viewModel
        fun getDogById(id: String): LiveData<DogEntity> {
            return repository.getDogById(id)
        }
    // activar en Dao -Repositorio-viewModel
    fun getImageById(id: String): LiveData<ImageDogEntity> {
        return repository.getImageById(id)

    }

    }


