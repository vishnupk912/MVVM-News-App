package com.vishnu.newsapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vishnu.newsapp.R
import com.vishnu.newsapp.model.TechnologyNewsModel
import com.vishnu.newsapp.ui.NewsDetailsPage
import com.vishnu.newsapp.util.glideviewer
import kotlinx.android.synthetic.main.itemlay_newheadlines.view.imageview
import kotlinx.android.synthetic.main.itemlay_sports.view.*

class  TechnologyAdapter(val list:List<TechnologyNewsModel.Article>) :RecyclerView.Adapter<TechnologyAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TechnologyAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.itemlay_sports, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: TechnologyAdapter.ViewHolder, position: Int) {
        val list_item = list[position]
        holder.itemView.apply {

            nametv.text = "${list_item.title}"

            imageview.glideviewer(list_item.urlToImage)
            setOnClickListener {
                val intent = Intent(context, NewsDetailsPage::class.java)
                intent.putExtra("urlimage", list_item.urlToImage)
                intent.putExtra("description", list_item.description)
                intent.putExtra("title", list_item.title)

                intent.putExtra("content", list_item.content)

                intent.putExtra("author", list_item.author)

                intent.putExtra("publishedAt", list_item.publishedAt)
                context.startActivity(intent)
            }
            }


        }


}




