package com.example.myandroiddemos

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class DownloadingWorker(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {

    @SuppressLint("SimpleDateFormat")
    override fun doWork(): Result {
        return try{

            for (i in 0 .. 3000) {
                Log.i("MyWorker", "DownloadingWorker: $i")
            }
            Result.success()
        }catch (e : Exception){
            Result.failure()
        }
    }
}