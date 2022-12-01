package com.example.myandroiddemos.domain.useCase

import com.example.myandroiddemos.data.model.APIResponse
import com.example.myandroiddemos.data.util.Resource
import com.example.myandroiddemos.domain.repository.NewsRepository

class GetSearchNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country : String, searchQuery : String, page : Int) : Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }

}