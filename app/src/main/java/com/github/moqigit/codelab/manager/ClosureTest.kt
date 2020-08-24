package com.github.moqigit.codelab.manager

import android.os.Handler
import com.github.moqigit.common.kLogE


object ClosureTest {

    private val handler = Handler()
    private var workIndex = 0
    private var shouldGo = false

    fun doWork(index: Int){
        kLogE("before index = $index")

        handler.postDelayed({
            kLogE("after index = $index")

            if (shouldGo){
                shouldGo = false
                workIndex++
                doWork(workIndex)
            } else {
                shouldGo = true
                doWork(index)
            }

        }, 3000)
    }

    fun start(){
        doWork(workIndex)
    }

    fun stop(){
        handler.removeCallbacksAndMessages(null)
    }
}