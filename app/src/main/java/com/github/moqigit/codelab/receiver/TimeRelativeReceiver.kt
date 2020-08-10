package com.github.moqigit.codelab.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.github.moqigit.common.kLogE
import java.util.*

class TimeRelativeReceiver: BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null){
            when(intent.action){
                Intent.ACTION_TIME_TICK -> {
                    kLogE("time tick: system time is ${Date(System.currentTimeMillis()).toString()}")
                }
                Intent.ACTION_TIME_CHANGED -> {
                    kLogE("time changed: system time is ${Date(System.currentTimeMillis()).toString()}")
                }
                Intent.ACTION_TIMEZONE_CHANGED -> {
                    kLogE("timezone changed: system time is ${Date(System.currentTimeMillis()).toString()}")
                }
            }
        }
    }
}