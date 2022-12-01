package com.example.myandroiddemos.presentation.di

import com.example.myandroiddemos.domain.repository.NewsRepository
import com.example.myandroiddemos.domain.useCase.GetNewsHeadlinesUseCase
import com.example.myandroiddemos.domain.useCase.GetSavedNewsCase
import com.example.myandroiddemos.domain.useCase.GetSearchNewsUseCase
import com.example.myandroiddemos.domain.useCase.SaveNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetNewsHeadlinesUseCase(newsRepository: NewsRepository) : GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Provides
    fun provideGetSearchNewsUseCase(newsRepository: NewsRepository) : GetSearchNewsUseCase {
        return GetSearchNewsUseCase(newsRepository)
    }

    @Provides
    fun provideGetSavedNewsUseCase(newsRepository: NewsRepository) : SaveNewsUseCase {
        return SaveNewsUseCase(newsRepository)
    }
}