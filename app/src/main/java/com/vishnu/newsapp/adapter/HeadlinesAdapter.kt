package com.vishnu.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vishnu.newsapp.R
import com.vishnu.newsapp.model.NewsHeadlinesModel
import com.vishnu.newsapp.util.glideviewer
import kotlinx.android.synthetic.main.itemlay_newheadlines.view.*

class  HeadlinesAdapter(val list:List<NewsHeadlinesModel.Article>) :RecyclerView.Adapter<HeadlinesAdapter.ViewHolder>()
{
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)


    override fun getItemCount():Int
    {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlinesAdapter.ViewHolder
    {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.itemlay_newheadlines,parent,false)
        return  ViewHolder(view)

    }

    override fun onBindViewHolder(holder: HeadlinesAdapter.ViewHolder, position: Int)
    {
        val list_item=list[position]
        holder.itemView.apply {
            headlinetv.text=list_item.title

            contenttv.text=list_item.description

            imageview.glideviewer(list_item.urlToImage)
        }
    }

}