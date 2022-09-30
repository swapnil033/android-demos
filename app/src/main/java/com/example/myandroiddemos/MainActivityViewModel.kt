package com.example.myandroiddemos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private var _total = MutableLiveData<String>()
    val total : LiveData<String>
    get() = _total

    var _addValue = MutableLiveData<String>()
    val addValue : LiveData<String>
    get() = _addValue

    init {
        _total.value = "0"
        _addValue.value = "0"
    }

    fun addInTotal() {
        val one = _addValue.value!!.toInt()
        val two = _total.value!!.toInt()
        val total = two + one

        _total.value = total.toString()
    }

}