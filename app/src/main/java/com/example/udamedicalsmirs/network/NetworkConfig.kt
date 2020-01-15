package com.example.udamedicalsmirs.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header

object NetworkConfig {

    fun getInterceptor():OkHttpClient {
        val interceptor  = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://64.225.15.4/smirs_server/index.php/Api/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun service() = getRetrofit().create(SmirsService::class.java)
}