package com.github.moqigit.codelab.ui.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.github.moqigit.codelab.R
import kotlinx.android.synthetic.main.activity_audio_wave_test.*

class AudioWaveTestAct : AppCompatActivity() {

    private val testVolumeList = arrayListOf<Double>(
        0.1, 0.1, 0.1,
        0.2, 0.27, 0.4, 0.45, 0.52, 0.7, 0.8, 1.0, 0.7, 0.3, 0.1,
        0.1, 0.1, 0.1, 0.1, 0.1, 0.1,
        0.2, 0.6, 0.9, 0.3,
        0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1
    )

    private val handler = Handler()
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_wave_test)

        start()
    }

    private fun start() {
        if (index == testVolumeList.size) {
            index = 0
        }
        awv.pushValue(testVolumeList[index])
        index++
        handler.postDelayed({ start() }, 100)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}