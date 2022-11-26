package com.example.myandroiddemos.di

import com.example.myandroiddemos.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    fun providesDataSource() : DataSource {
        return DataSource()
    }

}