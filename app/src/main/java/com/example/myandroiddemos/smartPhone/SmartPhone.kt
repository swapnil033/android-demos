package com.example.myandroiddemos.smartPhone

import android.util.Log

class SmartPhone(battery: Battery, memoryCard: MemoryCard, simCard: SimCard) {

    init {
        battery.getPower()
        memoryCard.getMemory()
        simCard.getConnection()
        Log.i("SmartPhoneTag", "Smart Phone Constructor: ")
    }

    fun makeACall(){
        Log.i("SmartPhoneTag", "makeACall: ")
    }

}