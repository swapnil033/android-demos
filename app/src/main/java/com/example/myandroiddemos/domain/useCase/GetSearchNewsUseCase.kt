package com.example.myandroiddemos.domain.useCase

import com.example.myandroiddemos.data.model.APIResponse
import com.example.myandroiddemos.data.util.Resource
import com.example.myandroiddemos.domain.repository.NewsRepository

class GetSearchNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery : String) : Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }

}