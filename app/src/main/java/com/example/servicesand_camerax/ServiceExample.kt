package com.example.servicesand_camerax

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class ServiceExample: Service() {
    private val channelId = "160"


    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Thread(Runnable {
            while (true)
            {
        val calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss aaa z")
        val  dateTime = simpleDateFormat.format(calendar.time).toString()

        val intent = Intent(this, AfterNotificationActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = Notification.Builder(this,channelId)
            .setContentTitle("Time Service")
            .setContentText(dateTime.toString())
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentIntent(pendingIntent)
            .build()


                Thread.sleep(5000)
                startForeground(1,notification)
                Log.e("hello","*******************************")
            }
        }).start()

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}