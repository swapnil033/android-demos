package com.example.myandroiddemos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private var _total = MutableLiveData<Int>()
    val total : LiveData<Int>
    get() = _total

    private var _addValue = MutableLiveData<Int>()
    val addValue : LiveData<Int>
    get() = _addValue

    init {
        _total.value = 0
        _addValue.value = 0
    }

    fun addInTotal() {
        //_total.value = _total.value!!.plus(_addValue.value!!)
    }

}