package com.example.myandroiddemos.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myandroiddemos.domain.useCase.GetTvShowsUseCase
import com.example.myandroiddemos.domain.useCase.UpdateTvShowsUseCase

class TvShowActivityViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val getUpdateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        emit(getTvShowsUseCase.execute())
    }

    fun updateTvShows() = liveData {
        emit(getUpdateTvShowsUseCase.execute())
    }

}