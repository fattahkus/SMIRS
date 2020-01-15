package com.example.udamedicalsmirs.home._jenguk.presenter

import com.example.udamedicalsmirs.home._jenguk.data.ResultPasien
import com.example.udamedicalsmirs.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PasienPresenter (val pasienView: PasienView){


    fun getPasien(){
        NetworkConfig.service()
            .getPasien()
            .enqueue(object : Callback<ResultPasien>{
                override fun onFailure(call: Call<ResultPasien>, t: Throwable) {
                    pasienView.onErrorPasien(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultPasien>,
                    response: Response<ResultPasien>
                ) {
                    if (response.body()?.status == 200 && response.isSuccessful){
                        pasienView.onSuccessPasien(response.body()?.data)
                    } else{
                        pasienView.onErrorPasien(response.body()?.message)
                    }
                }

            })
    }

    fun searchPasien(keyword : String?){
        NetworkConfig.service()
            .search(keyword ?: "")
            .enqueue(object : Callback<ResultPasien>{
                override fun onFailure(call: Call<ResultPasien>, t: Throwable) {
                    pasienView.onErrorFilterPasien(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultPasien>,
                    response: Response<ResultPasien>
                ) {
                    if (response.body()?.status == 200 && response.isSuccessful){
                        pasienView.onSuccessFilterPasien(response.body()?.data)
                    }else{
                        pasienView.onErrorPasien(response.body()?.message)
                    }
                }

            })
    }
}