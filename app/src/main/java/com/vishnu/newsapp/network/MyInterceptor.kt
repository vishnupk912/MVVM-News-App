package com.vishnu.newsapp.network

import okhttp3.Interceptor
import okhttp3.RequestBody
import okhttp3.Response

class MyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        //Is it possible to change it in JSON? Or how do I add paramenters to this body?
        val body: RequestBody? = chain.request().body

        return chain.proceed(chain.request())
    }
}