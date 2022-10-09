package com.example.myandroiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.myandroiddemos.databinding.ActivityMainBinding
import com.example.myandroiddemos.model.Album
import com.example.myandroiddemos.model.AlbumItem
import com.example.myandroiddemos.retrofit.AlbumService
import com.example.myandroiddemos.retrofit.RetrofitInstance
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val retInstance = RetrofitInstance.getInstance().create(AlbumService::class.java)

        //getAllAlbums(retInstance)
        //getUserAlbumsByUserId(retInstance, 3)
        getUserAlbumsByAlbumId(retInstance, 3)
    }

    private fun getUserAlbumsByAlbumId(retInstance: AlbumService, id: Int) {

        val albumResponse : LiveData<Response<AlbumItem>> = liveData {
            val response = retInstance.getAlbumsByAlbumId(id)
            emit(response)
        }


        albumResponse.observe(this) {
            val albumItem = it.body()!!

            val responseString = " Album id : ${albumItem.id} \n" +
                    " Album title : ${albumItem.title} \n" +
                    " Album user id : ${albumItem.userId} \n\n\n"

            binding.textView.append(responseString)
        }
    }

    private fun getUserAlbumsByUserId(retInstance: AlbumService, i: Int) {

        val albumResponse: LiveData<Response<Album>> = liveData {
            val response = retInstance.getAlbumsByUserId(i)
            emit(response)
        }

        albumResponse.observe(this) {
            val list = it.body()!!.listIterator()

            if (list != null) {
                while (list.hasNext()) {
                    val album = list.next()
                    val responseString = " Album id : ${album.id} \n" +
                            " Album title : ${album.title} \n" +
                            " Album user id : ${album.userId} \n\n\n"

                    binding.textView.append(responseString)
                }
            }
        }
    }

    private fun getAllAlbums(retInstance: AlbumService) {
        val albumResponse: LiveData<Response<Album>> = liveData {
            val response = retInstance.getAlbumsByUserId()
            emit(response)
        }

        albumResponse.observe(this) {
            val list = it.body()!!.listIterator()

            if (list != null) {
                while (list.hasNext()) {
                    val album = list.next()
                    val responseString = " Album id : ${album.id} \n" +
                            " Album title : ${album.title} \n" +
                            " Album user id : ${album.userId} \n\n\n"

                    binding.textView.append(responseString)
                }
            }
        }
    }
}