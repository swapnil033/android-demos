package com.example.myandroiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.myandroiddemos.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.
        setContentView(this, R.layout.activity_main)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                //downloadUserData()
                binding.tvUserMessage.text = UserDataManager().getTotalUserCount().toString()
            }
        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}