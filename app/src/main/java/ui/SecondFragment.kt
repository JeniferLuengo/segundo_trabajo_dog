package ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.segundo_trabajo_dog.R
import com.example.segundo_trabajo_dog.databinding.FragmentSecondBinding
import viewModel.DogViewModel
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private lateinit var binding : FragmentSecondBinding
    private val viewModel : DogViewModel by activityViewModels()
    private var iddog: String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            iddog = it.getString("breed", "")

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDogById(iddog).observe(viewLifecycleOwner,Observer{
            it?.let {
                Glide.with(binding.imageView2).load(it.image).into(binding.imageView2)
                binding.textRaza.text=it.breed
            })

        })

    }
}



