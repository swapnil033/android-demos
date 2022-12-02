package com.example.myandroiddemos.presentation.di

import android.app.Application
import com.example.myandroiddemos.domain.useCase.GetNewsHeadlinesUseCase
import com.example.myandroiddemos.domain.useCase.GetSavedNewsCase
import com.example.myandroiddemos.domain.useCase.GetSearchNewsUseCase
import com.example.myandroiddemos.domain.useCase.SaveNewsUseCase
import com.example.myandroiddemos.presentation.viewModelFactory.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        app : Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchNewsUseCase: GetSearchNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSavedNewsCase: GetSavedNewsCase,
    ) : NewsViewModelFactory {
        return NewsViewModelFactory(
            app,
            getNewsHeadlinesUseCase,
            getSearchNewsUseCase,
            saveNewsUseCase,
            getSavedNewsCase
        )
    }
}