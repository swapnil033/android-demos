package com.example.myandroiddemos.smartPhone

import dagger.Binds
import dagger.Module

@Module
abstract class NCModule {

    @Binds
    abstract fun bindsNCBattery(nickelCadmiumBattery: NickelCadmiumBattery) : Battery

}