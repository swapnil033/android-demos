package com.example.myandroiddemos.data.repository.dataSource

import com.example.myandroiddemos.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getTopHeadlines(country : String, page : Int) : Response<APIResponse>

}