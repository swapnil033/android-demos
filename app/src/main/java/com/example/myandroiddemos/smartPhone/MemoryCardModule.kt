package com.example.myandroiddemos.smartPhone

import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule {

    @Provides
    fun providesMemoryCard() : MemoryCard {
        return MemoryCard()
    }
}