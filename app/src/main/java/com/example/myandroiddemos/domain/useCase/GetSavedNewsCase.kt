package com.example.myandroiddemos.domain.useCase

import com.example.myandroiddemos.data.model.Article
import com.example.myandroiddemos.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsCase(private val newsRepository: NewsRepository) {

    fun execute() : Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }

}