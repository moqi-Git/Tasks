package com.github.moqigit.codelab.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.moqigit.codelab.R
import com.github.moqigit.codelab.model.bean.UserFavItemBean

/**
 *
 * created by reol at 2020/8/6
 */
class UserFavAdapter(private val favList: List<UserFavItemBean>):
    RecyclerView.Adapter<EmptyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmptyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_info_mine, parent, false)
        return EmptyViewHolder(view)
    }

    override fun getItemCount(): Int = favList.size

    override fun onBindViewHolder(holder: EmptyViewHolder, position: Int) {

    }


}