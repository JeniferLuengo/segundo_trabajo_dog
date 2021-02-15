package viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.segundo_trabajo_dog.databinding.DogItemListBinding
import remoto.DogEntity


class DogAdapter: RecyclerView.Adapter<DogAdapter.DogViewHolder>(){
    private var DogList= emptyList<DogEntity>()
    private val selectedDogEntity = MutableLiveData<DogEntity>()
    fun selectedItem(): LiveData<DogEntity> = selectedDogEntity

    fun update(list: List<DogEntity>) {
        DogList = list
        notifyDataSetChanged()
    }
    inner class DogViewHolder( private val binding: DogItemListBinding): RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        override fun onClick(v: View?) {
            selectedDogEntity.value= DogList[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(DogItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int =DogList.size

    override fun onBindViewHolder(holder: DogAdapter.DogViewHolder, position: Int) {
        val dog= DogList[position]

    }
}



