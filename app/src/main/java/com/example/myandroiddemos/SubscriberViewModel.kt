package com.example.myandroiddemos

import androidx.lifecycle.LiveData
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

    private var _statusMessage = MutableLiveData<Event<String>>()

    val statusMessage : LiveData<Event<String>>
    get() = _statusMessage

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

    private fun insert(subscriber: Subscriber) = viewModelScope.launch {
        val newRowId = repository.insert(subscriber)
        withContext(Dispatchers.Main){
            newRowId.let {
                if(it > -1) _statusMessage.value = Event("new subscriber added! $it")
                else _statusMessage.value = Event("error occurred!")
            }
        }
    }

    private fun update(subscriber: Subscriber) = viewModelScope.launch {
        val updatedRowCount = repository.update(subscriber)
        withContext(Dispatchers.Main){
            updatedRowCount.let {
                if (it > 0) {
                    inputName.value = ""
                    inputEmail.value = ""

                    isUpdateOrDelete = false

                    saveOrUpdateButtonText.value = "save"
                    clearAllOrDeleteButtonText.value = "clear all"
                    _statusMessage.value = Event(" $it rows updated!")
                }
                else _statusMessage.value = Event("error occurred!")
            }
        }
    }

    private fun delete(subscriber: Subscriber) = viewModelScope.launch {
        val rowCount = repository.delete(subscriber)
        withContext(Dispatchers.Main){
            rowCount.let {
                if (it > 0) {
                    inputName.value = ""
                    inputEmail.value = ""

                    isUpdateOrDelete = false

                    saveOrUpdateButtonText.value = "save"
                    clearAllOrDeleteButtonText.value = "clear all"
                    _statusMessage.value = Event("subscriber deleted!")
                }
                else _statusMessage.value = Event("error occurred!")
            }


        }
    }

    private fun clearAll() = viewModelScope.launch {
        val rowCount = repository.deleteAll()
        withContext(Dispatchers.Main){
            rowCount.let {
                if (it > 0) _statusMessage.value = Event("all subscribers are deleted!")
                else _statusMessage.value = Event("error occurred!")
            }

        }
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