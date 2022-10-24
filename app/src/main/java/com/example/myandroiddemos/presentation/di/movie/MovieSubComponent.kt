package com.example.myandroiddemos.presentation.di.movie

import com.example.myandroiddemos.presentation.artist.ArtistActivity
import com.example.myandroiddemos.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{

        fun create() : MovieSubComponent

    }

}