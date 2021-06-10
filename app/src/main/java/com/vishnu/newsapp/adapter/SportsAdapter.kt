package com.vishnu.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vishnu.newsapp.R
import com.vishnu.newsapp.model.SportsNewsModel
import com.vishnu.newsapp.util.glideviewer
import kotlinx.android.synthetic.main.itemlay_newheadlines.view.*
import kotlinx.android.synthetic.main.itemlay_newheadlines.view.imageview
import kotlinx.android.synthetic.main.itemlay_sports.view.*

class  SportsAdapter(val list:List<SportsNewsModel.Article>,val listner:Onitemclicklistener) :RecyclerView.Adapter<SportsAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.itemlay_sports, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: SportsAdapter.ViewHolder, position: Int) {
        val list_item = list[position]
        holder.itemView.apply {

            nametv.text = "${list_item.title}"

            imageview.glideviewer(list_item.urlToImage)
            setOnClickListener {
                listner.onitemselected(list_item)
            }


        }
    }

    interface  Onitemclicklistener
    {
        fun onitemselected(item:SportsNewsModel.Article)
    }

}

