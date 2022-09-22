package com.example.shoestore

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentShoeDetailBinding

class shoe_detail : Fragment() {
    lateinit var binding: FragmentShoeDetailBinding
    lateinit var viewModel: ShoeViewModel
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

        binding.btnSave.setOnClickListener { view ->
            name = binding.txtShoeName.text.toString()
            company = binding.txtCompany.text.toString()
            size = binding.txtSize.text.toString()
            desc = binding.txtDesc.text.toString()

            view.findNavController()
                .navigate(shoe_detailDirections.actionShoeDetailToShoelist(name, company, size, desc,true))
        }

        binding.btnCancel.setOnClickListener { view ->
            view.findNavController().navigate(shoe_detailDirections.actionShoeDetailToShoelist("","","","",false))
        }


        // Inflate the layout for this fragment
        return binding.root
    }


}