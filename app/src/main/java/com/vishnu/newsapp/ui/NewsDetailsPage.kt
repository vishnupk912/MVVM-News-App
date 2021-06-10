package com.vishnu.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.vishnu.newsapp.R
import com.vishnu.newsapp.util.glideviewer
import kotlinx.android.synthetic.main.activity_news_details_page.*
import kotlinx.android.synthetic.main.itemlay_newheadlines.view.*

class NewsDetailsPage : AppCompatActivity() {

    var urlimage:String?=null


    var description:String?=null
    var title:String?=null

    var content:String?=null

    var author:String?=null
    var publishedAt:String?=null

    lateinit var  favimage:ImageView
    var check:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details_page)

        favimage=findViewById(R.id.favimage)
        urlimage= intent.getStringExtra("urlimage").toString()
        description= intent.getStringExtra("description").toString()
        title= intent.getStringExtra("title").toString()

        author= intent.getStringExtra("author").toString()

        publishedAt= intent.getStringExtra("publishedAt").toString()
        content= intent.getStringExtra("content").toString()


        imageview.glideviewer(urlimage)
        titletv.text=title
        if(author !=null)
        {
            descriptiontv.text=description

        }

        contenttv.text=content

        

       if(author==null)
       {
           publishedtv.text="News App.${publishedAt}"

       }
        else
       {
           publishedtv.text="${author}.${publishedAt}"

       }


        back.setOnClickListener {
            finish()
        }

        favimage.setOnClickListener {
            if(check==false)
            {
                favimage.setBackgroundResource(R.drawable.ic_star1);
                check=true
            }
       else if(check==true)
            {
                favimage.setBackgroundResource(R.drawable.ic_star);
                check=false
            }

        }

    }
}