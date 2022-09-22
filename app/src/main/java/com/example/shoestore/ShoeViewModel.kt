package com.example.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    init {

    }

    private val shoeList = mutableListOf<MyShoe>(
        MyShoe("Brogue", "Vans", "41", "classic"),
        MyShoe("Clog ", "Reebok", "35", "laser"),
        MyShoe("Cowboy boots", "Nike", "44", "sport"),
        MyShoe("Blucher ", "Adidas", "43", "sport"),
    )
    private val _shoe = MutableLiveData<MutableList<MyShoe>>(shoeList)
    val shoe: LiveData<MutableList<MyShoe>>
        get() = _shoe

    fun addShoe(newShoe: MutableList<MyShoe>) {

        _shoe.value= newShoe
    }

    override fun onCleared() {
        super.onCleared()
    }
}

data class MyShoe(val name: String, val company: String, val size: String, val description: String)