package com.vishnu.newsapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vishnu.newsapp.R
import com.vishnu.newsapp.adapter.HeadlinesAdapter
import com.vishnu.newsapp.adapter.SportsAdapter
import com.vishnu.newsapp.adapter.TechnologyAdapter
import com.vishnu.newsapp.model.SportsNewsModel
import com.vishnu.newsapp.viewmodel.MainAcitivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SportsAdapter.Onitemclicklistener {


    lateinit var viewmodel: MainAcitivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel=ViewModelProviders.of(this).get(MainAcitivityViewModel::class.java)

        viewmodel.getcatogires()
        viewmodel.getsports()
        viewmodel.gettechnews()


        viewmodel.apply {
            data.observe(
                this@MainActivity, Observer {

                    recyclerview.apply{
                        adapter=HeadlinesAdapter(it.articles)

                    }
                }
            )
        }


        viewmodel.apply {
            data_sports.observe(this@MainActivity, Observer {
                sport_rv.apply {
                    layoutManager = LinearLayoutManager(applicationContext,RecyclerView.HORIZONTAL,false)
                   itemAnimator = DefaultItemAnimator()
                    adapter = SportsAdapter(it.articles,this@MainActivity  )


                }
            })
        }
        viewmodel.apply {
            data_tech.observe(this@MainActivity, Observer {
                tech_rv.apply {
                    layoutManager = LinearLayoutManager(applicationContext,RecyclerView.HORIZONTAL,false)
                    itemAnimator = DefaultItemAnimator()
                    adapter = TechnologyAdapter(it.articles )


                }
            })
        }


    }


    override fun onitemselected(item: SportsNewsModel.Article) {
        val intent = Intent(this, NewsDetailsPage::class.java)
        intent.putExtra("urlimage", item.urlToImage)
        intent.putExtra("description", item.description)
        intent.putExtra("title", item.title)

        intent.putExtra("content", item.content)

        intent.putExtra("author", item.author)

        intent.putExtra("publishedAt", item.publishedAt)

        startActivity(intent)
    }


}