package com.vishnu.newsapp.util

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.lang.Exception


    fun ImageView.glideviewer(url:String?)
    {

        try {
            if(context!=null)
            {
                Glide.with(context)
                    .load(url)
                    .into(this)
            }

        }
        catch (exception:Exception)
        {
            Log.d("exception",exception.localizedMessage)
        }
    }
