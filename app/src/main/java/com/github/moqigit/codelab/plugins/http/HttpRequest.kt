package com.github.moqigit.codelab.plugins.http

// 最简化的http请求定义，然鹅Retrofit无法用相同的形式。
interface HttpRequest {

    fun get(url: String, params: HashMap<String, String>, cb: CallBack)

    fun post(url: String, params: HashMap<String, String>, cb: CallBack)

    fun download(url: String, params: HashMap<String, String>, fullFilePath: String, cb: ProcessCallBack)

    fun upload(url: String, params: HashMap<String, String>, fullFilePath: String, cb: ProcessCallBack)

    interface CallBack{
        fun onSuccess()

        fun onFailed(errCode: Int, errMsg: String)
    }

    interface ProcessCallBack{
        fun onSuccess()

        fun onLoading(percent: Float)

        fun onFailed(errCode: Int, errMsg: String)
    }
}