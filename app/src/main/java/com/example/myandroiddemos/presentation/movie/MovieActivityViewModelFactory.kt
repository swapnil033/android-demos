package com.example.myandroiddemos.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myandroiddemos.domain.useCase.GetMoviesUseCase
import com.example.myandroiddemos.domain.useCase.UpdateMoviesUseCase

class MovieActivityViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getUpdateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieActivityViewModel(getMoviesUseCase, getUpdateMoviesUseCase) as T
    }
}