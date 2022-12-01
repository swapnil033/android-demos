package com.example.myandroiddemos.data.repository

import com.example.myandroiddemos.data.api.NewsAPIService
import com.example.myandroiddemos.data.model.APIResponse
import com.example.myandroiddemos.data.model.Article
import com.example.myandroiddemos.data.repository.dataSource.NewsRemoteDataSource
import com.example.myandroiddemos.data.util.Resource
import com.example.myandroiddemos.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource : NewsRemoteDataSource
) : NewsRepository {
    override suspend fun getNewsHeadLines(country : String, page : Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country, page))
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getSearched(country, searchQuery, page))
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    fun <T> responseToResource(response: Response<T>) : Resource<T> {
        if(response.isSuccessful)
            return Resource.Success(response.body())
        else if(!response.isSuccessful)
            return Resource.Error(response.message())
        return Resource.Loading()
    }

}