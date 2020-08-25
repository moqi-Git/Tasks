package com.github.moqigit.codelab.manager

import android.os.Handler
import com.github.moqigit.common.kLogE
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract


object ClosureTest {

    private val handler = Handler()
    private var workIndex = 0
    private var shouldGo = false

//    fun doWork(index: Int){
//        kLogE("before index = $index")
//
//        handler.postDelayed({
//            kLogE("after index = $index")
//
//            if (shouldGo){
//                shouldGo = false
//                workIndex++
//                doWork(workIndex)
//            } else {
//                shouldGo = true
//                doWork(index)
//            }
//
//        }, 3000)
//    }

    fun start() {
//        doWork(workIndex)
        val s = "sss"

        val a1 = ArrayList<String>().apply {
            add("Hello")
            add(s)
        }
        a1.clear()

        val b1 = ArrayList<String>().xapply {
            add("Hello")
            add(s)
        }
        b1.clear()

        val c1 = ArrayList<String>().capply {
            add("Hello")
            add(s)
        }
        c1.clear()

        val arrayList2 = ArrayList<String>()
        arrayList2.add("Hello")
        arrayList2.add(s)
        arrayList2.clear()
    }

    fun stop() {
        handler.removeCallbacksAndMessages(null)
    }

//    @ExperimentalContracts
    private fun <T> T.xapply(block: T.() -> Unit): T {
        block()
        return this
    }

    private inline fun <T> T.capply(block: T.() -> Unit): T {
        block()
        return this
    }
}