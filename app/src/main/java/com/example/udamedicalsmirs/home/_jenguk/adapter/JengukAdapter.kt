package com.example.udamedicalsmirs.home._jenguk.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._jenguk.data.DataPasien
import kotlinx.android.synthetic.main.card_services.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class JengukAdapter (var data : List<DataPasien>?, val onClicked : onItemClick): RecyclerView.Adapter<JengukAdapter.MyHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_services,parent,false)
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
        fun onBind(get: DataPasien?) {
            itemView.tvnamaPasien.text = get?.namaPasien
            itemView.tvnoPasien.text = get?.hpPasien
        }

    }

    interface onItemClick{
        fun item(pasien: DataPasien?)
    }



}