package com.vishnu.newsapp.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.vishnu.newsapp.model.NewsHeadlinesModel
import com.vishnu.newsapp.model.SportsNewsModel
import com.vishnu.newsapp.model.TechnologyNewsModel
import com.vishnu.newsapp.network.Apiinterface
import com.vishnu.newsapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityRepo(val context:Context)
{
    val api=RetrofitClient(context).api


    fun getheadlines(onApiResult: (status:Boolean, error:String?, result:NewsHeadlinesModel?)->Unit)
    {
        api.getheadlines().enqueue(object:Callback<NewsHeadlinesModel>
        {
            override fun onFailure(call: Call<NewsHeadlinesModel>, t: Throwable)
            {
                onApiResult(false,"${t.localizedMessage}",null)
            }

            override fun onResponse(
                call: Call<NewsHeadlinesModel>,
                response: Response<NewsHeadlinesModel>
            ) {
                onApiResult(true,"",response.body())
            }
        })
    }


    fun getsportsnews(onApiResult: (status: Boolean, error: String?, result: SportsNewsModel?) -> Unit)
    {
        api.getsportnews().enqueue(object :Callback<SportsNewsModel>
        {
            override fun onFailure(call: Call<SportsNewsModel>, t: Throwable) {
                onApiResult(false,t.localizedMessage,null)
            }

            override fun onResponse(
                call: Call<SportsNewsModel>,
                response: Response<SportsNewsModel>
            ) {
                onApiResult(true,"",response.body())

            }

        })
    }


    fun gettechnews(onApiResult: (status: Boolean, error: String?, result: TechnologyNewsModel?) -> Unit)
    {
        api.gettechnologynews().enqueue(object :Callback<TechnologyNewsModel>
        {
            override fun onFailure(call: Call<TechnologyNewsModel>, t: Throwable) {
                onApiResult(false,t.localizedMessage,null)
            }

            override fun onResponse(
                call: Call<TechnologyNewsModel>,
                response: Response<TechnologyNewsModel>
            ) {
                onApiResult(true,"",response.body())

            }

        })
    }

}