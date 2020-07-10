package com.perqin.peopledemo

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.Person
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat

fun Context.getPerson() = Person.Builder()
    .setName("Yukino")
    .setIcon(IconCompat.createWithResource(this, R.mipmap.ic_launcher_round))
    .build()

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManagerCompat.from(this).createNotificationChannel(
                NotificationChannel("messaging", "Messaging", NotificationManager.IMPORTANCE_DEFAULT)
            )
        }
        ShortcutManagerCompat.addDynamicShortcuts(this, listOf(
            ShortcutInfoCompat.Builder(this, "yukino")
                .setShortLabel("Yukino")
                .setLongLabel("Chat with Yukino")
                .setIcon(IconCompat.createWithResource(this, R.mipmap.ic_launcher_round))
                .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("people-demo://yukino")))
                .setLongLived(true)
                .setPerson(getPerson())
                .build()
        ))

    }
}
