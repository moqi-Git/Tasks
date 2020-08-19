package com.github.moqigit.codelab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.github.moqigit.codelab.adapter.MainAdapter
import com.github.moqigit.codelab.homepage.neteasemusic.NeteaseMusicHomePageAct
import com.github.moqigit.codelab.ui.test.AudioWaveTestAct
import com.github.moqigit.codelab.ui.test.QrCodeTestActivity
import com.github.moqigit.codelab.ui.test.TimeBroadcastTestAct
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_rv_entry.layoutManager = GridLayoutManager(this, 2)
        main_rv_entry.adapter = MainAdapter(arrayListOf("波","网","时","码")).apply {
            onItemClickListener = { p ->
                when(p){
                    0 -> { naviToPage(AudioWaveTestAct::class.java) }
                    1 -> { naviToPage(NeteaseMusicHomePageAct::class.java) }
                    2 -> { naviToPage(TimeBroadcastTestAct::class.java ) }
                    3 -> { naviToPage(QrCodeTestActivity::class.java) }
                    else -> {
                        Toast.makeText(this@MainActivity, "未实现", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun naviToPage(act: Class<*>){
        val i = Intent(this, act)

        startActivity(i)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

/**
 * todo list:
 * 1. 添加 DrawerLayout，实现左滑显示菜单
 * 2. 添加 具体的 RecyclerView（至少两个）
 */