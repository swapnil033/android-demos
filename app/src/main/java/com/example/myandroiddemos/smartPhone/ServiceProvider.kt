package com.example.myandroiddemos.smartPhone

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor() {

    fun getService(){
        Log.i("SmartPhoneTag", "getService: ")
    }

}