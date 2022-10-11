package com.example.myandroiddemos

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.databinding.DataBindingUtil
import com.example.myandroiddemos.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        receiveInput()
    }

    private fun receiveInput(){
        val KEY_REPLY = "key reply"
        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if(remoteInput != null){
            val inputString = remoteInput.getCharSequence(KEY_REPLY)

            binding.textView2.text = inputString.toString()
        }


        val channelID = "com.example.myandroiddemos.channel1"
        val notificationID = 45

        val repliedNotification = NotificationCompat.Builder(this, channelID)
            .setSmallIcon(android.R.drawable.arrow_down_float)
            .setContentText("Replied")
            .build()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(notificationID, repliedNotification)
    }
}