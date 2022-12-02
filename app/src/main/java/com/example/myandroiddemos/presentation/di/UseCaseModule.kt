package com.example.myandroiddemos.presentation.di

import com.example.myandroiddemos.domain.repository.NewsRepository
import com.example.myandroiddemos.domain.useCase.*
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
    fun provideSaveNewsUseCase(newsRepository: NewsRepository) : SaveNewsUseCase {
        return SaveNewsUseCase(newsRepository)
    }

    @Provides
    fun provideGetSavedNewsUseCase(newsRepository: NewsRepository) : GetSavedNewsCase {
        return GetSavedNewsCase(newsRepository)
    }

    @Provides
    fun provideDeleteSavedNewsUseCase(newsRepository: NewsRepository) : DeleteSavedNewsUseCase {
        return DeleteSavedNewsUseCase(newsRepository)
    }
}