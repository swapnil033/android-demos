package com.example.myandroiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.myandroiddemos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.button.setOnClickListener {
            setOneTimeWorkRequest()
        }
    }


    private fun setOneTimeWorkRequest(){
        val myWorker = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(myWorker)
    }
}