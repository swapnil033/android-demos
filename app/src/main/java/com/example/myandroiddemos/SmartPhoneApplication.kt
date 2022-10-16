package com.example.myandroiddemos

import android.app.Application
import com.example.myandroiddemos.smartPhone.DaggerSmartPhoneComponent
import com.example.myandroiddemos.smartPhone.MemoryCardModule
import com.example.myandroiddemos.smartPhone.SmartPhoneComponent

class SmartPhoneApplication : Application() {

    lateinit var smartPhoneComponent: SmartPhoneComponent

    override fun onCreate() {
        super.onCreate()

        smartPhoneComponent = initSmartPhone()
    }

    fun initSmartPhone() : SmartPhoneComponent{
        return DaggerSmartPhoneComponent.builder()
            .memoryCardModule(MemoryCardModule(4000))
            .build()
    }
}