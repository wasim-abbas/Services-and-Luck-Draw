package com.example.servicesand_camerax

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.LocaleList
import android.view.View
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    // declaring variables
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "160"
    private val description = "Test notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notification()
        btnstart.setOnClickListener(this)
        btnstop.setOnClickListener(this)
    }
    fun startService(v: View)
    {

        //format3.text = dateTime
        val serViceIntent = Intent(applicationContext,ServiceExample::class.java)
        startForegroundService(serViceIntent)
    }

    fun stopSercivce(v:View)
    {
        val intent =Intent(applicationContext,ServiceExample::class.java)
        stopService(intent)
    }

    fun notification() {

        // it is a class to notify the user of events that happen.
        // This is how you tell the user that something has happened in the
        // background.
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        btn.setOnClickListener {
            // pendingIntent is an intent for future use i.e after
            // the notification is clicked, this intent will come into action
            val intent = Intent(this, AfterNotificationActivity::class.java)

            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            // RemoteViews are used to use the content of
            // some different layout apart from the current activity layout
            val contentView = RemoteViews(packageName, R.layout.activity_after_notification)
            // checking if android version is greater than oreo(API 26) or not
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(channelId,description, NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.GREEN
                notificationChannel.enableVibration(false)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.ic_notifications)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_person))
                    .setContentTitle("Kotlin app")
                    .setContentText("This is notificaton for time")
                    .setShowWhen(true)
                    .setContentIntent(pendingIntent)
            }
            notificationManager.notify(1234, builder.build())
        }
    }

    override fun onClick(p0: View) {
        when(p0.id)
        {
            R.id.btnstart ->startService(p0)
            R.id.btnstop -> stopSercivce(p0)
        }
    }
}