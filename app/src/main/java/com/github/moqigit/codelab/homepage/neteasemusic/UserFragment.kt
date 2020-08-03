package com.github.moqigit.codelab.homepage.neteasemusic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.moqigit.codelab.R
import kotlinx.android.synthetic.main.fragment_nmhp_user.*

/**
 *
 * created by reol at 2020/8/1
 */
class UserFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nmhp_user, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        insertFakeData()
        initEvent()
    }

    private fun initEvent(){
        nmhp_user_info_layout.post {
            nmhp_nested_root.setKeepDistance((nmhp_user_info_content.top - nmhp_user_info_ph_title.bottom).toFloat())
        }
    }

    private fun insertFakeData(){
        nmhp_user_info_name.text = "万俟霜风"
        nmhp_user_info_tag.text = "LV.8"
        nmhp_user_info_vip.text = "开通vip"

        Glide.with(this)
            .load(R.drawable.res_avatar_270_270)
            .apply(RequestOptions().circleCrop())
            .into(nmhp_user_info_avatar)

        val sb = StringBuilder()
        repeat(80){
            sb.append(it).append("\n")
        }
        nmhp_user_tv_long.text = sb.toString()
    }
}