package com.example.myandroiddemos.domain.useCase

import com.example.myandroiddemos.data.model.APIResponse
import com.example.myandroiddemos.data.model.Article
import com.example.myandroiddemos.data.util.Resource
import com.example.myandroiddemos.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) {
        return newsRepository.deleteNews(article)
    }

}