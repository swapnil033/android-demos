package com.example.myandroiddemos.data.repository.dataSourceImpl

import com.example.myandroiddemos.data.db.ArticleDao
import com.example.myandroiddemos.data.model.Article
import com.example.myandroiddemos.data.repository.dataSource.NewsLocalDataSource

class NewsLocalDataSourceImpl(
    private val articleDao: ArticleDao
) : NewsLocalDataSource {
    override suspend fun saveArticle(article: Article) : Long {
        return articleDao.insertArticle(article)
    }
}