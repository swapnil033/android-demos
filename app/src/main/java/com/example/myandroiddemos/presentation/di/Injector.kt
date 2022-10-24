package com.example.myandroiddemos.presentation.di

import com.example.myandroiddemos.presentation.di.artist.ArtistSubComponent
import com.example.myandroiddemos.presentation.di.movie.MovieSubComponent
import com.example.myandroiddemos.presentation.di.tvShow.TvShowSubComponent

interface Injector {

    fun createArtistSubComponent() : ArtistSubComponent
    fun createMovieSubComponent() : MovieSubComponent
    fun createTvShowSubComponent() : TvShowSubComponent

}