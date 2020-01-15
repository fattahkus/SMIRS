package com.example.udamedicalsmirs.home._healthy_news.presenter

import com.example.udamedicalsmirs.home._healthy_news.data.BeritaItem

interface NewsView {
    fun onSuccessGetNews(data : List<BeritaItem?>?)
    fun onFailedGetNews(msg : String?)
}