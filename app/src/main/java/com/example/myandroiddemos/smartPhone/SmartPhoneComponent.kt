package com.example.myandroiddemos.smartPhone

import com.example.myandroiddemos.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModule::class, NCModule::class])
interface SmartPhoneComponent {

    fun inject(mainActivity: MainActivity)
}