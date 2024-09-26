package com.example.retrofitproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.retrofitproject.databinding.FragmentDetailsBinding
import com.example.retrofitproject.reposatories.EmployeeDetailsRepository
import com.example.retrofitproject.viewModel.EmployeeDetailsViewModel

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: EmployeeDetailsViewModel
    private val args: DetailsFragmentArgs by navArgs()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = args.data
        Log.d("one", "onViewCreated: $id")

        viewModel = EmployeeDetailsViewModel(EmployeeDetailsRepository())
        viewModel.getEmployeeDetails(id)
        viewModel.items.observe(viewLifecycleOwner) {
            it?.let {

            }
        }
    }

}