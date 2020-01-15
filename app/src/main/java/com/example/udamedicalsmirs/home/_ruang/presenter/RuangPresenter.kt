package com.example.udamedicalsmirs.home._ruang.presenter

import com.example.udamedicalsmirs.home._ruang.data.ResultRuang
import com.example.udamedicalsmirs.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RuangPresenter (val ruangView: RuangView) {

    fun getRuang(){
        NetworkConfig.service()
            .getRuang()
            .enqueue(object : Callback<ResultRuang>{
                override fun onFailure(call: Call<ResultRuang>, t: Throwable) {
                    ruangView.onFailed(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultRuang>, response: Response<ResultRuang>) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        ruangView.onSuccess(response.body()?.message,response.body()?.ruang)
                    }else{
                        ruangView.onFailed(response.body()?.message)
                    }
                }

            })
    }
}