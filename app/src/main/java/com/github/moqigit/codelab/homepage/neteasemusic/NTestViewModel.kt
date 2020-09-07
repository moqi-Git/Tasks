package com.github.moqigit.codelab.homepage.neteasemusic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NTestViewModel: ViewModel() {

    val fakeData = MutableLiveData<String>("init")

    fun start(){
        fakeData.value = "start"
    }

}