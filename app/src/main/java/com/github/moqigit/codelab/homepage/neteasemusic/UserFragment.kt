package com.github.moqigit.codelab.homepage.neteasemusic

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.moqigit.codelab.R
import com.github.moqigit.codelab.adapter.UserFavAdapter
import com.github.moqigit.codelab.model.bean.UserFavItemBean
import com.github.moqigit.common.kLogE
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
        // setup nested scroll
        nmhp_user_info_layout.post {
            val scrollDistance = nmhp_user_info_content.top - nmhp_user_info_ph_title.bottom
            nmhp_nested_root.setKeepDistance(scrollDistance.toFloat())

            val params = nmhp_nested_root.layoutParams
            params.height = nmhp_nested_root.height + scrollDistance
            nmhp_nested_root.layoutParams = params
        }

        nmhp_user_info_avatar.setOnClickListener {
            naviTo(MusicFragment())
        }

        val vm = ViewModelProvider(requireActivity()).get(NTestViewModel::class.java)
        vm.fakeData.observe(viewLifecycleOwner){
                Log.e("asdfg", "fakeData = $it")
            }
        Handler().postDelayed({ vm.start() }, 4000)
    }


    override fun onStart() {
        super.onStart()
        Log.e("asdfg", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("asdfg", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.e("asdfg", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("asdfg", "onDestroy")
    }

    protected fun naviTo(fragment: Fragment, canBack: Boolean = true){
        val act = activity?:return
        val trans = act.supportFragmentManager.beginTransaction()
        trans.add(R.id.container, fragment, fragment.tag)
        if (canBack) trans.addToBackStack(fragment.tag)
        trans.commit()
    }

    private fun insertFakeData(){
        nmhp_user_info_name.text = "万俟霜风"
        nmhp_user_info_tag.text = "LV.8"
        nmhp_user_info_vip.text = "开通vip"

        Glide.with(this)
            .load(R.drawable.res_avatar_270_270)
            .apply(RequestOptions().circleCrop())
            .into(nmhp_user_info_avatar)

        val favList = arrayListOf(
            UserFavItemBean(R.drawable.ic_chat, "标题1", "开启自信之门"),
            UserFavItemBean(R.drawable.ic_chat, "标题1", "开启自信之门"),
            UserFavItemBean(R.drawable.ic_chat, "标题1", "开启自信之门"),
            UserFavItemBean(R.drawable.ic_chat, "标题1", "开启自信之门"),
            UserFavItemBean(R.drawable.ic_chat, "标题1", "开启自信之门")
        )
        val userFavAdapter = UserFavAdapter(favList)
        nmhp_user_info_rv_mine.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        nmhp_user_info_rv_mine.adapter = userFavAdapter
    }
}