package com.example.myandroiddemos.presentation.di.core

import android.content.Context
import com.example.myandroiddemos.presentation.di.artist.ArtistModule
import com.example.myandroiddemos.presentation.di.artist.ArtistSubComponent
import com.example.myandroiddemos.presentation.di.movie.MovieSubComponent
import com.example.myandroiddemos.presentation.di.tvShow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    ArtistSubComponent::class,
    MovieSubComponent::class,
    TvShowSubComponent::class
])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext() : Context {
        return context.applicationContext
    }

}