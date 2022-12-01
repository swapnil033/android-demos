package com.example.myandroiddemos.presentation.di

import com.example.myandroiddemos.data.db.ArticleDao
import com.example.myandroiddemos.data.repository.dataSource.NewsLocalDataSource
import com.example.myandroiddemos.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideArticleLocalDataSource(articleDao: ArticleDao) : NewsLocalDataSource{
        return NewsLocalDataSourceImpl(
            articleDao
        )
    }

}