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
        resetData()
    }

    fun logingin() {
        _login.value = true
    }

    private val startshoeList = mutableListOf<MyShoe>(
        MyShoe("Brogue", "Vans", "41", "classic"),
        MyShoe("Clog ", "Reebok", "35", "laser"),
        MyShoe("Cowboy boots", "Nike", "44", "sport"),
        MyShoe("Blucher ", "Adidas", "43", "sport"),
    )
    private val _shoeList = MutableLiveData(startshoeList)
    val shoeList: LiveData<MutableList<MyShoe>>
        get() = _shoeList

    var shoeName = MutableLiveData<String>()

    var company = MutableLiveData<String>()
    var size = MutableLiveData<String>()
    var description = MutableLiveData<String>()


    fun addShoe() {
        val newShoe = MyShoe(shoeName.value!!, company.value!!, size.value!!, description.value!!)
        _shoeList.value!!.add(newShoe)
    }

    fun resetData() {
        shoeName.value = ""
        company.value = ""
        size.value = ""
        description.value = ""
    }

    override fun onCleared() {
        super.onCleared()
    }
}

data class MyShoe(val name: String, val company: String, val size: String, val description: String)