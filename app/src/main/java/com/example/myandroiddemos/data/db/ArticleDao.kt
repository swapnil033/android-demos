package com.example.myandroiddemos.data.db

import androidx.room.*
import com.example.myandroiddemos.data.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: Article) : Long

    @Query("SELECT * FROM articles")
    fun getAllSavedArticles() : Flow<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

}