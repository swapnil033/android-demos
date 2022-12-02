package com.example.myandroiddemos.presentation.viewModelFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myandroiddemos.domain.useCase.GetNewsHeadlinesUseCase
import com.example.myandroiddemos.domain.useCase.GetSavedNewsCase
import com.example.myandroiddemos.domain.useCase.GetSearchNewsUseCase
import com.example.myandroiddemos.domain.useCase.SaveNewsUseCase
import com.example.myandroiddemos.presentation.viewModel.NewsViewModel

class NewsViewModelFactory(
    private val app : Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchNewsUseCase: GetSearchNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsCase: GetSavedNewsCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchNewsUseCase,
            saveNewsUseCase,
            getSavedNewsCase
        ) as T
    }
}