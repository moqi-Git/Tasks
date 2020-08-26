package com.github.moqigit.codelab.plugins.http

import android.os.Build
import okhttp3.*
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 *
 * created by reol at 2020/8/26
 */
object XRetrofit {

    private var retrofit: Retrofit

    init {
        val client = OkHttpClient.Builder()
            .connectTimeout(12, TimeUnit.SECONDS)
            .addInterceptor(AddPostParamsInterceptor())
            .addInterceptor(TokenErrorInterceptor())
            .build()

        retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("")
            .build()
    }

    fun<T> createService(cls: Class<T>): T{
        return retrofit.create(cls)
    }
}

class AddPostParamsInterceptor: Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()
        if (req.method() == "POST"){
            val reqBody = req.body()
            if (reqBody is FormBody){
                val builder = FormBody.Builder()
                for (i in 0 until reqBody.size()){
                    builder.add(reqBody.name(i), reqBody.value(i))
                }
                builder.add("v", "1.0") // 额外参数可以全局获取的
                builder.add("device", Build.MANUFACTURER)
                val newReq = req.newBuilder()
                    .post(builder.build())
                    .build()
                return chain.proceed(newReq)
            }
        }
        return chain.proceed(req)
    }
}

class TokenErrorInterceptor: Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val originResponse = chain.proceed(chain.request())
        // 解析外层包装，处理全局异常
        val newResponse = Response.Builder().build()
        return newResponse
    }
}