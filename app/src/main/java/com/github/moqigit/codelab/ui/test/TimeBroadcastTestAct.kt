package com.github.moqigit.codelab.ui.test

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.moqigit.codelab.R
import com.github.moqigit.codelab.receiver.TimeRelativeReceiver

class TimeBroadcastTestAct : AppCompatActivity() {

    private lateinit var receiver: TimeRelativeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_broadcast_test)

        receiver = TimeRelativeReceiver()

        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_TIME_TICK)
            addAction(Intent.ACTION_TIME_CHANGED)
            addAction(Intent.ACTION_TIMEZONE_CHANGED)
        }

        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(receiver)
    }
}