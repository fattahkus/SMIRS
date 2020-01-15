package com.example.udamedicalsmirs.home._healthy_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._healthy_news.data.BeritaItem
import kotlinx.android.synthetic.main.activity_detail_news.*

class DetailNews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        val data = intent.getSerializableExtra("dataItem") as BeritaItem
        titleDetailNews.text = data.judulBerita
        descriptionDetailNews.text = data.isiBerita
        dateDetailNews.text = data.tglBerita
    }
}
