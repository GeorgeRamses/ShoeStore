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


class Login : Fragment() {

    lateinit var viewModel: ShoeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
        viewModel=ViewModelProvider(this).get(ShoeViewModel::class.java)
        viewModel.logingin()
        binding.btnLogin.setOnClickListener { view ->
            val user = binding.txtEmail.text.toString()
            val password = binding.txtPassword.text.toString()

            view.findNavController().navigate(LoginDirections.actionLoginToWelcomeScreen(user, password))
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}