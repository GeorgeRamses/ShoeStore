package com.example.shoestore

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.forEach
import androidx.core.view.marginStart
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.databinding.FragmentShoelistBinding
import java.awt.font.TextAttribute
import kotlin.reflect.KProperty


class shoelist : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()
    lateinit var binding: FragmentShoelistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("FragmentLiveDataObserve", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate<FragmentShoelistBinding>(inflater, R.layout.fragment_shoelist, container, false)
//        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.viewModel = ShoeViewModel()
        binding.lifecycleOwner = this

        viewModel.shoeList.observe(this, Observer { newShoe ->
            loadShoeList(newShoe)
        })

        binding.floatingActionButtonAdd.setOnClickListener { view ->
            view.findNavController().navigate(shoelistDirections.actionShoelistToShoeDetail())
        }

        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.btn_logout) {
            requireView().findNavController().navigate(shoelistDirections.actionShoelistToLogin())
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("SetTextI18n")
    fun loadShoeList(myShoeList: MutableList<MyShoe>) {
        myShoeList.forEach { myshoe ->
            val textView = TextView(context)
            textView.text =
                "shoe Name: ${myshoe.name}| company: ${myshoe.company}| " +
                        "size: ${myshoe.size}| Desc: ${myshoe.description}"
            binding.shoelistLayout.addView(textView)
        }
    }

}