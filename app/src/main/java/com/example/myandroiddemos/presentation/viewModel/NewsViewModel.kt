package com.example.myandroiddemos.presentation.viewModel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.example.myandroiddemos.data.model.APIResponse
import com.example.myandroiddemos.data.model.Article
import com.example.myandroiddemos.data.util.Resource
import com.example.myandroiddemos.domain.useCase.GetNewsHeadlinesUseCase
import com.example.myandroiddemos.domain.useCase.GetSearchNewsUseCase
import com.example.myandroiddemos.domain.useCase.SaveNewsUseCase
import com.example.myandroiddemos.presentation.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val app : Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchNewsUseCase: GetSearchNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
) : AndroidViewModel(app) {

    private val _message = MutableLiveData<Event<String>>()
    val message : LiveData<Event<String>>
        get() = _message

    val newsHeadLines : MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadLines(country : String, page : Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadLines.postValue(Resource.Loading())
        if (isNetworkAvailable(app)) {
            val apiResponse = getNewsHeadlinesUseCase.execute(country, page)
            newsHeadLines.postValue(apiResponse)
        }else{
            newsHeadLines.postValue(Resource.Error("No Internet"))
        }
    }

    private fun isNetworkAvailable(context: Context?) : Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }

    //search
    val searchedNews : MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun searchNews(country : String, searchQuery : String, page : Int) = viewModelScope.launch {
        searchedNews.postValue(Resource.Loading())
        if(isNetworkAvailable(app)){
            val apiResponse = getSearchNewsUseCase.execute(country, searchQuery, page)
            searchedNews.postValue(apiResponse)
        } else{
            searchedNews.postValue(Resource.Error("No Internet"))
        }
    }

    fun saveData(article: Article) = viewModelScope.launch {
        val newRowCount = saveNewsUseCase.execute(article)

        if (newRowCount > -1)
            _message.value = Event("Article Save Successfully!")
        else
            _message.value = Event("Error : Article not Saved")


    }

}