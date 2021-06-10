package com.vishnu.newsapp.network

import com.vishnu.newsapp.model.SportsNewsModel
import com.vishnu.newsapp.model.NewsHeadlinesModel
import com.vishnu.newsapp.model.TechnologyNewsModel
import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface
{
    @GET("top-headlines?country=in&apiKey=6d93bdcc44f34ee59fbdaef33781f77d")
    fun getheadlines(): Call<NewsHeadlinesModel>


    @GET("top-headlines?country=in&category=sports&apiKey=6d93bdcc44f34ee59fbdaef33781f77d")
    fun getsportnews(): Call<SportsNewsModel>



    @GET("https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=6d93bdcc44f34ee59fbdaef33781f77d")
    fun gettechnologynews(): Call<TechnologyNewsModel>



}