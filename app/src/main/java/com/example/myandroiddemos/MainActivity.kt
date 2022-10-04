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
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            Log.i("TAG", "onCreate: ${this.toString()}")
        }

        CoroutineScope(Dispatchers.IO).launch {
            Log.e("TAG", "onCreate: ${this.toString()}")
        }

    }
}