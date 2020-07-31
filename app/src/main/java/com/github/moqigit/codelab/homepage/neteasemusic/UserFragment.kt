package com.github.moqigit.codelab.homepage.neteasemusic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.moqigit.codelab.R

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
        val view = inflater.inflate(R.layout.fragment_place_holder, container, false)
        return view
    }
}