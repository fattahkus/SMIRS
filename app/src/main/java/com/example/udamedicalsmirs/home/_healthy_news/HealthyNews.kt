package com.example.udamedicalsmirs.home._healthy_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._healthy_news.adapter.NewsAdapter
import com.example.udamedicalsmirs.home._healthy_news.data.BeritaItem
import com.example.udamedicalsmirs.home._healthy_news.presenter.NewsView
import com.example.udamedicalsmirs.home._healthy_news.presenter.PresenterNews
import kotlinx.android.synthetic.main.activity_healthy_news.*
import org.jetbrains.anko.startActivity

class HealthyNews : AppCompatActivity(), NewsView {


    private lateinit var presenter : PresenterNews
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healthy_news)

        presenter = PresenterNews(this)
        presenter.getNews()

    }
    override fun onSuccessGetNews(data: List<BeritaItem?>?) {
        rvNews.adapter = NewsAdapter(data,object : NewsAdapter.onItemNewsClick{
            override fun item(item: BeritaItem?) {
                startActivity<DetailNews>("dataItem" to item)
            }
        })
    }

    override fun onFailedGetNews(msg: String?) {

    }
}
