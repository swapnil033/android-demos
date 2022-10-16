package com.example.myandroiddemos.smartPhone

import android.util.Log

class SimCard(private val serviceProvider: ServiceProvider) {

    fun getConnection(){
        serviceProvider.getService()
        Log.i("SmartPhoneTag", "getConnection: ")
    }
}