package com.example.myandroiddemos.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.myandroiddemos.data.db.ArticleDao
import com.example.myandroiddemos.data.db.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) : ArticleDatabase {
        return Room.databaseBuilder(application, ArticleDatabase::class.java, "newsDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideArticleDao(database: ArticleDatabase) : ArticleDao {
        return database.getArticleDao()
    }

}