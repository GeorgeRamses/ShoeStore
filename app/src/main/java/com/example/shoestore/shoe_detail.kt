package com.example.shoestore

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentShoeDetailBinding

class shoe_detail : Fragment() {
    lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeViewModel by activityViewModels()
    var name = ""
    var company = ""
    var size = ""
    var desc = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
//        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.btnSave.setOnClickListener { view ->
            viewModel.addShoe()
            view.findNavController()
                .navigate(shoe_detailDirections.actionShoeDetailToShoelist())
        }
        binding.btnCancel.setOnClickListener { view ->
            view.findNavController()
                .navigate(shoe_detailDirections.actionShoeDetailToShoelist())
        }


        // Inflate the layout for this fragment
        return binding.root
    }


}