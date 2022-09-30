package com.example.myandroiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.myandroiddemos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.controlButton.setOnClickListener {
            binding.progressBar.visibility = if (binding.progressBar.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            binding.controlButton.text = if (binding.progressBar.visibility == View.VISIBLE) "Stop" else "Start"
        }

    }
}