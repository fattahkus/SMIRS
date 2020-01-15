package com.example.udamedicalsmirs.login.presenter

import com.example.udamedicalsmirs.login.data.ResultLogin
import com.example.udamedicalsmirs.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginPresenter(val loginView: LoginView) {

    fun loginUser(email: String?, password: String?,nohp: String?) {
        NetworkConfig.service()
            .login(email ?: "",nohp ?: "",password ?: "" )
            .enqueue(object : Callback<ResultLogin> {
                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onErrorLogin(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                    if (response.body()?.status == 200 && response.isSuccessful) {
                        if (email!!.isNotEmpty() or nohp!!.isNotEmpty()) {
                            loginView.onSuccessLogin(
                                response.body()?.user,
                                response.body()?.message
                            )
                        } else {
                            loginView.onErrorLogin(response.body()?.message)
                        }

                    } else {
                        loginView.onErrorLogin(response.body()?.message)
                    }

                }

            })
    }
}


//                        if(response.isSuccessful == email.isNullOrBlank()){
//                            response.body()?.user?.userHp?.isNotEmpty()
//                            loginView.onSuccessLogin(response.body()?.user,response.body()?.message)
//                        }else if(response.isSuccessful == nohp.isNullOrBlank()){
//                            response.body()?.user?.userEmail?.isNotEmpty()
//                            loginView.onSuccessLogin(response.body()?.user,response.body()?.message)
//                        }
//                        loginView.onSuccessLogin(response.body()?.user,response.body()?.message)
