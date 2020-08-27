package com.github.moqigit.codelab.plugins.http

import com.github.moqigit.codelab.model.bean.MapiEntity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TestApiService {

    @FormUrlEncoded
    @POST("student/user/forgetpwd")
    fun requireVerificationCode(@Field("phone") phoneNumber: String): Call<MapiEntity>

}