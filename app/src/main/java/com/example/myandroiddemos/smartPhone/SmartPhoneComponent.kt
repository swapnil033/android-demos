package com.example.myandroiddemos.smartPhone

import dagger.Component

@Component
interface SmartPhoneComponent {
    fun getSmartPhone() : SmartPhone
}