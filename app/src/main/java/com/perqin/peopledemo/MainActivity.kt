package com.perqin.peopledemo

import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.graphics.drawable.IconCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startMessagingButton.setOnClickListener {
            val notification = NotificationCompat.Builder(this, "messaging")
                    .setStyle(NotificationCompat.MessagingStyle(getPerson())
                            .addMessage("Hello", System.currentTimeMillis(), getPerson()))
                    .setShortcutId("yukino")
                    .setContentTitle("Yukino")
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher_round))
                    .setContentText("Hello")
                    .setBubbleMetadata(NotificationCompat.BubbleMetadata.Builder()
                        .setDesiredHeight(600)
                        .setIcon(IconCompat.createWithResource(this, R.mipmap.ic_launcher_round))
                        .setIntent(PendingIntent.getActivity(this, 0,
                            Intent(this, MessagingActivity::class.java), 0))
                        .build())
                    .build()
            NotificationManagerCompat.from(this).notify(1, notification)
        }
    }
}
