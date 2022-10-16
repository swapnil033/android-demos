package com.example.myandroiddemos

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class CompressingWorker(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {

    @SuppressLint("SimpleDateFormat")
    override fun doWork(): Result {
        return try{

            for (i in 0 .. 300) {
                Log.i("MyWorker", "CompressingWorker: $i")
            }
            Result.success()
        }catch (e : Exception){
            Result.failure()
        }
    }
}