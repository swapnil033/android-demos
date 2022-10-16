package com.example.myandroiddemos.smartPhone

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule(val memorySize : Int) {

    @Provides
    fun providesMemoryCard() : MemoryCard {
        Log.i("SmartPhoneTag", "providesMemoryCard: memorySize : $memorySize")
        return MemoryCard()
    }
}