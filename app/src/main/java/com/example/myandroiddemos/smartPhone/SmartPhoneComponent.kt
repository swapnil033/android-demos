package com.example.myandroiddemos.smartPhone

import dagger.Component

@Component(modules = [MemoryCardModule::class])
interface SmartPhoneComponent {
    fun getSmartPhone() : SmartPhone
}