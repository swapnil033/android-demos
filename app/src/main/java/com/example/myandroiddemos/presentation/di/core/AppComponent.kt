package com.example.myandroiddemos.presentation.di.core

import com.example.myandroiddemos.presentation.di.artist.ArtistSubComponent
import com.example.myandroiddemos.presentation.di.movie.MovieSubComponent
import com.example.myandroiddemos.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DataBaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {

    fun artistSubComponent() : ArtistSubComponent.Factory
    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory

}