package com.example.myandroiddemos.presentation.di

import com.example.myandroiddemos.BuildConfig
import com.example.myandroiddemos.data.api.NewsAPIService
import com.example.myandroiddemos.presentation.viewModel.NewsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesNewsAPIService(retrofit: Retrofit) : NewsAPIService {
        return retrofit.create(NewsAPIService::class.java)
    }
}