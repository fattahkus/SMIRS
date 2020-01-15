package com.example.udamedicalsmirs.home._dokter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._dokter.data.DokterItem
import kotlinx.android.synthetic.main.item_jadwal.view.*

class DokterAdapter (val data : List<DokterItem?>?) : RecyclerView.Adapter<DokterAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_jadwal,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: DokterItem?) {
            itemView.itemNamaDokter.text = get?.namaDokter
            itemView.itemSpesialis.text = get?.spesialisDokter
            itemView.itemWaktuDokter.text = get?.waktuDokter
        }

    }
}