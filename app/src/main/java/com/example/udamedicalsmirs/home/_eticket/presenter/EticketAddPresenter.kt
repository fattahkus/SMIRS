package com.example.udamedicalsmirs.home._eticket.presenter

import com.example.udamedicalsmirs.home._eticket.data.ResultAddTicket
import com.example.udamedicalsmirs.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EticketAddPresenter (val eticketView: EticketView) {
    fun addTicket(nobooking : String?, orderticket : String?,
                  namapasien : String?, nohp : String?,
                  jenisperiksa : String?, namadokter : String?){
        NetworkConfig.service()
            .newTicket(nobooking,orderticket,namapasien,nohp,jenisperiksa,namadokter)
            .enqueue(object : Callback<ResultAddTicket>{
                override fun onFailure(call: Call<ResultAddTicket>, t: Throwable) {
                    eticketView.onFailedAdd(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultAddTicket>,
                    response: Response<ResultAddTicket>
                ) {
                    if (response.isSuccessful && response.body()?.status ==200){
                        eticketView.onSuccessAdd(response.body()?.message)
                    }else{
                        eticketView.onSuccessAdd(response.body()?.message)
                    }
                }

            })

    }
}