package com.example.myandroiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.myandroiddemos.databinding.ActivityMainBinding
import com.example.myandroiddemos.model.Album
import com.example.myandroiddemos.retrofit.AlbumService
import com.example.myandroiddemos.retrofit.RetrofitInstance
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        var retInstance = RetrofitInstance.getInstance().create(AlbumService::class.java)

        //getAllAlbums(retInstance)
        getUserAlbums(retInstance, 3)
    }

    private fun getUserAlbums(retInstance: AlbumService, i: Int) {

        val albumResponse: LiveData<Response<Album>> = liveData {
            val response = retInstance.getAlbums(i)
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
            val response = retInstance.getAlbums()
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