package com.example.myandroiddemos

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class MyWorker(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {

    companion object{
        const val KEY_WORKER = "key_worker"
    }
    @SuppressLint("SimpleDateFormat")
    override fun doWork(): Result {
        return try{
            val data = inputData.getInt(MainActivity.KEY_COUNT, 0)

            for (i in 0 until data) {
                Log.i("MyWorker", "doWork: $i")
            }

            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = time.format(Date())

            val outPutData = Data.Builder()
                .putString(KEY_WORKER, "Done at $currentDate")
                .build()

            Result.success(outPutData)
        }catch (e : Exception){
            Result.failure()
        }
    }
}