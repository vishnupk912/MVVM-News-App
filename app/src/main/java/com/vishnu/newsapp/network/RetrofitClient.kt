package com.vishnu.newsapp.network

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient(appContext:Context)
{

    val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()

    lateinit var api:Apiinterface
    init {
            val  restadapter=Retrofit.Builder()
                .baseUrl(NetworkConstants().BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        api=restadapter.create(Apiinterface::class.java)
    }
}