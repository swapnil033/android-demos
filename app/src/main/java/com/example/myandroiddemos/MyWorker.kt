package com.example.myandroiddemos

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class MyWorker(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {
    override fun doWork(): Result {
        return try{
            for (i in 0..60000) {
                Log.i("MyWorker", "doWork: $i")
            }
            Result.success()
        }catch (e : Exception){
            Result.failure()
        }
    }
}