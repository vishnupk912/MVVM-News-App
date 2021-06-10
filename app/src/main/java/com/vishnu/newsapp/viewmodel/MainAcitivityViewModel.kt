package com.vishnu.newsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.vishnu.newsapp.model.NewsHeadlinesModel
import com.vishnu.newsapp.model.SportsNewsModel
import com.vishnu.newsapp.model.TechnologyNewsModel
import com.vishnu.newsapp.repo.MainActivityRepo

class MainAcitivityViewModel (val app:Application):AndroidViewModel(app)
{
    val repo=MainActivityRepo(app)
    var data=MutableLiveData<NewsHeadlinesModel>()

    val errordata=MutableLiveData<String>()


    var data_sports=MutableLiveData<SportsNewsModel>()

    var data_tech=MutableLiveData<TechnologyNewsModel>()


    fun getcatogires()=repo.getheadlines(onApiResult = {
        status, error, result ->
        when(status)
        {
            true->
            {
                data.value=result
            }
            false->errordata.value=error
        }
    })

    fun getsports()=repo.getsportsnews(onApiResult = {
            status, error, result ->
        when(status)
        {
            true->
            {
                data_sports.value=result
            }
            false->errordata.value=error
        }
    })

    fun gettechnews()=repo.gettechnews(onApiResult = {
            status, error, result ->
        when(status)
        {
            true->
            {
                data_tech.value=result
            }
            false->errordata.value=error
        }
    })

}