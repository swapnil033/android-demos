package com.example.myandroiddemos.data.repository.dataSource

import com.example.myandroiddemos.data.model.Article

interface NewsLocalDataSource {

    suspend fun saveArticle(article: Article) : Long

}