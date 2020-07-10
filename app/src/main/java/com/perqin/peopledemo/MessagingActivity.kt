package com.perqin.peopledemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MessagingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messaging)

        title = "Chatting with ${intent.data?.authority}"
    }
}