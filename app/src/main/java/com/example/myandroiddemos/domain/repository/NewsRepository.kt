package com.example.myandroiddemos.domain.repository

import com.example.myandroiddemos.data.model.APIResponse
import com.example.myandroiddemos.data.model.Article
import com.example.myandroiddemos.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadLines(country : String, page : Int) : Resource<APIResponse>
    suspend fun getSearchedNews(country : String, searchQuery : String, page : Int) : Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews() : Flow<List<Article>>
}