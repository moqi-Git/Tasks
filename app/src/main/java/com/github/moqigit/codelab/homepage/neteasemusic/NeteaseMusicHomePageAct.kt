package com.github.moqigit.codelab.homepage.neteasemusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.github.moqigit.codelab.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_netease_music_home_page.*

class NeteaseMusicHomePageAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_netease_music_home_page)

        setupViewPager()
    }


    private fun setupViewPager(){
        val fragments = arrayListOf(
            UserFragment(),
            MusicFragment(),
            CommunityFragment(),
            VideoFragment()
        )

        nmhp_vp.adapter = object: FragmentStateAdapter(this){
            override fun getItemCount(): Int = fragments.size

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }
        }

        val tabNames = arrayListOf("我的", "发现", "云村", "视频")
        TabLayoutMediator(nmhp_tab_layout, nmhp_vp){ tab, position ->
            tab.text = tabNames[position]
        }.attach()

//        nmhp_vp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//
//        })
    }
}