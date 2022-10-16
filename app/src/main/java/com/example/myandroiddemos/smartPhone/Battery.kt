package com.example.myandroiddemos.smartPhone

import android.util.Log
import javax.inject.Inject

class Battery @Inject constructor() {

    fun getPower(){
        Log.i("SmartPhoneTag", "getPower: ")
    }

}