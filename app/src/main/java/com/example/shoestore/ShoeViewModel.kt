package com.example.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private val _login = MutableLiveData<Boolean>()
    val login: LiveData<Boolean>
        get() = _login

    init {
        _login.value = false
    }

    fun logingin() {
        _login.value = true
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

    fun addShoe(newShoe: MyShoe) {
        _shoe.value!!.add(newShoe)
    }

    override fun onCleared() {
        super.onCleared()
    }
}

data class MyShoe(val name: String, val company: String, val size: String, val description: String)