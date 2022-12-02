package com.example.myandroiddemos.presentation.viewModelFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myandroiddemos.domain.useCase.*
import com.example.myandroiddemos.presentation.viewModel.NewsViewModel

class NewsViewModelFactory(
    private val app : Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchNewsUseCase: GetSearchNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsCase: GetSavedNewsCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchNewsUseCase,
            saveNewsUseCase,
            getSavedNewsCase,
            deleteSavedNewsUseCase
        ) as T
    }
}