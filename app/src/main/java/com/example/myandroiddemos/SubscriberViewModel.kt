package com.example.myandroiddemos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myandroiddemos.db.Subscriber
import com.example.myandroiddemos.db.SubscriberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    private var isUpdateOrDelete = false
    lateinit var selectedSubscriber: Subscriber

    var subscribers = repository.subscibers

    var inputName = MutableLiveData<String>()
    var inputEmail = MutableLiveData<String>()

    var saveOrUpdateButtonText = MutableLiveData<String>()
    var clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "save"
        clearAllOrDeleteButtonText.value = "clear all"
    }

    fun saveOrUpdate(){
        if (isUpdateOrDelete) {
            selectedSubscriber.name = inputName.value!!
            selectedSubscriber.email = inputEmail.value!!
            update(selectedSubscriber)
        }
        else {
            insert(Subscriber(0, inputName.value!!, inputEmail.value!!))
            inputName.value = ""
            inputEmail.value = ""
        }
    }

    fun clearAllOrDelete(){
        if (isUpdateOrDelete)
            delete(selectedSubscriber)
        else
            clearAll()
    }

    fun insert(subscriber: Subscriber) = viewModelScope.launch {
        repository.insert(subscriber)
    }

    fun update(subscriber: Subscriber) = viewModelScope.launch {
        repository.update(subscriber)
        withContext(Dispatchers.Main){
            inputName.value = ""
            inputEmail.value = ""

            isUpdateOrDelete = false

            saveOrUpdateButtonText.value = "save"
            clearAllOrDeleteButtonText.value = "clear all"
        }
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        repository.delete(subscriber)
        withContext(Dispatchers.Main){
            inputName.value = ""
            inputEmail.value = ""

            isUpdateOrDelete = false

            saveOrUpdateButtonText.value = "save"
            clearAllOrDeleteButtonText.value = "clear all"
        }
    }

    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun initUpdateAndDelete(subscriber: Subscriber){
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email

        isUpdateOrDelete = true
        selectedSubscriber = subscriber

        saveOrUpdateButtonText.value = "update"
        clearAllOrDeleteButtonText.value = "delete"
    }

}