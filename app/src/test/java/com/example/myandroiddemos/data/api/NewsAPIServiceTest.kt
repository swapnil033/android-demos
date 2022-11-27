package com.example.myandroiddemos.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {

    private lateinit var service : NewsAPIService
    private lateinit var server : MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(fileName : String){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("newsApi.json")
            val responseBody = service.getTopHeadlines("us",1).body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=72feb5f2d63b4ed19bd15b1de6da122a")
        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctPageSize(){
        runBlocking {
            enqueueMockResponse("newsApi.json")
            val responseBody = service.getTopHeadlines("us",1).body()
            val artistList = responseBody?.articles
            assertThat(artistList?.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("newsApi.json")
            val responseBody = service.getTopHeadlines("us",1).body()
            val artistList = responseBody?.articles
            val artist = artistList?.get(0)
            assertThat(artist?.author).isEqualTo("IANS")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}