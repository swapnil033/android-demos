package com.example.myandroiddemos.presentation.di.tvShow

import com.example.myandroiddemos.presentation.artist.ArtistActivity
import com.example.myandroiddemos.presentation.movie.MovieActivity
import com.example.myandroiddemos.presentation.tvShow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{

        fun create() : TvShowSubComponent

    }

}