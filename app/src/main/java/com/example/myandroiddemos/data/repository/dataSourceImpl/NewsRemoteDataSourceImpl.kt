package com.example.myandroiddemos.data.repository.dataSourceImpl

import com.example.myandroiddemos.data.api.NewsAPIService
import com.example.myandroiddemos.data.model.APIResponse
import com.example.myandroiddemos.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService : NewsAPIService
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country : String, page : Int): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }

    override suspend fun getSearched(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getSearchedHeadlines(country, searchQuery, page)
    }
}