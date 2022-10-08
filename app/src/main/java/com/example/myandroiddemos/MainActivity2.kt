package com.example.myandroiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.myandroiddemos.databinding.ActivityMain2Binding
import com.example.myandroiddemos.ui.main.MainFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding
    private val TAG = "progressBar"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        lifecycleScope.launch{
            delay(3000)
            binding.progressBar.visibility = View.VISIBLE
            Log.d(TAG, "progressBar is VISIBLE")
            delay(10000)
            binding.progressBar.visibility = View.GONE
            Log.d(TAG, "progressBar is GONE")
        }

    }
}