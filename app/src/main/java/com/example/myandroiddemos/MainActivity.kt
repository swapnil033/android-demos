package com.example.myandroiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(IO).launch {
            Log.i("TAG", "transaction started ...")
            val stock1 = async { getStock1() }
            val stock2 = async { getStock2() }
            val total = stock1.await() + stock2.await()
            Log.i("TAG", "onCreate: $total")
        }

    }

    private suspend fun getStock1() : Int {
        delay(10000)
        Log.i("TAG", "getStock1: getStock 1")
        return 4000
    }

    private suspend fun getStock2() : Int {
        delay(8000)
        Log.i("TAG", "getStock2: getStock 2")
        return 6000
    }

}