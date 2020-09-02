package com.github.moqigit.codelab

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.github.moqigit.codelab.adapter.MainAdapter
import com.github.moqigit.codelab.homepage.neteasemusic.NeteaseMusicHomePageAct
import com.github.moqigit.codelab.manager.ClosureTest
import com.github.moqigit.codelab.model.bean.MapiEntity
import com.github.moqigit.codelab.plugins.http.TestApiService
import com.github.moqigit.codelab.plugins.http.XRetrofit
import com.github.moqigit.codelab.ui.test.AudioWaveTestAct
import com.github.moqigit.codelab.ui.test.QrCodeTestActivity
import com.github.moqigit.codelab.ui.test.TimeBroadcastTestAct
import com.github.moqigit.codelab.ui.video.VideoTestAct
import com.github.moqigit.codelab.words.WordsLearningAct
import com.github.moqigit.common.kLogE
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_rv_entry.layoutManager = GridLayoutManager(this, 2)
        main_rv_entry.adapter = MainAdapter(arrayListOf("波", "网", "时", "码", "词", "转", "影")).apply {
            onItemClickListener = { p ->
                when(p){
                    0 -> {
                        naviToPage(AudioWaveTestAct::class.java)
                    }
                    1 -> {
                        naviToPage(NeteaseMusicHomePageAct::class.java)
                    }
                    2 -> {
                        naviToPage(TimeBroadcastTestAct::class.java)
                    }
                    3 -> {
                        naviToPage(QrCodeTestActivity::class.java)
                    }
                    4 -> {
                        naviToPage(WordsLearningAct::class.java)
                    }
                    5 -> {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("ekwing://wisdomclassstu/container?type=main"))
//                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("ekwing://wisdomclassstu/main?from=launcher"))
                        startActivity(intent)
                    }
                    6 -> {
                        naviToPage(VideoTestAct::class.java)
                    }
                    else -> {
                        Toast.makeText(this@MainActivity, "未实现", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        XRetrofit.createService(TestApiService::class.java)
            .requireVerificationCode("17600975275")
            .enqueue(object : Callback<MapiEntity> {
                override fun onResponse(
                    call: Call<MapiEntity>,
                    response: Response<MapiEntity>
                ) {
                    val origin = response.body()
                    kLogE("origin data = $origin")
                }

                override fun onFailure(call: Call<MapiEntity>, t: Throwable) {
                    kLogE("error = ${t.message}; reason = ${t.cause}")
                }
            })
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