package com.example.myandroiddemos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal : Int) : ViewModel() {

    var addValue = MutableLiveData<String>()

    private var total = MutableLiveData<Int>()
    val totalData : LiveData<Int>
        get() = total

    init {
        addValue.value = "0"
        total.value = startingTotal
    }

    fun setTotal(){
        total.value =(total.value)?.plus(addValue.value!!.toInt())
    }

}