package com.example.myandroiddemos.presentation.di

import com.example.myandroiddemos.domain.repository.NewsRepository
import com.example.myandroiddemos.domain.useCase.GetNewsHeadlinesUseCase
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
}