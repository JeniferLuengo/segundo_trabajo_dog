package ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.segundo_trabajo_dog.R
import com.example.segundo_trabajo_dog.databinding.FragmentFirstBinding
import viewModel.DogAdapter
import viewModel.DogViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {



    private lateinit var binding : FragmentFirstBinding
    private val viewModel : DogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DogAdapter()
        binding.rvDog.adapter = adapter
        binding.rvDog.layoutManager = LinearLayoutManager(context)
        binding.rvDog.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.HORIZONTAL
            )
        )


        viewModel.allDog.observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("base", "$it")
                adapter.update(it)
            }
        })
        adapter.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                val bundle = Bundle()
                bundle.putString("breed", id.toString())
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
            }
        })

    }
    }



