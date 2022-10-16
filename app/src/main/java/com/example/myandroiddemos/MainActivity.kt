package com.example.myandroiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myandroiddemos.databinding.ActivityMainBinding
import com.example.myandroiddemos.smartPhone.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        DaggerSmartPhoneComponent.create()
            .getSmartPhone()
            .makeACall()
    }
}