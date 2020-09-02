package com.github.moqigit.xplayer

import com.github.moqigit.common.kLogE
import tv.danmaku.ijk.media.player.IjkMediaPlayer

class Xplayer {

    init {
        IjkMediaPlayer.loadLibrariesOnce { s ->
            kLogE("load so result: $s")
        }
        IjkMediaPlayer.native_profileBegin("libijkplayer")
    }

    
}