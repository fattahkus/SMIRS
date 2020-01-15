package com.example.udamedicalsmirs.home._dokter.presenter

import com.example.udamedicalsmirs.home._dokter.data.ResultDokter
import com.example.udamedicalsmirs.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DokterPresenter (val dokterView: DokterView){

    fun getDokter(){
        NetworkConfig.service()
            .getDokter()
            .enqueue(object : Callback<ResultDokter>{
                override fun onFailure(call: Call<ResultDokter>, t: Throwable) {
                    dokterView.onFailed(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultDokter>,
                    response: Response<ResultDokter>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        dokterView.onSuccess(response.body()?.message,response.body()?.dokter)
                    }else {
                        dokterView.onFailed(response.body()?.message)
                    }
                }

            })
    }
}