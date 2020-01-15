package com.example.udamedicalsmirs.home._healthy_news.presenter

import com.example.udamedicalsmirs.home._healthy_news.data.ResultNews
import com.example.udamedicalsmirs.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterNews (val newsView: NewsView){
    fun getNews(){
        NetworkConfig.service()
            .getNews()
            .enqueue(object : Callback<ResultNews>{
                override fun onFailure(call: Call<ResultNews>, t: Throwable) {
                    newsView.onFailedGetNews(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultNews>, response: Response<ResultNews>) {
                    if (response.isSuccessful){
                        newsView.onSuccessGetNews(response.body()?.berita)
                    } else{
                        newsView.onFailedGetNews(response.body()?.message)
                    }
                }

            })
    }
}