package com.github.moqigit.codelab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.moqigit.codelab.R
import kotlinx.android.synthetic.main.item_main_grid.view.*

class MainAdapter(private val mList: List<String>): RecyclerView.Adapter<EmptyViewHolder>() {
    var onItemClickListener: ((position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmptyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_grid, parent, false)
        return EmptyViewHolder(view)
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: EmptyViewHolder, position: Int) {
        holder.itemView.item_main_grid_tv_entry.text = mList[position]
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(position)
        }
    }
}