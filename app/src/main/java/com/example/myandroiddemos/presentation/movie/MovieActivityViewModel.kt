package com.example.myandroiddemos.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myandroiddemos.domain.useCase.GetMoviesUseCase
import com.example.myandroiddemos.domain.useCase.UpdateMoviesUseCase

class MovieActivityViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getUpdateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        emit(getMoviesUseCase.execute())
    }

    fun updateMovies() = liveData {
        emit(getUpdateMoviesUseCase.execute())
    }

}