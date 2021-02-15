package viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.segundo_trabajo_dog.databinding.DogItemListBinding
import remoto.ImageDogEntity

class ImageAdapter: RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){
        private var imageList= emptyList<ImageDogEntity>()
        private val selectedImageData = MutableLiveData<ImageDogEntity>()

        fun selectedItem(): LiveData<ImageDogEntity> = selectedImageData

        fun update(list: List<ImageDogEntity>) {
            imageList = list
            notifyDataSetChanged()
        }
        inner class ImageViewHolder( private val binding: DogItemListBinding): RecyclerView.ViewHolder(binding.root),
            View.OnClickListener {
            fun bind(image: ImageDogEntity) {
                Glide.with(binding.imageView).load(image.image).into(binding.imageView)
                itemView.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                selectedImageData.value= imageList[adapterPosition]
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            return ImageViewHolder(DogItemListBinding.inflate(LayoutInflater.from(parent.context)))
        }

        override fun getItemCount(): Int =imageList.size


        override fun onBindViewHolder(holder:ImageAdapter.ImageViewHolder, position: Int) {
            val dogs= imageList[position]
            holder.bind(dogs)
        }
    }









}