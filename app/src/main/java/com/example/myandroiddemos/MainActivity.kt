package com.example.myandroiddemos

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import com.example.myandroiddemos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val channelID = "com.example.myandroiddemos.channel1"
    private var notificationManager : NotificationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createNotificationChannel(channelID, "Android Demo App", "this is testing notification")

        binding.button.setOnClickListener {
            displayNotification()
        }
    }

    private fun displayNotification() {
        val notificationID = 45
        val tapIntent = Intent(this, SecondActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            tapIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        //action1
        val tapIntentAction1 = Intent(this, DetailsActivity::class.java)
        val pendingIntentAction1 = PendingIntent.getActivity(
            this,
            0,
            tapIntentAction1,
            PendingIntent.FLAG_IMMUTABLE
        )
        val action1 = NotificationCompat.Action.Builder(0,"Details", pendingIntentAction1).build()

        //action2
        val tapIntentAction2 = Intent(this, SettingsActivity::class.java)
        val pendingIntentAction2 = PendingIntent.getActivity(
            this,
            0,
            tapIntentAction2,
            PendingIntent.FLAG_IMMUTABLE
        )
        val action2 = NotificationCompat.Action.Builder(0,"Settings", pendingIntentAction2).build()


        val notification = NotificationCompat.Builder(this, channelID)
            .setContentTitle("Android Demo App 1")
            .setContentText("this is testing notification 1")
            .setSmallIcon(android.R.drawable.ic_dialog_map)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .addAction(action1)
            .addAction(action2)
            .build()
        notificationManager?.notify(notificationID, notification)
    }

    private fun createNotificationChannel(id : String, name : String, desc : String) {

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            val imp = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(id, name, imp).apply {
                description = desc
            }
            notificationManager?.createNotificationChannel(notificationChannel)
        }
    }
}