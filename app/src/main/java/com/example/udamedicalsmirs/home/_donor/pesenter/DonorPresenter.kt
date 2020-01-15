package com.example.udamedicalsmirs.home._donor.pesenter

import com.example.udamedicalsmirs.home._donor.data.ResultDonor
import com.example.udamedicalsmirs.home._donor.data.ResultMemberDonor
import com.example.udamedicalsmirs.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DonorPresenter (val donorView: DonorView){

    fun newMember(iddonor : String?, idUser: String?, goldarah : String?, pointdonor : String?, donasidonor : String?){
        NetworkConfig.service()
            .newMember(iddonor,idUser, goldarah, pointdonor, donasidonor)
            .enqueue(object : Callback<ResultDonor>{
                override fun onFailure(call: Call<ResultDonor>, t: Throwable) {
                    donorView.onFailedDonor(t.localizedMessage)
                }
                override fun onResponse(call: Call<ResultDonor>, response: Response<ResultDonor>) {
                    if (response.isSuccessful && response.body()?.status == 200 ){
                        donorView.onSuccessDonor(response.body()?.message)
                    }else {
                        if(goldarah.isNullOrEmpty()){
                            donorView.onFailedDonor(response.body()?.message)
                        }
                        donorView.onFailedDonor(response.body()?.message)
                    }
                }

            })
    }

    fun getMember(nohp: String?){
        NetworkConfig.service()
            .getMember(nohp)
            .enqueue(object : Callback<ResultMemberDonor>{
                override fun onFailure(call: Call<ResultMemberDonor>, t: Throwable) {
                    donorView.onFailedMember(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultMemberDonor>,
                    response: Response<ResultMemberDonor>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200 ){
                        donorView.onSuccessMember(response.body()?.message,response.body()?.ticket, null)
                    }else {
                        donorView.onFailedMember(response.body()?.message)
                    }
                }

            })
    }
}