package com.example.myandroiddemos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.work.*
import com.example.myandroiddemos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        const val KEY_COUNT = "key_count"
    }

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

        val data = Data.Builder()
            .putInt(KEY_COUNT, 123)
            .build()

        val myWorker = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setConstraints(constant)
            .setInputData(data)
            .build()

        val filterWorker = OneTimeWorkRequest.Builder(FilterWorker::class.java)
            .build()
        val compressingWorker = OneTimeWorkRequest.Builder(CompressingWorker::class.java)
            .build()

        workManager
            .beginWith(filterWorker)
            .then(compressingWorker)
            .then(myWorker)
            .enqueue()

        workManager.getWorkInfoByIdLiveData(myWorker.id)
            .observe(this) {
                binding.textView.text = it.state.name

                if (it.state.isFinished) {
                    val outputData = it.outputData.getString(MyWorker.KEY_WORKER)
                    Toast.makeText(this, outputData, Toast.LENGTH_SHORT).show()
                }

            }
    }
}