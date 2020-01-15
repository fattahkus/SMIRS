package com.example.udamedicalsmirs.home._healthy_news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._healthy_news.data.BeritaItem
import kotlinx.android.synthetic.main.item_news.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class NewsAdapter(val data: List<BeritaItem?>?, val onClickNewsItem: onItemNewsClick): RecyclerView.Adapter<NewsAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
        holder.itemView.onClick {
            onClickNewsItem.item(data?.get(position))
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: BeritaItem?) {
            itemView.titleNews.text = get?.judulBerita
            itemView.lineNews.text = get?.isiBerita
        }
    }
    interface onItemNewsClick{
        fun item(item : BeritaItem?)
    }
}