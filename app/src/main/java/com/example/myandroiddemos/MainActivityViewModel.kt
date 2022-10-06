package com.example.myandroiddemos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myandroiddemos.model.User
import com.example.myandroiddemos.model.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    var userRepository = UserRepository()
    var users : MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData() {

        viewModelScope.launch {
            var list : List<User>? = null
            withContext(Dispatchers.IO){
                list = userRepository.getUsers()
            }
            users.value = list

        }

    }
}