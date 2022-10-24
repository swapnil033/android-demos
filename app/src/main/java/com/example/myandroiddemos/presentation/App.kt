package com.example.myandroiddemos.presentation

import android.app.Application
import com.example.myandroiddemos.BuildConfig
import com.example.myandroiddemos.presentation.di.Injector
import com.example.myandroiddemos.presentation.di.artist.ArtistSubComponent
import com.example.myandroiddemos.presentation.di.core.*
import com.example.myandroiddemos.presentation.di.movie.MovieSubComponent
import com.example.myandroiddemos.presentation.di.tvShow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }


    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}