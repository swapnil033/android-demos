package com.example.myandroiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.myandroiddemos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.button.setOnClickListener {
            setOneTimeWorkRequest()
        }
    }


    private fun setOneTimeWorkRequest(){
        val workManager = WorkManager.getInstance(applicationContext)
        val constant = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val myWorker = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setConstraints(constant)
            .build()

        workManager.enqueue(myWorker)
        workManager.getWorkInfoByIdLiveData(myWorker.id)
            .observe(this, Observer {
                binding.textView.text = it.state.name
            })
    }
}