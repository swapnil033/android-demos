package com.example.myandroiddemos.smartPhone

import android.util.Log
import javax.inject.Inject

class SimCard @Inject constructor(private val serviceProvider: ServiceProvider) {

    fun getConnection(){
        serviceProvider.getService()
        Log.i("SmartPhoneTag", "getConnection: ")
    }
}