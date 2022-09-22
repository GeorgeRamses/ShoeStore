package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentLoginBinding
import com.example.shoestore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : Fragment() {
    lateinit var viewModel: ShoeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        val binding =
            DataBindingUtil.inflate<FragmentWelcomeScreenBinding>(
                inflater,
                R.layout.fragment_welcome_screen,
                container,
                false
            )
        binding.btnStart.setOnClickListener { view ->
            view.findNavController().navigate(WelcomeScreenDirections.actionWelcomeScreenToInstruction())
        }

        return binding.root
    }
}