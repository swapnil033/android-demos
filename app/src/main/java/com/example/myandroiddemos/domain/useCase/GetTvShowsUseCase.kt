package com.example.myandroiddemos.domain.useCase

import com.example.myandroiddemos.data.model.tvShow.Tv
import com.example.myandroiddemos.domain.repository.TvShowsRepository

class GetTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute() : List<Tv>? = tvShowsRepository.getTvShows()

}