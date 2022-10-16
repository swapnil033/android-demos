package com.example.myandroiddemos.smartPhone

import android.util.Log
import dagger.Module
import javax.inject.Inject

class NickelCadmiumBattery @Inject constructor() : Battery{
    override fun getPower() {
        Log.i("SmartPhoneTag", "getPower: from NickelCadmiumBattery")
    }
}