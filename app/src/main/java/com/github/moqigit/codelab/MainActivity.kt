package com.github.moqigit.codelab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.github.moqigit.codelab.homepage.neteasemusic.NeteaseMusicHomePageAct
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        startAnim()

        naviToPage(NeteaseMusicHomePageAct::class.java)
    }

    private fun startAnim(){
        awv.pushValue(Math.random())
        handler.postDelayed({
            startAnim()
        }, 144)
    }

    private fun naviToPage(act: Class<*>){
        val i = Intent(this, act)

        startActivity(i)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}