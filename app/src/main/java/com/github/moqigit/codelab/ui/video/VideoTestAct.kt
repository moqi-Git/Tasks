package com.github.moqigit.codelab.ui.video

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.ViewGroup
import com.github.moqigit.codelab.R
import com.github.moqigit.common.kLogE
import kotlinx.android.synthetic.main.activity_video_test.*
import tv.danmaku.ijk.media.player.IjkLibLoader
import tv.danmaku.ijk.media.player.IjkMediaPlayer

class VideoTestAct : AppCompatActivity() {

    private lateinit var mVideoUrl: String
    private lateinit var ijkMediaPlayer: IjkMediaPlayer

    private var shouldPlay = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_test)

        IjkMediaPlayer.loadLibrariesOnce {
            kLogE("load s = $it")
        }
        IjkMediaPlayer.native_profileBegin("libijkplayer.so")

        mVideoUrl = getExternalFilesDir("video")!!.absolutePath + "/test.mp4"

        ijkMediaPlayer = IjkMediaPlayer().apply {
            setOnPreparedListener {
                if (shouldPlay) it.start()
            }
            setOnSeekCompleteListener {
                if (shouldPlay) it.start()
            }
//            setOnMediaCodecSelectListener { iMediaPlayer, s, p1, p2 ->
//                return@setOnMediaCodecSelectListener s
//            }
        }

        val surfaceView = SurfaceView(this, ).apply {
//            holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
            holder.addCallback(object : SurfaceHolder.Callback {
                override fun surfaceCreated(holder: SurfaceHolder?) {
                    playVideo()
                }

                override fun surfaceChanged(
                    holder: SurfaceHolder?,
                    format: Int,
                    width: Int,
                    height: Int
                ) {

                }

                override fun surfaceDestroyed(holder: SurfaceHolder?) {
                        ijkMediaPlayer?.release()
                }
            })
        }
        video_container.addView(surfaceView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
    }

    private fun playVideo(){
        ijkMediaPlayer.reset()
        ijkMediaPlayer.setDataSource(this, Uri.parse(mVideoUrl))
        ijkMediaPlayer.prepareAsync()
        shouldPlay = true
    }
}