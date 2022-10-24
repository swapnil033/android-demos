package com.example.myandroiddemos.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myandroiddemos.domain.useCase.GetTvShowsUseCase
import com.example.myandroiddemos.domain.useCase.UpdateTvShowsUseCase

class TvShowActivityViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val getUpdateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowActivityViewModel(getTvShowsUseCase, getUpdateTvShowsUseCase) as T
    }

}