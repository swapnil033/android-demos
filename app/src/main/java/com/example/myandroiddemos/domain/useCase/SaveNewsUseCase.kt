package com.example.myandroiddemos.domain.useCase

import com.example.myandroiddemos.data.model.Article
import com.example.myandroiddemos.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article)  : Long{
        return newsRepository.saveNews(article)
    }

}