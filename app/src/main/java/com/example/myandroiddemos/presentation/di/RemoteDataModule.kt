package com.example.myandroiddemos.presentation.di

import com.example.myandroiddemos.data.api.NewsAPIService
import com.example.myandroiddemos.data.repository.dataSource.NewsRemoteDataSource
import com.example.myandroiddemos.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun providesNewsRemoteDataSource(newsAPIService : NewsAPIService) : NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}