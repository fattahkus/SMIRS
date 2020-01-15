package com.example.udamedicalsmirs.home._ruang.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._ruang.data.RuangItem
import kotlinx.android.synthetic.main.item_ruang.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class RuangAdapter (val data : List<RuangItem?>?, val onClicked : onItemClickRuang) : RecyclerView.Adapter<RuangAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ruang,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
        holder.itemView.onClick {
            onClicked.item(data?.get(position))
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: RuangItem?) {
            itemView.tvNameRuang.text = get?.namaRuang
        }

    }

    interface onItemClickRuang{
        fun item(item : RuangItem?)
    }

}