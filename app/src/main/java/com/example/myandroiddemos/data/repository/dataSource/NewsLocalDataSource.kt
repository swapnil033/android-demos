package com.example.myandroiddemos.data.repository.dataSource

import com.example.myandroiddemos.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {

    suspend fun saveArticle(article: Article) : Long

    fun getAllSavedArticles() : Flow<List<Article>>

    suspend fun deleteArticle(article: Article)
}